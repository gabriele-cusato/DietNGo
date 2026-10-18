# Handoff 2026-10-15: risposte dell'utente e nuova proposta per la home

Sostituisce l'handoff `2026-10-14-progetto-telefono.md` per «Dove siamo», «Cosa ha detto» e «Prossimo passo». Di quello restano valide le sezioni «Come l'utente vuole lavorare», «I principi dell'utente», «Ancora da verificare online» e «Da proporre all'utente».

## Prima cosa da fare alla ripresa

0. Riscrivere in chat, alla lettera e per intero, il file `Docs/Ai/HANDOFF/2026-10-15-risposta-claude-home.md`: è l'ultima risposta di Claude, che l'utente non ha ancora valutato. Poi riprendere dai suoi commenti.
1. Leggere parola per parola `Docs/Ai/HANDOFF/2026-10-15-risposta-utente.md`: è la copia esatta della risposta dell'utente a tutta la proposta del 2026-10-14, che sta in `2026-10-14-risposta-progetto.md`. L'utente ha risposto a tutto e non vuole ripetere niente.
2. Rileggere la proposta della home «La linea della giornata» qui sotto e i commenti dell'utente, se ne ha dati.
3. Fare il design della home con il tipo di Artifact «Design» direttamente da Claude Code: è disponibile in questo account. Una cosa alla volta: prima solo la home.

## Dove siamo

Progetto dell'app, flusso del telefono. La tavola vista dall'alto è stata quasi tutta bocciata: piatto, scorrimento, posate, segnaposto, bicchiere e saluto non convincono. Restano la fiammella, le spanne, il punteggio, i gesti del diario. Molte proposte grafiche non convincono a parole, quindi si passa a vedere un design.

## Sintesi delle risposte dell'utente

Le regole che valgono oltre questa tappa sono anche righe di `Docs/Ai/DECISIONS.md` con data 2026-10-15.

- **Stile a due voci.** La base è professionale ma stravagante: forme non convenzionali e posizionamento fuori dallo standard. Le illustrazioni sono giocose e colorate. Due stili insieme, «come vestirsi di nero e giallo»: stanno bene insieme, ma l'abbinamento va visto.
- **Gli effetti devono avere un senso.** Un effetto messo tanto per metterne uno sembra forzato: bocciati la forchetta e gli ingredienti che si girano nell'accesso.
- **Ordine delle azioni.** Prima registrare un pasto mangiato. Poi, poco meno importante, comporre un pasto. Modificarlo è meno importante.
- **Deve reggere con tanti pasti salvati.** Uno scorrimento uno alla volta funziona solo con pochi pasti.
- **L'app non deve chiedere di essere usata spesso.** Per questo l'acqua è bocciata: si beve spesso, e registrarla porterebbe ad aprire l'app di continuo.
- **Meno elementi.** Più elementi ci sono, meno convince la disposizione.
- **Effimeri.** Fiammella sì. Faccine no: per le sensazioni serve altro. Bigliettino dei pasti dettati incerto, perché dipendeva dalla tavola.
- **Accesso.** Niente «Continua senza account»: niente utente ospite. Serve un'idea creativa diversa per l'effetto.
- **Benvenuto.** Va più o meno bene, da aggiustare dopo.
- **I miei pasti.** Coltello no. Una pagina per momento non dispiace, ma vuole anche altre proposte. Schede, tocco che allarga, stellina e «Componi» vanno bene.
- **Comporre un pasto.** Niente alimenti che cadono. Il pasto ha un nome scelto dall'utente e un'illustrazione scelta dall'utente. Quantità in grammi o pezzi, niente poco, normale o tanto. Il resto va bene.
- **Diario.** Forchetta no. Il calendario statico sembra «piatto»: può esistere come vista, ma quella di base dev'essere accattivante. Gesti e azioni vanno bene.
- **Valutazione del giorno.** Con i valori nutrizionali si usano quelli. Senza, si cerca nel database un piatto simile al nome dato dall'utente e se ne prendono i valori. Se non somiglia a niente, il giorno resta grigio senza valutazione.
- **Pasti dettati.** Vanno bene, salvo il bigliettino.
- **Impostazioni.** Ci si arriva dopo. **Account:** va bene.
- **Foto del piatto.** Non serve per forza Gemini: le foto si fanno ad app aperta, quindi basta una libreria specializzata nel riconoscimento del cibo, da cercare.
- **Promemoria** ok. **Digiuno** ok, ma il bordo del piatto non convince. **Ricomprare un prodotto** può andare. **Peso** va bene.

## Proposta della home in attesa di risposta: «La linea della giornata»

Data in chat il 2026-10-15, in breve.
- Una sola linea sinuosa scende lungo lo schermo: è la giornata. Sopra ci sono i momenti come tappe: colazione, pranzo, cena e spuntini. Riprende i punti su una linea comune che all'utente piacevano, ma senza piatto.
- La tappa di adesso è grande, con una forma morbida non rettangolare e l'illustrazione colorata del pasto consigliato dal punteggio. Un tocco lo registra.
- Sotto, due o tre alternative piccole, le successive per punteggio, e un campo di ricerca che trova fra tutti i pasti salvati scrivendo o a voce. Così regge anche con cento pasti. In fondo, «Nuovo pasto».
- Le tappe passate mostrano in piccolo l'illustrazione di ciò che si è mangiato; quelle future sono tenui.
- La linea parte in alto dal bollino utente: la giornata comincia da te. La fiammella brucia lì al primo ingresso del giorno.
- Scorrendo verso l'alto la linea continua nei giorni passati: è il diario, senza pulsante.
- Tenendo premuta la tappa grande si cambiano ora e quantità prima di registrare.

## Come usare il design

Il tipo di Artifact «Design» crea una tela con schermate disegnate, privata e visibile su claude.ai. Claude lo può usare da qui. Alla ripresa: con l'ok dell'utente, creare la tela «DietNGo – Home» con due o tre varianti della linea della giornata, in stile Google con base sobria e illustrazioni colorate, e farle commentare.

## Scelte che aspettano l'utente

- La linea della giornata come home.
- La finestra intorno all'orario del pasto: un'ora o mezz'ora.
- Chi segna un giorno «andato bene» quando ci sono i valori: solo l'app, o anche l'utente con un tocco.
- Il nome e la cartella del file del progetto dell'app.
- Le due regole generali proposte in chat il 2026-10-15 per le linee guida (vedi sotto).

## Da proporre all'utente

Oltre alle due dell'handoff del 2026-10-14, due regole possono diventare linee guida generali in `Docs/Guidelines`:
- Un effetto o un'animazione entra solo se ha un senso nel contesto, mai per decorare.
- Un'app non essenziale non deve spingere a essere aperta più spesso del necessario.

## Fatto in questa sessione sui file

- `Docs/Ai/HANDOFF/2026-10-15-risposta-utente.md`: copia esatta della risposta dell'utente.
- `Docs/Ai/DECISIONS.md`: aggiunte le righe del 2026-10-15.
- Questo handoff. Nessun codice toccato, nessun piano da modificare: per il progetto dell'app non esiste ancora un piano.
