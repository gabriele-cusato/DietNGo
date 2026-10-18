# Handoff 2026-10-12: inizio del progetto dell'app

Sostituisce l'handoff `2026-10-11-avvio.md`. Di quello restano valide, e non sono ripetute qui, le sezioni «Fin dove sono arrivate le spiegazioni» e «Verifiche online fatte il 2026-10-11».

## Dove siamo

Cominciato il progetto dell'app, cioè la descrizione di cosa fa e di come la si usa, prima di scrivere il codice. Claude ha proposto un flusso d'uso e le macro sezioni; l'utente non ha ancora risposto nel merito, perché ha chiuso la sessione per stanchezza. Nessun file del progetto dell'app è stato creato. Nessun piano creato: la cartella `Docs/Ai/Plans` non esiste ancora.

## Come l'utente vuole lavorare al progetto dell'app

- Non basta l'elenco delle funzioni: va descritta l'esperienza d'uso. Cosa fa una persona dopo aver installato l'app, cosa succede se la installa prima sull'orologio e non sul telefono, cosa succede al contrario, e così via per ogni cosa che l'utente può fare.
- Il metodo: Claude tiene conto di ciò che ha già proposto, prende ciò che l'utente dice e lo usa per riempire i buchi. Il lavoro non è finito finché tutti i buchi non sono riempiti. Durerà più sessioni: l'utente dirà lui quando scrivere l'handoff.
- Il progetto dell'app si scrive in un file nuovo, non nel file `IdeaIniziale.md`. Nome e cartella del file non sono ancora scelti: proporli all'utente prima di crearlo.
- Risposte sempre molto brevi.

## La proposta di Claude, non ancora confermata

Flusso d'uso:

1. L'utente installa l'app sul telefono, sull'orologio o su tutti e due, nell'ordine che vuole.
2. Al primo avvio l'app chiede l'accesso all'account. Sul telefono si entra con Google, con Apple o con un account proprio. Se il telefono ha già l'app con l'accesso fatto, l'orologio lo prende da lì senza chiedere niente.
3. Se l'orologio è il primo o l'unico ad avere l'app, mostra «Completa l'accesso sul telefono» e resta fermo lì.
4. L'utente crea sul telefono i pasti abituali e segna i preferiti. Sull'orologio non si creano.
5. L'orologio riceve l'elenco dei pasti e lo mostra all'apertura dell'app.
6. L'utente tocca un pasto sull'orologio. L'orologio lo registra con data e ora, anche senza connessione, e lo manda appena può.
7. In alternativa l'utente detta il pasto all'assistente vocale dell'orologio. Il pasto dettato finisce in Google Tasks e il telefono lo importa da lì quando l'utente lo chiede.
8. L'utente vede sul telefono lo storico dei pasti registrati, da correggere o cancellare.

Macro sezioni:

- Telefono: Accesso, Pasti salvati, Storico, Import dei pasti dettati, Impostazioni.
- Orologio: Elenco dei pasti, Conferma della registrazione, Avviso di accesso mancante.

## I buchi da riempire con l'utente

1. L'accesso sull'orologio: preso dal telefono, come ai passi 2 e 3 della proposta, oppure fatto anche direttamente sull'orologio. La seconda strada rende l'orologio usabile senza telefono e costa una schermata di accesso in più. È legato al punto aperto sull'orologio che parla da solo con Supabase.
2. L'orologio mostra tutti i pasti o solo i preferiti.
3. Cosa vede l'utente all'apertura dell'app sull'orologio e quanti tocchi servono per registrare.
4. Cosa contiene un pasto salvato, oltre al nome.
5. Cosa succede dopo il tocco: conferma, annullamento, correzione dell'ora.
6. Il pasto dettato: cosa si dice, e se prima di entrare nello storico va confermato o abbinato a un pasto salvato.
7. Lo storico: cosa si rivede, per quale periodo, cosa si può correggere o cancellare, e se si vede anche sull'orologio.
8. Cosa deve funzionare senza connessione, e su quale dei due apparecchi.
9. Promemoria, notifiche, obiettivi e statistiche: Claude non li ha messi, l'utente deve dire se servono.
10. Cosa resta fuori dall'app per ora, oltre ai valori nutrizionali.
11. Le schermate di orologio e telefono, e poi il database: vengono dopo che il flusso d'uso è chiuso.

## Fatto in questa sessione sui file

- Nome del pacchetto cambiato da `com.example.dietngo` a `com.gabrielecusato.dietngo`, senza piano su richiesta dell'utente: i file `app/build.gradle.kts` e `mobile/build.gradle.kts`, i sette file Kotlin delle due app, i due file di test del modulo `mobile`, e le quattro cartelle `com/example` rinominate in `com/gabrielecusato`.
- Verifica: la compilazione di debug dei due moduli e dei test del modulo `mobile` è riuscita.
- `Docs/Info/Spiegazioni/ParallelismiCSharp.md`: aggiornati il percorso e la riga `package` citati.
- `Docs/Ai/DECISIONS.md`: aggiunte le righe sui warning rinviati e sul file nuovo per il progetto dell'app.
- Letti l'indice delle linee guida e i punti generali P1-P5.

Le modifiche non sono ancora state committate: i commit li fa l'utente.

## Da confermare con l'utente

- Se ha premuto «Sync Now» in Android Studio dopo il cambio del pacchetto. Gli è stato detto dove si trova.
- Se ha disinstallato dal telefono e dall'orologio emulato le due app con il vecchio nome di pacchetto, che altrimenti restano installate accanto alle nuove.

## Warning

Rinviati su richiesta dell'utente: si risolvono tutti insieme più avanti. Manca ancora l'elenco. L'unico già noto è il messaggio di Android Studio sul garbage collector di Gradle con JDK 25.

## Punti aperti che restano dall'handoff precedente

1. L'orologio parla da solo con Supabase: parere dato, sì, ma la decisione si prende quando si pianifica la sincronizzazione. Prima vanno fatte le verifiche online elencate nell'handoff precedente, alla sezione «Ancora da verificare online».
2. Il valore `com.google.android.wearable.standalone` nel file `app/src/main/AndroidManifest.xml` è `true`: va rivisto quando si chiude il buco 1.
3. Le funzioni e il modello dati del file `IdeaIniziale.md` sono proposte di Claude, non decisioni: prima di appoggiarsi a un punto del file, chiederne conferma.

## Prossimo passo

Riprendere dai buchi, cominciando dal numero 1, con domande brevi e poche per volta. Quando l'utente comincia a rispondere, proporre nome e cartella del file nuovo e scriverci ciò che è confermato.
