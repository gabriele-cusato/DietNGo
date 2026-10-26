# Handoff 2026-10-26: design delle pagine principali chiuso

Sostituisce `2026-10-25-pagine-ui.md` per «Dove siamo» e «Prima cosa da fare». Il piano della home resta fermo al passo 2, da spiegare.

## Dove siamo

- Si lavora nel branch git `uiTest`: lì vanno decisioni, descrizioni, design delle pagine diverse dalla home e la futura preview eseguibile con dati di esempio (regola nel `CLAUDE.md`).
- Il design è sul canvas https://claude.ai/artifact/7vzpLWWeYsXy5NBXFqi3JV, privato. La copia sta in `Docs/Progetto/Design/Pagine/project` ed è allineata alla versione 27 del canvas.
- Tutte le scelte, con la data, sono in `Docs/Ai/DECISIONS.md`. Le righe del 2026-10-26 superano quelle di prima sugli stessi punti, e lo dicono.

## Pagine: fatte e mancanti nel canvas

Fatte, design chiuso dall'utente:
- Home: canvas a parte, copia in `Docs/Progetto/Design/Home`, descrizione in `Docs/Progetto/Home.md`.
- Pasti salvati: chiaro e scuro.
- Nuovo pasto e Modifica pasto: la stessa pagina.
- Diario: giorni, settimane, mesi, il singolo giorno e il tema scuro.

Da mettere nel canvas, le pagine meno importanti:
- Benvenuto: pochissime parole, pulsanti grandi, illustrazioni, «Salta» sempre evidente.
- Accesso: con Google, con Apple o con un account proprio; obbligatorio, niente ospite. Le funzioni sono già decise, il design no.
- Scansiona: la fotocamera per la foto del piatto e il codice a barre, e l'esito (il piatto girevole gira sul pasto simile, oppure la proposta di salvarlo).
- Profilo e impostazioni, aperte dal bollino utente: profilo, impostazioni, account, peso; la cancellazione dell'account in fondo a tutto. Le impostazioni già nominate nelle decisioni: formato 12 o 24 ore, famiglia e unità di misura, direzione e numero delle alternative nel piatto, posizione del bollino del diario, riepilogo diretto dei pasti dettati, suggerimenti spenti.
- Riepilogo dei pasti dettati, aperto da «Revisiona» nella Snackbar della home, con l'annullamento.
- Pannello dell'ingrediente personalizzato nella pagina Nuovo pasto, se l'utente conferma la proposta (vedi le domande aperte).
- Il progetto dello smartwatch non ha ancora nessun design: si ricava dal flusso del telefono quando questo è chiuso.

## Fatto in questa sessione

- Diario, sfere delle settimane e dei mesi: contenitori chiari con un liquido solo, livello = giorni registrati, colore = valutazione, superficie che ondeggia. Bocciato il filo in miniatura con i pallini, dopo tre tentativi.
- Diario, serie in corso: accanto alla sfera di oggi brucia l'emoji animata del fuoco di Google (Noto Animated Emoji, WebP caricato sul canvas). Serie spezzata: fiammella ferma e grigia. «Riduci animazioni»: fiammella disegnata, ferma e colorata. Chiude la ricerca del segno della serie attiva; le scintille delle righe del 2026-10-25 erano già bocciate dalla riga dello stesso giorno sul segno della serie.
- Diario, bollino della pillola: la freccia punta verso il centro dello schermo (a sinistra con il bollino a destra, a destra con il bollino a sinistra, in su al centro) e la pillola cresce dal bollino in quella direzione. Provato e bocciato l'effetto gooey (metaball), la goccia che si fonde con la pillola.
- `Docs/Info/Design/EmojiAnimate.md`: dove si scaricano le emoji animate di Google, i formati e la licenza.
- `Docs/Info/Design/EffettoGooey.md`: cos'è l'effetto gooey e come si fa su web, Android e iPhone; bocciato, resta come informazione.

## Prima cosa da fare alla ripresa

1. Chiudere le tre domande aperte:
   - l'ingrediente personalizzato: il + apre un pannello con nome, quantità e valori per 100 g facoltativi; lo stesso pannello scrive i valori di un ingrediente dalla sezione Valori;
   - i valori del pasto intero scritti a mano valgono al posto della somma degli ingredienti;
   - nel diario, oltre al bollino, anche un tocco nel vuoto apre la pillola: tenerlo o no.
2. Chiedere all'utente se disegnare prima le pagine mancanti nel canvas oppure scrivere prima le descrizioni delle pagine fatte in `Docs/Progetto`, un file per pagina come `Home.md` (proposti: `PastiSalvati.md`, `Pasto.md`, `Diario.md`), con il link al canvas. Va chiesto chi le scrive: in questa fase si scrivono solo piano, decisioni e conoscenze.
3. Poi la preview eseguibile dell'app nel branch `uiTest`, senza logica di backend e con dati di esempio.

## Aperti

- Licenza delle emoji animate: CC BY 4.0 secondo pagine di terzi; da verificare sulla pagina ufficiale di Google prima di usarle nell'app.
- Il fuoco nell'app vera richiede la libreria Lottie, su Android e su iPhone: è una dipendenza in più, da chiedere all'utente quando si scrive il diario.
- Fattibilità dell'esportazione verso Google Health, segnata come volontà nelle decisioni: su Android passa da Health Connect (a memoria, da verificare online).
- Il file `Docs/Progetto/Design/Pagine/project/DiarioSettimana.dc.html` è stato tolto dal canvas ma resta sul disco: l'utente lo cancella.
- Nulla di questa sessione è in un commit: `Docs/Ai/DECISIONS.md`, `Docs/Progetto/Design/Pagine/project/Diario.dc.html`, i due file nuovi in `Docs/Info/Design`, questo handoff.

## Da sapere sul canvas

- Le animazioni di entrata ripartono quando la tavola entra nello schermo, quando si allarga a tutta finestra, o cambiando l'opzione «rivedi» nei Tweaks.
- Nel diario, l'opzione «maniglia» dei Tweaks sposta il bollino della pillola a destra, a sinistra o al centro, e con lui la freccia e il verso di apertura.
- Il fuoco animato è un file caricato sul canvas: `/_blob/c9f4c04247d609fb7625487c5f55401e`.
