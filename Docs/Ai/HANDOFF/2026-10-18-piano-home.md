# Handoff 2026-10-18: verso il piano della home

Sostituisce `2026-10-18-home-design.md` per «Dove siamo» e «Prima cosa da fare». Di quello restano valide le voci «Aperti» e «Fatto in questa sessione sui file».

## Dove siamo

Il design della home del telefono è chiuso e approvato dall'utente. Tutto quello che la home fa e mostra sta in `Docs/Progetto/Home.md`; il design sta sul canvas https://claude.ai/artifact/3x4yjV4ViJt5dKqkX5CD6V e nella sua copia `Docs/Progetto/Design/Home`, dove `Main.dc.html` contiene tutta la pagina. Le scelte, con la data, sono in `Docs/Ai/DECISIONS.md`. Nessun codice è stato scritto per la home.

L'utente ha scelto di non passare subito alle altre pagine: il prossimo passo è realizzare la home e, con lei, la struttura di base del codice che servirà anche alle pagine dopo.

## Prima cosa da fare alla ripresa

1. Leggere, come dicono le regole del progetto, le linee guida generali e `Docs/Progetto/Home.md`. Il design si apre solo per le misure, i colori e le animazioni.
2. Guardare lo stato attuale del codice nei moduli `app` (orologio) e `mobile` (telefono): il pacchetto è stato portato a `com.gabrielecusato.dietngo` e i file d'esempio sono stati tolti, ma la struttura effettiva va verificata nei file, non supposta.
3. Pianificare con l'utente la struttura di base del codice e la realizzazione della home, fino al piano finale in `Docs/Ai/Plans`, uno per tappa.

## Come va condotto il lavoro

- L'utente non conosce Kotlin né Android Studio: ogni concetto si spiega in pillole, quando serve, applicato a quello che si costruisce, con il parallelo C# e .NET dove aiuta. I paralleli già usati stanno in `Docs/Info/Spiegazioni/ParallelismiCSharp.md` e i nuovi si aggiungono lì.
- Si arriva al piano finale passo per passo. A ogni punto in cui c'è una scelta, l'utente va fermato e gli si chiede: costi, benefici, cosa si consiglia.
- Le librerie si usano nella versione stabile più recente, verificata online; prima di una dipendenza pesante o di una scelta di architettura grossa si chiede.
- Vale la regola M1: ogni soluzione usa la strada ufficiale della piattaforma e ha un corrispettivo ufficiale su iPhone.

## Scelte che il piano farà emergere

Da presentare all'utente, non da decidere da soli:
- come si separano schermata, logica e dati;
- come si passa da una pagina all'altra;
- come le classi ricevono ciò che usano, a mano o con una libreria;
- la libreria per il database locale SQLite;
- quando e come si collega Supabase;
- se nasce già ora il modulo `shared` per il codice comune con l'orologio;
- come si organizzano tema, colori fissi e accenti dal sistema;
- come si realizzano piatto girevole, gesti, animazioni, vibrazione, Snackbar con coda, finestra con lo zoom lento;
- con quali dati finti si prova la home prima che esistano le altre pagine.

## Aperti

Sono quelli dell'handoff `2026-10-18-home-design.md`: sensazioni, foto della finestra, errori dei pasti dettati, stile finale delle illustrazioni, calcolo dei suggerimenti, voci rimaste dal 2026-10-15, regole da proporre per le linee guida.

## Fatto in questa parte della sessione sui file

- `CLAUDE.md`: nuova sezione «Progetto dell'app e design», che dice quali file leggere per sapere cosa è stato scelto.
- Questo handoff.
