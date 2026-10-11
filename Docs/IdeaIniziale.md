# DietNGo — Brief di progetto per Claude Code

> Nome: **DietNGo** (definitivo).
> Questo documento descrive cosa costruire, perché, con quali vincoli e da dove partire.

## Aggiornamento del 2026-10-11

Questo file è il punto di partenza, non il progetto definitivo. Dove contraddice il file `Docs/Ai/DECISIONS.md`, vale quel file.

Cambiato da quando il file è stato scritto:
- Ci sarà un database remoto su Supabase. Il database locale SQLite ne è lo specchio.
- L'app ha più utenti, ciascuno con i suoi dati e il suo account: accesso con Google, con Apple o con un account proprio.
- Nel progetto il modulo `app` è l'orologio e il modulo `mobile` è il telefono. Il modulo `shared` non c'è ancora.
- Le «Fasi» si chiamano «Tappe».

Ancora da pianificare, prima di scrivere il codice:
1. Cosa potrà fare l'app.
2. Che schermate avrà, sull'orologio e sul telefono.
3. Come sarà il database.
4. Altro, se serve.

Durante il lavoro vanno spiegati Kotlin, il modo in cui si fa ogni cosa e le motivazioni delle scelte.

---

## 1. Chi sono e come voglio lavorare

- Sono uno sviluppatore C# / .NET (anche VB6, SQL Server, un po' di .NET MAUI). **Non conosco Kotlin né l'ecosistema Android nativo.**
- Voglio che l'app la scriva tu, ma voglio **imparare** strada facendo:
  - spiega brevemente le scelte non ovvie (Gradle, permessi, ciclo di vita, coroutine…);
  - quando utile, fai un parallelo con C#/.NET (es. `suspend`/coroutine ≈ `async/await`, Room ≈ EF Core + SQLite, `Flow` ≈ `IObservable`/`IAsyncEnumerable`);
  - procedi **a piccoli passi verificabili**: ogni fase deve compilare e girare prima di passare alla successiva.
- **Convenzioni di codice (obbligatorie):**
  - **commenti in italiano**;
  - **nomi in inglese** (classi, metodi, variabili, package, tabelle, colonne).
- Prima di decisioni architetturali grosse o di aggiungere dipendenze pesanti, **chiedimi**.
- Usa sempre le **versioni stabili più recenti** delle librerie: verifica online invece di affidarti alla memoria.

---

## 2. Il problema da risolvere

Ho un **Pixel Watch 4** (modello LTE, ma senza eSIM) e uno smartphone Android.
Voglio registrare **i pasti che mangio abitualmente** nel modo più rapido possibile:

- **un tocco sull'orologio**, oppure
- **a voce**, tramite Gemini sull'orologio.

Ho scartato Google Health (ex Fitbit) perché:
- non permette di salvare "pasti" composti da più piatti;
- obbliga a inserire calorie/energia/macronutrienti, che **non conosco e non mi interessano**
  (cucino io, so gli ingredienti e grosso modo i grammi totali, nient'altro);
- non permette di salvare un cibo come preferito senza registrarlo come mangiato;
- non consente di registrare cibo dall'orologio.

**Quindi l'app è autonoma: niente Google Health, niente Health Connect (per ora), nessun valore nutrizionale obbligatorio.**

---

## 3. Il canale vocale (già testato)

Gemini non può chiamare app di terze parti per azioni personalizzate (AppFunctions è in anteprima privata).
**Soluzione adottata: Google Tasks come "buca delle lettere".**

Test già fatto con esito positivo:
- dico a Gemini sull'orologio: *"Aggiungi un task pasto riso cantonese"*;
- Gemini chiede **una conferma con un tocco** (normale, accettabile);
- il task finisce nella **lista predefinita** ("My list" / "Le mie attività"), **non** in una lista con nome specifico;
- a volte Gemini mette una scadenza "adesso", che genera una notifica sul telefono con "Segna come completata";
  se la tocco, il task finisce tra i **completati**.

Quindi l'app deve:
- leggere la lista predefinita (`@default` nella Google Tasks API);
- leggere **anche i task completati e nascosti** (`showCompleted=true`, `showHidden=true`);
- considerare come pasti **solo i task il cui titolo inizia con il prefisso `pasto`**
  (case-insensitive, tollerante a spazi/punteggiatura: "Pasto: riso cantonese", "pasto riso cantonese");
- tutti gli altri task della lista **non vanno toccati**.

---

## 4. Funzionalità

### MVP (obbligatorio)

**Telefono**
1. **Gestione pasti salvati** (CRUD): nome, ingredienti come testo libero (opzionale), grammi indicativi (opzionale), note (opzionale), preferito sì/no, ordine di visualizzazione, **alias** per il riconoscimento vocale (es. "cantonese", "riso alla cantonese").
2. **Registrazione con un tocco** di un pasto salvato (data/ora = adesso, modificabile).
3. **Storico** delle registrazioni, raggruppato per giorno, con possibilità di modificare/eliminare una voce.
4. **Import da Google Tasks** (vedi sezione 6).
5. **Coda "da assegnare"**: task importati che non corrispondono a nessun pasto salvato
   → l'utente li assegna a un pasto esistente, ne crea uno nuovo, o li scarta.

**Orologio**
6. **Tile** con i pasti preferiti come bottoni (3–4 visibili + "altro" che apre l'app).
7. **App Wear OS** minimale: lista completa dei pasti, un tocco = registrazione.
8. Feedback: **vibrazione breve** + conferma visiva.
9. **Coda offline**: se il telefono non è raggiungibile, la registrazione resta in coda sull'orologio e viene inviata appena possibile, **mantenendo l'orario originale**.

### Fasi successive (non ora, ma l'architettura deve permetterle)
- Bottone **microfono** nella tile/app orologio (`RecognizerIntent`) con lo stesso matching dei task.
- **AppFunctions**: esporre `logMeal(name)` a Gemini quando Google aprirà l'accesso.
- Stima facoltativa dei valori nutrizionali tramite LLM (una tantum, alla creazione del pasto).
- Export CSV dello storico.
- Health Connect: **solo eventualmente**, opzionale.
- Barcode / database alimenti (ML Kit + Open Food Facts): **probabilmente mai**, solo se ne sentirò la mancanza.

---

## 5. Modello dati (proposta, puoi migliorarlo motivando)

```
Meal
  id                Long (PK)
  name              String          // "Riso cantonese"
  ingredients       String?         // testo libero
  approxGrams       Int?            // indicativo
  notes             String?
  isFavorite        Boolean
  sortOrder         Int
  aliases           List<String>    // per il matching vocale (tabella separata o JSON)
  createdAt / updatedAt

MealEntry
  id                Long (PK)
  mealId            Long?           // FK nullable: il pasto può essere eliminato in seguito
  mealNameSnapshot  String          // nome al momento della registrazione
  loggedAt          Instant         // quando l'ho mangiato
  source            enum PHONE | WATCH | VOICE_TASKS | VOICE_APP
  grams             Int?            // override facoltativo
  note              String?

PendingImport                       // task non riconosciuti
  id                Long (PK)
  rawTitle          String
  loggedAt          Instant
  googleTaskId      String

ImportedTask                        // idempotenza: non importare due volte lo stesso task
  googleTaskId      String (PK)
  importedAt        Instant
```

---

## 6. Import da Google Tasks — dettagli

- **Autenticazione**: Credential Manager / Google Identity (Authorization API) con scope `https://www.googleapis.com/auth/tasks`.
  Uso strettamente personale: va bene un progetto Google Cloud in modalità test con il mio account come test user.
  Spiegami passo passo cosa configurare nella Google Cloud Console.
- **Quando sincronizzare**: all'apertura dell'app, con un bottone "Sincronizza", e periodicamente con **WorkManager** (minimo consentito: 15 minuti).
- **Algoritmo**:
  1. leggi tutti i task di `@default` (inclusi completati e nascosti, gestisci la paginazione);
  2. filtra quelli con prefisso `pasto`;
  3. salta quelli già presenti in `ImportedTask`;
  4. estrai il testo dopo il prefisso e normalizzalo (minuscole, senza accenti, spazi compressi);
  5. confronta con nomi e alias dei pasti: prima match esatto, poi "contiene", poi fuzzy (es. distanza di Levenshtein con soglia);
  6. se c'è match → crea `MealEntry` (source = VOICE_TASKS, `loggedAt` = campo `updated` del task); altrimenti → `PendingImport`;
  7. registra il task in `ImportedTask` e **poi** **eliminalo** da Google Tasks.
- La **logica di matching** deve stare nel modulo condiviso e avere **unit test** (servirà anche al microfono dell'orologio).
- Gestisci gli errori di rete senza perdere dati: meglio un task importato due volte che uno perso (l'idempotenza copre il resto).

---

## 7. Architettura e stack

**Progetto Gradle multi-modulo:**
```
:shared   modelli comuni, logica di matching, costanti dei path del Data Layer (Kotlin puro dove possibile)
:app      app telefono
:wear     app + tile Pixel Watch
```

**Stack indicativo** (verifica le versioni attuali):
- Kotlin, coroutine, `Flow`
- Jetpack Compose + Material 3 (telefono), Compose for Wear OS (orologio)
- Room (database locale, **sul telefono è la fonte di verità**)
- WorkManager (sync periodica)
- Wearable Data Layer API (`MessageClient` e/o `DataClient`) per orologio → telefono
- Wear Tiles + ProtoLayout per la tile
- Client HTTP per la Google Tasks REST API (Retrofit o Ktor, o la libreria Google: scegli e motiva)
- Dependency injection: Hilt **oppure** DI manuale se più semplice da capire per un principiante — proponi tu
- Pattern UI: MVVM (ViewModel + StateFlow)

**Flusso orologio → telefono**
- L'orologio non ha il database principale: tiene solo una **copia dei preferiti** (sincronizzata dal telefono via `DataClient`) e una **coda** delle registrazioni non ancora confermate.
- Tocco sulla tile → messaggio al telefono con `mealId` + timestamp → il telefono salva e risponde con un ack → l'orologio rimuove dalla coda.

**Dispositivi target**
- Orologio: Pixel Watch 4, Wear OS aggiornato (build CP3A.260905.002, settembre 2026).
- Telefono: Android recente. Proponi tu il `minSdk` motivandolo.

---

## 8. Piano di lavoro (fasi con criteri di accettazione)

**Fase 0 — Setup**
- Spiegami cosa installare (Android Studio, SDK, emulatori) e come attivare il debug sul telefono e sull'orologio (ADB via Wi-Fi).
- Crea il progetto multi-modulo vuoto, che compila.
- ✅ L'app vuota gira sul telefono e sull'orologio.

**Fase 1 — Telefono: pasti e storico**
- Room + CRUD pasti + registrazione con un tocco + storico.
- ✅ Creo 3 pasti, li registro, li vedo nello storico, sopravvivono al riavvio.

**Fase 2 — Orologio: tile e app**
- Sincronizzazione preferiti telefono → orologio, tile con bottoni, invio registrazione, coda offline, vibrazione.
- ✅ Tocco "Riso cantonese" sulla tile e compare nello storico del telefono. Col Bluetooth spento la registrazione resta in coda e arriva dopo con l'orario giusto.

**Fase 3 — Import Google Tasks**
- OAuth, lettura `@default`, matching, `PendingImport`, eliminazione task, WorkManager.
- ✅ Dico a Gemini "aggiungi un task pasto riso cantonese" e dopo la sync il pasto è nello storico e il task è sparito da Google Tasks. Un task non riconosciuto finisce in "da assegnare". I task senza prefisso restano intatti.

**Fase 4 — Rifiniture**
- Microfono sull'orologio, export CSV, icona.

---

## 9. Cosa NON fare
- Non chiedere né calcolare calorie, macronutrienti o valori nutrizionali obbligatori.
- Non integrare Google Health né Health Connect nell'MVP.
- Non toccare task di Google Tasks che non iniziano con il prefisso `pasto`.
- Non aggiungere backend né server propri per ora: tutto locale, tranne la Google Tasks API e Supabase, se si farà il database remoto.
- Gli account serviranno: accesso con Google, con Apple o con un account proprio nel database remoto.
- Non sovra-ingegnerizzare. L'app ha più utenti, ciascuno con i suoi dati.

---

## 10. Primo passo

1. Leggi tutto questo documento e fammi le domande che ti servono (per esempio il nome del package e l'elenco dei miei pasti abituali).
2. Proponi la struttura del progetto e le dipendenze, con una riga di motivazione per ciascuna.
3. Dopo il mio ok, parti con la **Fase 0**.