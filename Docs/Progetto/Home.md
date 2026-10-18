# Home del telefono

Descrizione della home al 2026-10-18, da usare come riferimento nel piano. Le scelte, con la data, stanno anche in `Docs/Ai/DECISIONS.md`.

Il design su cui si è lavorato è sul canvas https://claude.ai/artifact/3x4yjV4ViJt5dKqkX5CD6V, privato, e la sua copia sta nella cartella `Docs/Progetto/Design/Home`. Ogni file `.dc.html` è una tavola: `Main.dc.html` contiene tutta la home e le altre tavole la richiamano in uno stato diverso. Misure e colori sono pensati per uno schermo di 390 × 844 punti. Le illustrazioni dei pasti sono provvisorie: indicano lo stile, non i disegni finali.

## Cosa fa la home

La home contiene solo l'azione principale, cioè registrare un pasto salvato, e i collegamenti alle altre pagine. Non mostra il punteggio del consiglio, l'orario del prossimo pasto, né i pasti già registrati oggi.

## Disposizione, dall'alto in basso

1. **Zona alta.** In piccolo, il momento del pasto ricavato dall'ora: Colazione, Pranzo, Merenda o Cena. Sotto, una frase breve con il motivo del consiglio, che cambia quando si gira il piatto: «Niente pasta da cinque giorni». Se c'è un errore dei pasti dettati, al loro posto c'è solo il riquadro dell'errore (vedi sotto), finché l'errore non è risolto.
2. **Ora e quantità.** Due rettangoli sopra il pasto di fronte: l'ora attuale e la quantità salvata del pasto.
   - L'ora si cambia con il selettore nativo di Google. Il formato 12 o 24 ore sta nelle impostazioni.
   - La quantità si cambia con un valore e una combo dell'unità di misura, più una spunta «usa come predefinita». Nelle impostazioni si scelgono la famiglia di unità, come grammi o libbre, e l'unità predefinita della famiglia, come g o kg.
   - Per un pasto composto l'utente dà il totale, e tutti gli ingredienti si moltiplicano dello stesso fattore. Un ingrediente a pezzi ha un peso dato dall'app, così ogni pasto ha un peso totale.
3. **Piatto girevole.** Un piano 3D visto di fronte, molto più largo dello schermo, che esce dai bordi laterali e verso i lati sale e si allontana. È un po' sotto il centro dello schermo, dove arriva il pollice.
   - Il pasto di fronte è il consigliato. Nella direzione scelta nelle impostazioni seguono le alternative, al massimo N (3, 5 o 7, predefinito 3), ordinate per punteggio nascosto. Nella direzione opposta c'è il «+», che apre la pagina per salvare un pasto nuovo, composto o di una cosa sola.
   - I pasti di lato sono più piccoli, più alti e sbiaditi, e si ravvivano arrivando davanti.
   - Ogni pasto ha la sua illustrazione appoggiata sul piano, come un oggetto unico con la sua ombra, e il nome sotto il piano. Le illustrazioni sono lucide, con luci, ombre e rilievo.
   - Il «+» è un piatto tratteggiato con un cerchio e il simbolo più. La sua ombra sta dentro il piatto tratteggiato.
4. **Titolo.** Il nome del pasto di fronte, sotto il piano.
5. **Pillola di navigazione.** Fluttuante in basso, arrotondata: «Pasti», «Diario», «Scansiona» con l'icona della fotocamera, e più a destra il bollino utente. Le etichette stanno sotto le icone.
   - «Pasti» apre i pasti salvati: ricerca per nome, preferiti, registrazione con la stessa animazione della home, forse la modifica.
   - «Diario» apre le registrazioni: oggi come predefinito, poi settimana e mese, e l'annullamento.
   - «Scansiona» apre la fotocamera per la foto del piatto o il codice a barre. Se il cibo somiglia a un pasto salvato il piatto girevole gira su di lui; altrimenti si propone di salvarlo. Non si registra mai un pasto non salvato.
   - Il bollino utente apre profilo, impostazioni, account e peso.

## Gesti sul piatto

La direzione si decide all'inizio del trascinamento e non cambia a metà.
- In orizzontale si gira il piatto.
- Verso l'alto si solleva il pasto di fronte e lo si registra, con l'animazione guidata dal dito. Va fatto solo se si riesce in modo affidabile; altrimenti restano tocco, scorrimento orizzontale e al massimo pressione lunga.
- Un tocco sul pasto di fronte lo registra, e l'animazione parte da sola.
- Un tocco su un pasto di lato gira il piatto su di lui.
- Registrando si usano l'ora e la quantità dei due rettangoli.

## Sequenza della registrazione

1. L'utente tocca il pasto di fronte, o lo trascina verso l'alto.
2. Il pasto vola al centro dello schermo e tutto il resto sparisce, con vibrazione.
3. Solo al primo pasto del giorno: il pasto sparisce in dissolvenza e al suo posto compare la fiammella, grande, con il numero dei giorni di fila e sotto una frase motivazionale breve: «12 giorni di fila: continua così!».
4. Dopo qualche secondo la fiammella sfuma. Compare la spunta verde nel cerchio verde, con sotto il nome del pasto e «Registrato alle 12:40». Se non è il primo pasto del giorno si passa qui subito dal punto 2. Fiammella e spunta non si vedono mai insieme.
5. Sotto la spunta compaiono «Come ti senti dopo il pasto?» e le tre faccine: rossa (male), gialla con occhi normali e bocca dritta (normale), verde che sorride (bene). Quella toccata si ingrandisce con delle stelline. Sono facoltative.
6. L'overlay si chiude da solo dopo pochi secondi o con un tocco, e torna la home.

Le sensazioni vanno chieste dopo il pasto, non al momento della registrazione, perché si registra anche prima di mangiare. Come chiederle è descritto in «Sensazioni» qui sotto: il passo 5 va rivisto di conseguenza.

## Pasti dettati a voce

- All'apertura dell'app si controlla Google Tasks: i pasti nuovi si registrano da soli e si tolgono da Google Tasks, per non registrarli due volte. Niente controlli in sottofondo ad app chiusa.
- Se tutto va bene compare una Snackbar sopra la pillola: «3 pasti registrati a voce» con «Revisiona», che apre il riepilogo da cui si può annullare. Nelle impostazioni si può scegliere di vedere direttamente il riepilogo. Sparisce dopo circa 5 secondi o trascinandola via.
- Le Snackbar hanno una coda: si mostrano una dopo l'altra, e la coda si svuota al logout e in altri casi da decidere.
- Se la registrazione o la cancellazione da Google Tasks falliscono, nella zona alta compare solo il riquadro rosso «1 errore in un pasto dettato», con sotto «Gli altri rimarranno in attesa» e il tasto «Controlla». Le registrazioni dettate successive aspettano in coda finché l'errore non è risolto. La gestione dell'errore è da decidere.
- Quando AppFunctions sarà aperta a tutti, la voce passerà direttamente all'app; Google Tasks resta come ripiego.

## Sensazioni

- Tre stati: male, normale, bene.
- Si chiedono dopo il pasto, con una notifica a tre pulsanti a cui si risponde senza aprire l'app. Android ammette fino a tre pulsanti per notifica. Se l'utente non risponde, non si salva niente.
- Il ritardo della notifica, se chiedere anche alla prima apertura successiva e l'interruttore nelle impostazioni sono da decidere.

## Dati raccolti senza chiedere nulla

- Quale pasto l'utente sceglie rispetto al consiglio: serve a migliorare il consiglio.
- Le correzioni alla quantità: se sono sempre uguali, l'app aggiorna la quantità predefinita.
- L'ora vera dei pasti: l'app impara le finestre dei pasti.
- Le correzioni alla scansione: il riconoscimento migliora per i piatti dell'utente.

## Sfondo

- Nella home, dietro il piatto girevole, c'è la finestra sul luogo: una grande apertura ad arco, senza traverse, da 18 punti dai bordi e dall'alto fino a dietro il piano girevole, che ne nasconde il fondo. Intorno resta il colore fisso del tema, con un alone di luce calda sulla parete.
- Dentro la finestra c'è la foto di un luogo accogliente dove si mangia guardando qualcosa, come un campeggio sul mare, un hotel su un promontorio, un appartamento in un grattacielo, un café a bordo strada o un ristorante con poche persone. Tre foto per ogni momento (colazione, pranzo, cena), a rotazione.
- La foto è sfocata, così diventa un'atmosfera e convive con i piatti disegnati. Si muove piano con uno zoom lento che va e torna fra due inquadrature in 16 secondi, fatto con Compose senza librerie. L'animazione gira solo con la home sullo schermo e si ferma se nel telefono è attivo «riduci animazioni».
- Il bordo interno della finestra ha un'ombra che dà lo spessore del muro. In alto una velatura scura rende leggibili il momento del pasto e il motivo del consiglio, scritti in bianco.
- Le foto vengono da Pexels, gratuite anche nelle app; la licenza è in `Docs/Info/Design/GenerazioneSfondi.md`. Nel canvas la scena è un disegno provvisorio sfocato, non una foto.
- Durante la registrazione la finestra sparisce insieme al resto della home.
- Con un errore dei pasti dettati la finestra resta vuota, tinta di rosso tenue, per dare evidenza che qualcosa non va.
- Nel tema chiaro il piano girevole è grigio morbido (da #E9E9E7 al centro a #D2D2CF ai bordi), non bianco, per non stancare gli occhi e non stonare con la parete.
- Le altre pagine hanno gli sfondi fissi: #151515 nel tema scuro e #FCFCFB nel tema chiaro, con il tema scelto dal sistema.

## Suggerimenti guidati

- L'app incrocia i dati (sensazioni, quantità corrette, scelte, ingredienti). Dove serve propone una modifica, oppure fa una domanda quando le manca un elemento per proporla. Così l'utente aggiusta le cose piano piano.
- Esempi: se la quantità si corregge sempre, propone una quantità predefinita diversa; se dopo un pasto arriva spesso «male», controlla prima se la quantità era più alta del solito, poi se c'è un ingrediente in comune con altri pasti da «male», e propone di sostituirlo con qualcosa che ci sta bene.
- Un suggerimento per apertura, mai insieme all'errore dei pasti dettati, sul pasto a cui si riferisce quando è davanti nel piatto girevole, con una Snackbar o un box sopra la pillola. Ogni suggerimento ha «Sì» e «No».
- I suggerimenti si spengono dalle impostazioni.
- Niente diagnosi e niente consigli di andare dal medico: non sono obiettivi dell'app.

## Colori e stile

- Tema chiaro o scuro dal sistema, colori morbidi. Lo stile di Google vale per gli elementi riconoscibili, come il selettore dell'ora e la Snackbar. Gli accenti presi dal sistema si provano.
- Cambio pagina: un liquido che scende dall'alto con forme ondulate, non a gocce, toglie la pagina vecchia; poi la nuova compare in dissolvenza.

## Da decidere

- La gestione degli errori dei pasti dettati.
- Il ritardo e le regole della notifica delle sensazioni, e cosa farne del dato.
- Le foto da mettere nella finestra.
- Lo stile finale delle illustrazioni dei pasti.
