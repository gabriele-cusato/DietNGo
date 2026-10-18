# Risposta di Claude del 2026-10-14 sul progetto dell'app

Copia esatta della risposta data in chat. È una proposta: niente di questo è confermato, salvo ciò che l'utente ha già detto ed è annotato nell'handoff dello stesso giorno.

---

## Accesso

La forchetta non va scartata del tutto, ma come idea principale sì. Un personaggio con la faccia non c'entra con lo stile pulito di Google, e due idee nella stessa schermata si fanno concorrenza. Dalla forchetta si può però prendere un gesto. Quando l'utente scrive la password, gli ingredienti che fluttuano si girano dall'altra parte o si allontanano dal riquadro, come per non guardare. Il gesto non dipende dalla lunghezza della password: parte quando il campo prende il cursore e finisce quando lo lascia.

## L'azione principale

L'azione principale è registrare un pasto salvato. Un pasto è un insieme di alimenti e bevande, per esempio la tua colazione tipo. L'utente lo compone una volta e poi lo registra con un tocco. Tutto il resto è secondario: sta più in piccolo, più in là, o compare solo quando serve.

## Home: «la tavola»

La home è una tavola vista dall'alto, con al centro un grande piatto. La disposizione non è quella standard, ma ogni elemento resta un pulsante grande e riconoscibile, quindi l'uso non peggiora.

- **Il piatto al centro.** Mostra il pasto consigliato adesso, illustrato con le icone dei suoi alimenti e con il nome sotto. Un tocco sul piatto lo registra: il cibo «scende» dal piatto con un'animazione e il piatto resta vuoto per un attimo.
- **Scorrere il piatto.** Scorrendo il piatto a destra o a sinistra, girano gli altri pasti dello stesso momento della giornata, uno alla volta. L'ultimo è un piatto vuoto con il «+»: serve per registrare qualcosa che non è fra i pasti salvati.
- **Dopo il tocco.** In basso compare per qualche secondo una striscia con «Registrato», «Annulla» e «Cambia ora».
- **Il bordo del piatto.** Fa da riepilogo della giornata senza aggiungere elementi. Sul bordo ci sono dei puntini, uno per colazione, pranzo, cena e spuntini. Un puntino pieno è un pasto registrato, un puntino vuoto è un pasto non ancora registrato, e il puntino del momento attuale pulsa piano.
- **Il bicchiere d'acqua.** Sta accanto al piatto, come a tavola. Ogni tocco aggiunge un bicchiere e l'acqua sale con un'animazione.
- **Il segnaposto.** È il bollino utente, al posto del cartoncino con il nome che a tavola indica dove ci si siede. Sta in alto, con la foto e il saluto dell'ora, per esempio «Buongiorno». Toccandolo si apre il riquadro con account, impostazioni e uscita.
- **La forchetta a sinistra.** Apre il diario, cioè il passato.
- **Il coltello a destra.** Apre «I miei pasti», dove si compongono e si modificano i pasti.

Le posate hanno una piccola etichetta, almeno nei primi giorni: senza, chi apre l'app la prima volta non capirebbe che sono pulsanti.

Ci sono poi tre elementi che compaiono e se ne vanno.

- **La fiammella.** Al primo ingresso del giorno, un pezzetto di carta brucia in pochi secondi. Mostra «12 giorni di fila» e sparisce da solo.
- **Il bigliettino.** Compare sul bordo della tavola solo se c'è un pasto dettato a Gemini che è in Google Tasks ma non è stato registrato. Dice «2 pasti dettati da registrare» e porta il pulsante «Registra».
- **Le faccine.** Dopo una registrazione, accanto al piatto galleggiano per tre secondi tre faccine: sazio, così così, gonfio. Se l'utente ne tocca una, la sensazione si salva; se non la tocca, le faccine svaniscono e non si salva niente.

## Quali pasti mostra il piatto, e quale per primo

Ogni pasto salvato ha un orario a spanne, cioè «più o meno alle 8». L'app considera una finestra di un'ora prima e un'ora dopo: è una proposta, si può stringere a mezz'ora. Il piatto mostra i pasti la cui finestra contiene l'ora attuale. Se nessuna finestra la contiene, mostra quelli della finestra più vicina.

Fra quei pasti, il primo è quello con il punteggio più alto. Il punteggio somma quattro cose.
- **Vicinanza all'orario.** Più l'ora attuale è vicina all'orario del pasto, più punti.
- **Giorno della settimana.** Più punti se il pasto viene mangiato spesso in quel giorno, per esempio la pizza del sabato.
- **Varietà.** Meno punti se il pasto è stato mangiato di recente, e ancora meno se è stato mangiato ieri: così l'app spinge a variare.
- **Preferito.** Pochi punti in più se il pasto è segnato come preferito.

Indovinare sempre il pasto giusto non è possibile. L'obiettivo realistico è che sia il primo quasi sempre, e il secondo a una passata di dito. L'app può anche imparare: se l'utente scorre spesso fino a un pasto, quel pasto sale.

## Le pagine

### 1. Benvenuto

Compare al primo avvio, prima dell'accesso. Sono tre schermate quasi senza parole, ognuna con una grande illustrazione animata, e in alto c'è sempre il pulsante grande «Salta», che porta dritto all'app.

1. **«Un tocco, ed è fatto.»** Un dito tocca un piatto e il piatto si svuota.
2. **«Oppure dillo al polso.»** Un orologio con l'onda della voce di Gemini, l'assistente vocale di Google. Gemini funziona sugli orologi con Wear OS 4 o successivo, la versione di Android per gli orologi: non solo sui Pixel Watch, ma anche sui Galaxy Watch dal 4 in poi, sui OnePlus, Xiaomi e altri. Quindi lo si può mettere in evidenza.
3. **«Pronti.»** Due pulsanti grandi: uno per permettere le notifiche, uno per collegare l'orologio. Tutti e due si possono saltare.

Per «Salta» serve un utente ospite, cioè senza account. I suoi dati restano solo sul telefono e passano all'account quando l'utente accede. L'utente ospite ha tre limiti: niente copia dei dati su Supabase, niente orologio senza telefono e niente uso su due telefoni.

### 2. Accesso

Al centro c'è il riquadro, con nome utente, password e i due pulsanti rettangolari Google e Apple. Sotto c'è il collegamento «Continua senza account». Dietro, gli ingredienti fluttuano piano con i colori del sistema, e quando si scrive la password si girano dall'altra parte. Quando l'accesso riesce, gli ingredienti si raccolgono al centro e diventano il piatto della home.

### 3. Home

È «la tavola», descritta sopra.

### 4. I miei pasti

Si apre dal coltello. Ha l'aspetto del menù di un ristorante, con una pagina per ogni momento: Colazione, Pranzo, Cena, Spuntini. Si passa da una pagina all'altra scorrendo di lato, come le pagine di un libro.

- **Le schede dei pasti.** Ogni pasto è una scheda con l'illustrazione composta dalle icone dei suoi alimenti, il nome e l'orario a spanne.
- **Toccare una scheda.** La scheda si allarga e diventa la pagina del pasto, senza cambio di schermata a scatto.
- **La stellina.** Sulla scheda segna il pasto come preferito.
- **Il pulsante «Componi».** Sta in fondo alla pagina e crea un pasto nuovo nel momento che si sta guardando.

### 5. Il pasto, da comporre o da modificare

Al centro c'è un piatto vuoto, e gli alimenti «cadono» nel piatto mentre si aggiungono.

- **Aggiungere un alimento.** Si scrive il nome, si sceglie fra quelli già usati o si legge il codice a barre con la fotocamera.
- **La quantità.** Ogni alimento ha una quantità semplice: poco, normale o tanto, oppure i grammi o i pezzi per chi li vuole.
- **L'orario a spanne.** Si sceglie trascinando un sole lungo un arco che va dall'alba alla notte, non scrivendo un'ora esatta.
- **I giorni.** È facoltativo: per esempio «solo nel fine settimana».
- **I valori nutrizionali.** Stanno chiusi in fondo, in una sezione che si apre solo se l'utente la tocca.
- **I pulsanti.** In basso ci sono «Salva» e, più piccolo, «Salva e registra ora».

La stessa pagina serve per registrare un pasto non salvato, quello del piatto vuoto con il «+». In quel caso il pulsante principale diventa «Registra», con l'interruttore «Tienilo fra i miei pasti».

### 6. Diario

Si apre dalla forchetta. È un mosaico di piccoli piatti, uno per giorno, disposti come un calendario. Il colore dice com'è andata: verde se il giorno è andato bene, giallo se c'è stata una trasgressione, rosso se si è mangiato male, grigio se non è stato registrato nulla.

- **Toccare un giorno.** Il piatto si allarga e mostra i pasti del giorno con l'ora.
- **Toccare un pasto del giorno.** Si corregge.
- **Scorrere un pasto di lato.** Si cancella.

Le vecchie «statistiche» stanno tutte qui: non c'è una pagina a parte.

Il punto da decidere è chi stabilisce se un giorno è andato bene. Le strade sono tre: lo segna l'utente con un tocco a fine giornata, lo calcola l'app confrontando i pasti con il piano del nutrizionista, oppure si usano tutte e due.

### 7. Pasti dettati

Non è una pagina. L'app importa da sola i pasti dettati a Gemini che finiscono in Google Tasks, e li abbina ai pasti salvati per nome. Se qualcosa non torna, compare il bigliettino sulla tavola, per esempio quando un pasto è in Google Tasks ma non nell'app, o quando un nome non corrisponde a nessun pasto. Toccando «Registra» si allinea tutto, e solo per i nomi che non corrispondono si apre un piccolo riquadro che chiede quale pasto era.

### 8. Impostazioni

Si apre dal segnaposto. È un elenco breve, ogni voce con la sua icona: acqua giornaliera, promemoria, orologio collegato, unità di misura. In fondo, staccata e in rosso, c'è la cancellazione dell'account.

### 9. Account

È il riquadro che si apre dal segnaposto, come nelle app di Google: foto, nome, il collegamento alle impostazioni e l'uscita.

## Le funzioni in più, con le tue risposte

- **Foto del piatto.** Si può fare: Gemini riconosce un piatto da una foto e ne stima gli alimenti. Le quantità sono una stima grossolana, quindi l'utente conferma sempre. La parte da studiare è come chiamare Gemini senza un server nostro. La strada è Firebase AI Logic, il servizio di Google che fa parlare l'app con Gemini direttamente (a memoria, da verificare online). Ha un costo per foto analizzata (a memoria, da verificare online).
- **Promemoria.** Usa lo stesso punteggio del piatto, quindi propone lo stesso pasto. Parte solo se un momento della giornata è passato senza registrazioni. La notifica ha il pulsante «Registra» per il pasto consigliato e il pulsante «Altro» che apre l'app.
- **Digiuno intermittente.** Il modo furbo è il bordo del piatto. Fra un pasto e l'altro, sul bordo cresce un arco che segna il tempo dall'ultimo pasto, e quando il digiuno è finito l'arco si chiude con un piccolo lampo. Non aggiunge nessun elemento alla tavola.
- **Ricomprare un prodotto.** Sulla scheda di un alimento c'è il campanello «Avvisami di ricomprarlo». La scorta si indica con un tocco su poche, medie o tante, oppure non si indica. Ogni registrazione la abbassa a spanne, e quando è bassa arriva il promemoria «Prendi gli yogurt».
- **Peso corporeo.** Sta nel riquadro del segnaposto, come una piccola riga con l'ultimo peso. Un tocco apre il grafico e permette di aggiungerne uno nuovo.

NB: la tavola è una proposta forte e va provata con un disegno a mano o un prototipo prima di confermarla.
NB: utente ospite, criterio dei giorni «andati bene» e finestra di un'ora o di mezz'ora aspettano una tua scelta.

Fonti sulla verifica di Gemini:
- [Gemini is coming to your Wear OS smartwatch](https://blog.google/products/wear-os/gemini-wear-os-watches/)
- [Android Authority: older Wear OS watches with Gemini](https://www.androidauthority.com/gemini-available-wear-os-smartwatches-3577907/)
- [9to5Google: Gemini for Wear OS rolling out](https://9to5google.com/2025/07/09/gemini-wear-os/)
