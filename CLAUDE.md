# DietNGo

## Scopo

DietNGo registra i pasti abituali nel modo più rapido possibile: con un tocco sull'orologio, oppure a voce tramite Gemini sull'orologio. L'app è autonoma: niente Google Health, niente Health Connect per ora, nessun valore nutrizionale obbligatorio. Il telefono serve a gestire i pasti salvati, a vedere lo storico e a importare da Google Tasks i pasti dettati a voce.

## Linguaggio e framework

- Il progetto è un'app per orologio con una companion per telefono, tutte e due scritte in Kotlin. La parte principale è l'orologio: il telefono fa da supporto.
- L'orologio è un Pixel Watch con Wear OS, la versione di Android per gli orologi. La sua interfaccia si scrive con Compose for Wear OS, il sistema che Google raccomanda per gli orologi, dove l'interfaccia si scrive come funzioni Kotlin.
- Se orologio e telefono devono scambiarsi dati, il canale standard è la Data Layer API, il servizio di Google che passa dati e messaggi fra un orologio e il suo telefono. Le due app devono avere lo stesso nome di pacchetto e la stessa firma, altrimenti il canale non le collega.
- Il progetto si crea e si compila con Android Studio, il programma di Google per le app Android.
- Gli esempi delle regole generali e delle linee guida sono scritti in C#: qui valgono le stesse regole, scritte con la sintassi e le convenzioni che la documentazione di Kotlin dà.

## Regole di lavoro

- L'utente viene da C#, .NET e Visual Studio: non conosce Kotlin e non ha mai usato Android Studio. Le spiegazioni partono da lì e, quando aiuta, portano il parallelo con C# e .NET.
- Quando serve una spiegazione, arriva in pillole e nel momento in cui serve: di Kotlin e di ogni tecnologia che l'utente non ha mai usato, come Supabase, si spiega solo ciò che serve al passo in corso, applicato a quello che si sta costruendo in quel passo. Non si spiega tutto prima per poi costruire tutto dopo: la conoscenza arriva un pezzo alla volta, vista all'opera sul lavoro reale.
- I parallelismi con C# già usati e le correzioni dell'utente stanno nel file `Docs/Info/Spiegazioni/ParallelismiCSharp.md`: ogni spiegazione li riusa e aggiunge lì quelli nuovi.
- I commenti del codice si scrivono in italiano.
- I nomi di classi, metodi, variabili, pacchetti, tabelle e colonne si scrivono in inglese.
- Le librerie si usano nella versione stabile più recente, verificata online e non a memoria.
- Prima di una decisione di architettura grossa o di una dipendenza pesante si chiede all'utente.
- Le informazioni verificate online che possono riservire si scrivono nella cartella `Docs/Info`, in una sottocartella per argomento, con la data della verifica e le pagine lette. Prima di cercare online si guarda lì.

## Linee guida

- Le linee guida stanno nella cartella `Docs/Guidelines`: l'indice è il file `Docs/Guidelines/Indice.md`.
- Alla prima richiesta di una sessione che prepara un piano o modifica il codice si leggono, senza chiedere, l'indice e i punti generali, cioè il file `Docs/Guidelines/Generali/Propedeutici/Propedeutici.md`. Poi, prima di ogni passo, si leggono solo le sezioni che lo riguardano: quelle della riga «Regole:» del piano, oppure, senza piano, quelle scelte dalla tabella «Sezioni» dell'indice.
- In un piano ogni passo porta, subito dopo la riga «Perché:», la riga «Regole:» con le regole da leggere prima di scriverlo, ciascuna con la sigla e il file: «Regole: P4 in `Docs/Guidelines/Generali/Propedeutici/Propedeutici.md`».
- Se dalla richiesta dell'utente, o dal lavoro da fare, traspare una regola nuova o uno standard usabile anche in altri progetti, va proposto all'utente; se lo approva, si scrive nella sezione che lo riguarda sotto `Docs/Guidelines` e si aggiorna il file `Docs/Guidelines/Indice.md`. La regola ha la forma di quelle che ci sono già, cioè Perché, Quando, Come, Non così, e si scrive in forma generale, senza i nomi di questo progetto. Se la sezione non esiste ancora, la proposta dice anche l'area e il nome della sezione nuova.
- Ogni regola nuova scritta nelle linee guida ha una riga in fondo al file `Docs/Guidelines/RegistroRegole.md`, creato se manca: la data, la sigla e «accettata» se l'utente l'ha approvata così com'era, oppure «corretta» con ciò che ha cambiato. «2026-10-12 | K3 | corretta: il Perché non diceva il problema».
