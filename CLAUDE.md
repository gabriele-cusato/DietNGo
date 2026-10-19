# DietNGo

## Scopo

DietNGo registra i pasti abituali nel modo più rapido possibile: con un tocco, oppure a voce tramite Gemini senza aprire l'app, sull'orologio o sul telefono. Un pasto è un insieme di alimenti e bevande che l'utente compone una volta e poi registra al volo. L'app si usa dal telefono, dall'orologio o da tutti e due: il telefono da solo basta, e l'orologio fa le cose più frequenti senza tirare fuori il telefono. L'app è autonoma: niente Google Health, niente Health Connect per ora, nessun valore nutrizionale obbligatorio. Il telefono serve anche a comporre i pasti, a vedere il diario e a importare da Google Tasks i pasti dettati a voce.

## Linguaggio e framework

- Il progetto è un'app per orologio con una companion per telefono, tutte e due scritte in Kotlin. La parte principale è l'orologio: il telefono fa da supporto.
- L'orologio è un Pixel Watch con Wear OS, la versione di Android per gli orologi. La sua interfaccia si scrive con Compose for Wear OS, il sistema che Google raccomanda per gli orologi, dove l'interfaccia si scrive come funzioni Kotlin.
- Se orologio e telefono devono scambiarsi dati, il canale standard è la Data Layer API, il servizio di Google che passa dati e messaggi fra un orologio e il suo telefono. Le due app devono avere lo stesso nome di pacchetto e la stessa firma, altrimenti il canale non le collega.
- Il progetto si crea e si compila con Android Studio, il programma di Google per le app Android.
- Gli esempi delle regole generali e delle linee guida sono scritti in C#: qui valgono le stesse regole, scritte con la sintassi e le convenzioni che la documentazione di Kotlin dà.

## Regole di lavoro

- L'utente viene da C#, .NET e Visual Studio: non conosce Kotlin e non ha mai usato Android Studio. Le spiegazioni partono da lì e, quando aiuta, portano il parallelo con C# e .NET.
- Quando serve una spiegazione, arriva in pillole e nel momento in cui serve: di Kotlin e di ogni tecnologia che l'utente non ha mai usato, come Supabase, si spiega solo ciò che serve al passo in corso, applicato a quello che si sta costruendo in quel passo. Non si spiega tutto prima per poi costruire tutto dopo: la conoscenza arriva un pezzo alla volta, vista all'opera sul lavoro reale.
- Nelle risposte all'utente il modulo `app` si chiama «il progetto dello smartwatch», non «l'orologio»: per l'utente «orologio» è quello che dice l'ora.
- I parallelismi con C# già usati e le correzioni dell'utente stanno nel file `Docs/Info/Spiegazioni/ParallelismiCSharp.md`: ogni spiegazione li riusa e aggiunge lì quelli nuovi.
- L'Assistente Google è deprecato e sostituito da Gemini: ricerche, proposte e spiegazioni sui comandi vocali parlano solo di Gemini.
- I commenti del codice si scrivono in italiano.
- I nomi di classi, metodi, variabili, pacchetti, tabelle e colonne si scrivono in inglese.
- Le librerie si usano nella versione stabile più recente, verificata online e non a memoria.
- Prima di una decisione di architettura grossa o di una dipendenza pesante si chiede all'utente.
- I warning si risolvono, non si ignorano e non si nascondono: quelli del compilatore, di Gradle, di Android Studio e quelli di obsolescenza. L'app deve restare pulita per durare nel tempo. Un warning che non si riesce a risolvere si riporta all'utente con il motivo: lasciarlo o sopprimerlo lo decide lui.
- Le informazioni verificate online che possono riservire si scrivono nella cartella `Docs/Info`, in una sottocartella per argomento, con la data della verifica e le pagine lette. Prima di cercare online si guarda lì.

## Come si procede con il codice

- Si segue una lista di feature in ordine: prima le fondamenta che servono alla prima feature, poi le feature successive.
- Si tratta un punto alla volta, in quattro parti brevi: la feature, cosa si fa nel codice, le fondamenta che mancano o quelle esistenti da usare, le cose di Kotlin che servono a capirle.
- Le risposte sono molto brevi. L'utente non conosce Kotlin, e un testo lungo lo disperde.
- Togliere codice o file e creare file nuovi lo fa l'utente, a meno che non chieda espressamente di farlo. Il piano e le risposte gli indicano ogni pezzo da togliere e ogni file da creare, con cosa è e cosa contiene.

## Struttura del codice

- Ogni cosa sta nel suo posto, separata dal resto. Colori e stili stanno in un posto, l'accesso ai dati, come il database o le API, in un altro, la logica in un altro ancora. Per cambiare un colore o il modo di collegarsi al database non si tocca la logica.
- La logica sta nei file pilota. Contengono solo il flusso principale dell'app e la raccolta e la gestione degli errori: vedi P4 in `Docs/Guidelines/Generali/Propedeutici/Propedeutici.md`.
- Il log fa parte delle fondamenta: vedi la decisione del 2026-10-19 in `Docs/Ai/DECISIONS.md`.
- Ogni funzione `@Composable` ha la sua `@Preview`, quando è possibile: serve a controllarla e a capirla anche dopo mesi, senza avviare l'app.

## Progetto dell'app e design

- La descrizione di ogni pagina dell'app, con le scelte di esperienza d'uso, sta nella cartella `Docs/Progetto`, un file per pagina: oggi c'è `Docs/Progetto/Home.md`. Il design di una pagina sta in `Docs/Progetto/Design/<Pagina>`, copia dei file del canvas; il link al canvas è scritto nel file della pagina.
- Prima di un piano o di codice che riguarda una pagina si legge, senza chiedere, il suo file in `Docs/Progetto`. I file del design si leggono solo quando servono misure, colori, animazioni o la disposizione esatta: in quel caso basta il file `Main.dc.html` della pagina, che contiene tutta la pagina.
- Le scelte che valgono per tutta l'app, come colori, regole sui dati, pasti dettati e piattaforme, stanno in `Docs/Ai/DECISIONS.md`, che si legge già a inizio sessione.

## Linee guida

- Le linee guida stanno nella cartella `Docs/Guidelines`: l'indice è il file `Docs/Guidelines/Indice.md`.
- Alla prima richiesta di una sessione che prepara un piano o modifica il codice si leggono, senza chiedere, l'indice e i punti generali, cioè il file `Docs/Guidelines/Generali/Propedeutici/Propedeutici.md`. Poi, prima di ogni passo, si leggono solo le sezioni che lo riguardano: quelle della riga «Regole:» del piano, oppure, senza piano, quelle scelte dalla tabella «Sezioni» dell'indice.
- In un piano ogni passo porta, subito dopo la riga «Perché:», la riga «Regole:» con le regole da leggere prima di scriverlo, ciascuna con la sigla e il file: «Regole: P4 in `Docs/Guidelines/Generali/Propedeutici/Propedeutici.md`».
- Se dalla richiesta dell'utente, o dal lavoro da fare, traspare una regola nuova o uno standard usabile anche in altri progetti, va proposto all'utente; se lo approva, si scrive nella sezione che lo riguarda sotto `Docs/Guidelines` e si aggiorna il file `Docs/Guidelines/Indice.md`. La regola ha la forma di quelle che ci sono già, cioè Perché, Quando, Come, Non così, e si scrive in forma generale, senza i nomi di questo progetto. Se la sezione non esiste ancora, la proposta dice anche l'area e il nome della sezione nuova.
- Ogni regola nuova scritta nelle linee guida ha una riga in fondo al file `Docs/Guidelines/RegistroRegole.md`, creato se manca: la data, la sigla e «accettata» se l'utente l'ha approvata così com'era, oppure «corretta» con ciò che ha cambiato. «2026-10-12 | K3 | corretta: il Perché non diceva il problema».
