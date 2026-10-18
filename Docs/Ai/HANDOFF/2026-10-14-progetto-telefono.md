# Handoff 2026-10-14: progetto dell'app, flusso del telefono

Sostituisce l'handoff `2026-10-12-progetto-app.md`. Di quello restano valide, e non sono ripetute qui, le sezioni «Da confermare con l'utente», «Warning» e «Punti aperti che restano dall'handoff precedente». Dell'handoff `2026-10-11-avvio.md` restano valide le sezioni «Fin dove sono arrivate le spiegazioni», «Verifiche online fatte il 2026-10-11» e «Ancora da verificare online».

## Prima cosa da fare alla ripresa

Leggere per intero, parola per parola, il file `Docs/Ai/HANDOFF/2026-10-14-risposta-progetto.md`. È la copia esatta dell'ultima risposta di Claude: la descrizione di tutte le pagine del telefono. L'utente non l'ha ancora letta, perché è uscito subito dopo. Riprendere da lì, con i suoi commenti.

## Dove siamo

Progetto dell'app, cioè la descrizione dell'esperienza d'uso prima del codice. Si sta definendo il flusso del telefono. Quello dell'orologio viene dopo, ricavato dal telefono: il più semplice possibile, separando ciò che va fatto per forza sul telefono da ciò che l'orologio fa da solo. I buchi 1-11 dell'handoff del 2026-10-12 sono in parte superati da quanto detto qui. Il buco 1, cioè l'accesso sull'orologio, resta aperto e torna con il flusso dell'orologio.

Il file del progetto dell'app non è ancora stato creato. L'utente ha scartato il nome `Docs/Progetto/EsperienzaUso.md` perché troppo specifico: vuole un nome più generale. Proporne uno alla ripresa, per esempio `Docs/Progetto/ProgettoApp.md` o `Docs/Progetto/DietNGo.md`, e chiedere.

## Come l'utente vuole lavorare

- Prima liste con tante voci ma brevi, da leggere in fretta. Poi si approfondisce un pezzo alla volta.
- Claude deve essere creativo: proporre anche disposizioni e modi di mostrare le cose non standard, non solo quelli rodati, purché non peggiorino l'uso.
- Per ogni pagina vuole una descrizione di come appare e di cosa si può fare, per riuscire a immaginarla.
- Tutto ciò che dice va annotato: non vuole doverlo ripetere e vuole poter rileggere cosa aveva detto.
- Il metodo dei buchi resta: Claude parte dalle sue proposte, usa le risposte dell'utente per riempire i buchi, e il lavoro finisce quando non ne restano.

## I principi dell'utente

I principi che valgono oltre questa tappa sono anche righe di `Docs/Ai/DECISIONS.md` con data 2026-10-14. Qui stanno con le sue parole e le sue ragioni.

- **Un'immagine vale più di mille parole.** Un'immagine, un'icona, un'illustrazione o un'animazione messa nel posto e nel momento giusto vale più di mille parole, e questo rende anche l'app essenziale.
- **Rapidità.** Lo scopo è tracciare in modo semplice e rapido, così che il tracciamento entri nella routine senza far perdere tempo. Si usa dal telefono o dall'orologio, come si preferisce.
- **Regole di UX design.** Curve sinuose, pulsanti nel posto giusto, gesture e comandi vocali nei punti giusti, meno elementi possibili che causino confusione o ridondanza.
- **Stile di Google.** Lo stile è quello di Google del sistema operativo, perché l'utente non abbia l'impressione che l'app sia una cosa esterna e non integrata.
- **Un'anima per pagina.** Ogni schermata ha «un'anima», non solo utilità: minimale nelle funzioni, ricca in animazioni, illustrazioni e colori. Ogni pagina ha un suo stile e un suo modo di rappresentare le cose. Due pagine con contenuti simili possono somigliarsi, ma non essere identiche.
- **Il principio fondamentale.** Riguarda il pensiero indiretto dell'utente. L'app non è essenziale, quindi la usa solo se ci vuole pochissimo e se è carina da vedere: «ci vuole talmente poco ed è carina, allora la uso, perché non mi ruba tempo».
- **Una sola azione principale**, la più frequente: registrare un pasto salvato. Il resto è secondario e va trattato, mostrato e posizionato di conseguenza.
- **Home essenziale e diretta.** Mostra ciò che serve più spesso, e il resto si raggiunge con qualche tocco o navigazione. Troppi elementi insieme rompono l'essenzialità.
- **Informazioni effimere.** Le informazioni che all'utente non danno niente, come la serie di giorni, sono effimere. Esempio dell'utente: una fiammella, un pezzetto di carta che brucia in pochi secondi, mostra i giorni di fila e sparisce da solo. È una bella animazione che fa vedere che l'app tiene conto di ciò che fa, senza fargli perdere tempo.
- **Il pasto.** È un insieme di più cose, alimenti e bevande, per esempio un pranzo completo. Si compone una volta e poi si registra al volo: per esempio l'utente ha tre colazioni diverse e registra quella che vuole. Si possono salvare anche pasti di una cosa sola. È la cosa principale dell'app.
- **Informazioni facoltative.** Un pasto si registra con poche informazioni o con tutte: valori nutrizionali, codice a barre, ricerca di un prodotto già noto come fa Google Health.
- **Registrazione rapida.** Con un tocco, oppure a voce con Gemini senza aprire l'app, anche a schermo spento, sia sull'orologio sia sul telefono.
- **Gemini.** L'Assistente Google è deprecato e c'è solo Gemini. È una regola scritta nel file `CLAUDE.md`.
- **Varietà.** L'app spinge a variare e a non mangiare ogni giorno la stessa cosa. La ripetitività è negativa in una dieta.
- **Niente rigidità.** Gli orari sono a spanne: l'ora in cui più o meno fai quel pasto, con una finestra intorno di un'ora o mezz'ora prima e dopo, ancora da scegliere.

## Cosa ha detto su ogni punto

### Accesso

- Gli piacciono gli ingredienti che fluttuano.
- Il piatto che si riempie gli piacerebbe, ma la lunghezza di nome utente e password varia molto e non vede come farlo in modo stabile.
- Ha chiesto se la forchetta che sbuca va scartata. Claude ha risposto di sì come idea principale, tenendone un gesto: gli ingredienti si girano mentre si scrive la password. L'utente non ha ancora risposto.
- L'idea iniziale dell'uomo che saluta stona con lo scopo dell'app.
- Il riquadro contiene i campi per nome utente e password e i due pulsanti rettangolari Google e Apple.

### Home

1. **Bollino utente.** Ci vuole, ma non per forza in alto a destra: lì è il punto standard, e per questa app forse va altrove. Chiede creatività. Claude ha proposto il «segnaposto» sulla tavola.
2. **Saluto illustrato che cambia con il momento della giornata.** Può starci.
3. **Pasti rapidi.** Possono starci, ma non sa con che criterio scegliere quali mostrare né come mostrarli: una lista verticale è troppo standard. Claude ha proposto il criterio del punteggio e il piatto da scorrere.
4. **Suggerimento del momento.** È la cosa più intelligente. Non dipende solo dall'ora ma anche dal giorno, perché deve spingere a variare.
5. **Diario di oggi.** Non riesce a immaginarlo: ha chiesto la descrizione.
6. **Pulsante «+».** L'azione principale dev'essere una sola e il resto secondario.
7. **Pasti dettati.** Si importano da soli da Google Tasks. In più l'app controlla se ci sono pasti in Google Tasks non registrati per qualche motivo, lo segnala, e l'utente tocca «Registra» per allineare.
8. **Riepilogo del giorno.** L'idea ci sta, ma non vede dove metterlo con tutto il resto senza rompere l'essenzialità.
9. **Acqua.** Approvata.
10. **Serie di giorni.** Solo come fiammella effimera, come descritto fra i principi.

### Altre pagine

1. **Benvenuto.**
   - Compare al primo avvio, prima dell'accesso, con «Salta» sempre evidente: salta tutto ed entra subito nell'app, e permette di fare quello che si vuole anche dopo l'accesso.
   - Secondo l'utente serve un utente ospite, ma non ne è certo.
   - Pochissime parole, pulsanti grandi, belle illustrazioni, zero tempo perso.
   - Contenuto: cosa fa l'app in pochissime parole, i permessi, il collegamento dell'orologio.
   - Ha chiesto se Gemini funziona su orologi più vecchi e di altre marche: se sì, va detto nel benvenuto per incoraggiare l'uso. Verificato: sì, su Wear OS 4 e successivi, come scritto nel file `Docs/Info/Gemini/GeminiSuOrologi.md`.
2. **Registra pasto.** Niente roba rigida: l'orario è quello in cui più o meno si fa il pasto, e l'app lo prende a spanne con una finestra. Per il resto va bene.
3. **Pasti salvati.** Va bene, ma non riesce a immaginarlo: ha chiesto la descrizione.
4. **Dettaglio pasto.** Non sa come strutturarlo né come farlo aprire: ha chiesto una proposta.
5. **Storico.** Va bene.
6. **Statistiche.** Non servono davvero, quindi vanno trattate come la fiammella. Deve essere semplicissimo leggere i giorni in cui l'utente si è comportato bene, quelli in cui ha trasgredito, quelli in cui ha mangiato male e quelli senza registrazioni. Toccando un giorno si vedono i dettagli. Contano l'esperienza d'uso e la bellezza.
7. **Import.** Si fa da solo, come detto per la home.
8. **Impostazioni.** Vanno bene.
9. **Account.** La cancellazione dell'account sta proprio in fondo a tutto.

### Funzioni in più

La numerazione è quella della risposta di Claude del 2026-10-14 precedente a quella salvata.

1. **Codice a barre con Open Food Facts.** Va testato. Non si fida ciecamente: prima vanno cercate e valutate le alternative.
2. **Ricerca per nome.** Approvata.
3. **Foto del piatto riconosciuta da Gemini.** Sarebbe carina, ma chiede se funziona davvero.
4. **«Come ieri».** No: incentiva la ripetitività. Si fa il contrario.
5. **Pasti composti.** Sono il cuore dell'app, come spiegato fra i principi.
6. **Promemoria intelligente con registrazione dalla notifica.** L'interazione con la notifica può starci, ma non sa quale piatto proporre in modo solido: va chiarito.
7. **Riquadro sull'orologio.** Sì. Soprattutto il pasto consigliato deve essere sempre quello giusto: l'utente lo registra al volo toccando l'elemento più evidente, altrimenti scorre fra i preferiti della fascia oraria e del giorno.
8. **Complicazione sul quadrante.** No, per ora: darebbe al massimo un'informazione o una scorciatoia, che non serve.
9. **Widget sul telefono.** No.
10. **Pulsante nelle Impostazioni rapide del telefono.** No: solo la notifica, niente pannelli sempre visibili.
11. **Peso corporeo.** Può starci.
12. **Digiuno intermittente.** Potrebbe starci, ma non sa come inserirlo in modo furbo.
13. **Sensazioni dopo il pasto.** Molto carino, da mettere. Vanno pensate le dinamiche e la logica.
14. **Piano del nutrizionista.** Ci sta, è una bella idea. Vanno pensate le dinamiche e studiata la fattibilità.
15. **Esportazione per il nutrizionista.** Molto interessante, da fare, ma da studiare.
16. **Lista della spesa.** No, perché la spesa può essere varia. Al suo posto c'è un promemoria per ricomprare un prodotto specifico.
    - Esempio dell'utente: i barattoli di yogurt.
    - L'app chiede quanti ne mancano. L'utente risponde solo se lo sa, senza aprire il frigo a contare, oppure con poche, medie o tante.
    - Il promemoria dice «devi prendere gli yogurt».
    - Ci può stare, ma non è essenziale e va studiato.
17. **Traguardi animati.** Sì, ma vanno studiati.

### Risposte sugli NB di Claude

1. Il nome `Docs/Progetto/EsperienzaUso.md` non va bene: ne vuole uno più generale.
2. La sezione «Scopo» del file `CLAUDE.md` va aggiornata: fatto.
3. Confermato: l'accesso con Apple funziona su Android, ma serve solo a chi ha già un account Apple.

## Le proposte di Claude in attesa di risposta

Stanno tutte nel file `2026-10-14-risposta-progetto.md`.
- La home come «tavola» vista dall'alto. Il piatto al centro mostra il pasto consigliato: un tocco lo registra, scorrendo si cambia pasto. Sul bordo del piatto c'è il riepilogo del giorno a puntini. Ci sono anche il bicchiere d'acqua, il segnaposto come bollino utente, la forchetta per il diario e il coltello per «I miei pasti». Ci sono infine tre elementi effimeri: la fiammella, il bigliettino per i pasti dettati e le faccine delle sensazioni.
- Il punteggio del pasto consigliato: vicinanza all'orario, giorno della settimana, penalità per i pasti mangiati di recente, piccolo bonus ai preferiti, e l'app impara da ciò che l'utente sceglie scorrendo.
- Le pagine: Benvenuto in tre schermate con «Salta», Accesso con gli ingredienti che fluttuano, I miei pasti come un menù sfogliabile, il Pasto da comporre con gli alimenti che cadono nel piatto e l'orario scelto trascinando il sole su un arco, il Diario come mosaico di piatti colorati, le Impostazioni e l'Account.
- Le risposte su foto del piatto, promemoria, digiuno sul bordo del piatto, ricomprare un prodotto e peso nel segnaposto.

## Scelte che aspettano l'utente

- La tavola: va bene come concetto? Claude consiglia di provarla prima con un disegno o un prototipo.
- Utente ospite: sì o no. Ha tre limiti: niente copia su Supabase, niente orologio da solo e niente uso su più telefoni.
- La finestra intorno all'orario del pasto: un'ora o mezz'ora.
- Chi decide se un giorno è andato bene: l'utente con un tocco, l'app con il piano del nutrizionista, o tutte e due.
- La forchetta dell'accesso: scartata o no.
- Il nome e la cartella del file del progetto dell'app.

## Ancora da verificare online

- Come chiamare Gemini dall'app senza un server nostro, con Firebase AI Logic o con altro, e quanto costa ogni foto analizzata.
- I database dei prodotti per codice a barre: Open Food Facts e le alternative, da confrontare e provare.
- La fattibilità dell'esportazione e del piano del nutrizionista.
- La pagina di aiuto attuale di Google sugli orologi con Gemini, prima di citarli nel benvenuto.

## Fatto in questa sessione sui file

- `Docs/Ai/DECISIONS.md`: aggiunte le righe del 2026-10-14 con i principi e le scelte dell'utente.
- `CLAUDE.md`: aggiunta la regola sull'Assistente Google deprecato; riscritta la sezione «Scopo». Il telefono ora registra anche da solo, e il pasto è un insieme di alimenti e bevande.
- `Docs/Info/Gemini/GeminiSuOrologi.md`: creato, con la verifica sugli orologi che hanno Gemini.
- `Docs/Ai/HANDOFF/2026-10-14-risposta-progetto.md`: la copia esatta della risposta.
- Nessun codice toccato. Le modifiche delle sessioni precedenti e di questa non sono ancora state committate: i commit li fa l'utente.

## Da proporre all'utente

Due principi possono diventare regole generali delle linee guida, valide anche per altri progetti. Vanno proposti all'utente, e se li approva si scrivono in `Docs/Guidelines` con la forma Perché, Quando, Come, Non così.
- Le informazioni che non servono all'utente si mostrano in modo effimero.
- Un'app ha una sola azione principale, e tutto il resto si posiziona di conseguenza.

## Prossimo passo

1. Leggere il file della risposta.
2. Raccogliere i commenti dell'utente sulle pagine e sulle scelte in attesa.
3. Proporre il nome del file del progetto dell'app e, con il suo ok, scriverci ciò che è confermato.
4. Chiuso il telefono, passare al flusso dell'orologio.
