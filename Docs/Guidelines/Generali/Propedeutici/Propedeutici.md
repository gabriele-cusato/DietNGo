# Punti generali

Punti propedeutici delle linee guida: gli obiettivi generali, validi per ogni linguaggio, da leggere prima di ogni altra sezione. L'indice di tutte le voci, con le convenzioni per leggerle, è `Docs/Guidelines/Indice.md`.

---

## P1. Il codice si capisce al volo anche dopo mesi

**Perché**: il programmatore riapre un progetto dopo mesi, spesso per una correzione urgente, e non ricorda niente. Il tempo che conta non è quello speso a scrivere il codice, ma quello speso a rileggerlo. Un codice più lungo ma piano si rilegge in un attimo; un codice compresso costringe a fermarsi su ogni riga per ricostruire cosa fa. Quindi: fra due forme equivalenti si sceglie quella che si legge senza fermarsi, anche se ha più righe.

**Come si applica**: forme estese al posto di quelle compresse, strutture dati native e conosciute da tutti, nomi che dicono cosa è la cosa.

## P2. Ogni cosa sta in un punto solo, facile da trovare, cambiare ed espandere

**Perché**: prima o poi qualcosa cambia: la libreria che parla con il db, il testo di un errore, un elenco di varianti. Se quella cosa è scritta in venti righe sparse per il progetto, il programmatore deve trovarle tutte, e quella che dimentica diventa un errore. Se sta in un punto solo, il programmatore sa dove andare, cambia lì e ha finito; e aggiungere un caso nuovo vuol dire aggiungere una riga in quel punto. Quindi: si separano i livelli e si avvolge ciò che può cambiare, così un cambio tocca un punto e non tutte le righe che usano la cosa.

**Come si applica**:
- Un valore usato in più righe diventa una costante.
- Più cose dello stesso tipo stanno in un dizionario in cima al file.
- Una libreria esterna si usa in una classe sola, che la avvolge.
- Un compito ripetuto in più classi diventa un metodo solo.

## P3. Il compromesso fra P1 e P2 lo decide l'utente, in fase di pianificazione

**Perché**: P1 e P2 tirano in direzioni opposte. Separare e avvolgere aggiunge pezzi, cioè una classe in più o un livello in più, e ogni pezzo in più è una cosa in più da capire. Non esiste una risposta valida sempre: dipende da quanto il progetto crescerà, e questo lo sa il programmatore, non il modello. Quindi: il modello non sceglie da solo. Mentre prepara il piano riporta la scelta all'utente con costi e benefici, dice cosa consiglia e aspetta la risposta.

**Come si applica**:
- La scelta si scrive nel piano in una riga con quattro pezzi: cosa si aggiunge, cosa si guadagna, cosa costa, cosa consiglio. «Le chiamate alla libreria delle mail sono sei, in tre file. Propongo un servizio nuovo MailService, circa ottanta righe, unico a usare la libreria: per cambiare libreria si cambia un file. Costo: una classe in più e le sei chiamate da riscrivere. Lo consiglio.»
- Raggruppare vale la pena solo quando le cose da raggruppare sono diverse. Con una cosa sola basta una variabile o una costante: un dizionario con una riga è solo un pezzo in più.
- Senza la risposta dell'utente resta la forma più semplice.

## P4. Metodo pilota e metodi foglia

**Perché**: un'operazione, come l'invio di un ordine, è fatta di più passi. Se i passi stanno in metodi che si chiamano a catena, per capire cosa fa l'operazione il programmatore deve aprirli tutti e ricostruire l'ordine a mente. Con un metodo pilota l'ordine dei passi e le scelte stanno in un metodo solo, che si legge dall'alto in basso come un indice. Il programmatore lo rilegge in un minuto anche dopo mesi, e apre un metodo foglia solo quando gli serve quel dettaglio. Quindi: un metodo tiene il flusso, gli altri eseguono un compito ciascuno.

**Quando**: ogni operazione che parte da fuori ha il suo metodo pilota: il clic su un pulsante, l'apertura di una pagina, una richiesta che arriva al server, l'avvio del programma.

**Come**:
- Il metodo pilota è il primo metodo nostro che parte per quell'operazione. Contiene l'ordine dei passi, gli `if` che scelgono la strada e il `try/catch`.
- Un metodo foglia esegue un compito solo, in poche righe. Un metodo foglia restituisce il risultato oppure lancia un'eccezione: non decide cosa succede dopo e non mostra niente all'utente.
- Un metodo di servizio chiamato dal metodo pilota è una foglia anche quando chiama altri metodi suoi.
- Per un ramo dubbio vale la domanda «per capire il flusso devo vedere dentro questo ramo?». Se la risposta è sì, la scelta sale nel metodo pilota.
- Un metodo foglia minuscolo usato in un punto solo non si crea: le sue righe restano nel metodo pilota, con un commento.

```csharp
// Pilota: lo chiama il pulsante «Invia». Qui si legge tutto il flusso dell'invio
private void SendOrdine()
{
    try
    {
        CheckOrdine(_ordine);
        decimal totale = CalculateTotale(_ordine);
        if (totale > _cliente.Fido)
        {
            // sopra il fido del cliente: l'ordine resta in attesa di approvazione
            SaveOrdine(_ordine, EnumStatoOrdine.InAttesa);
        }
        else
        {
            // dentro il fido: l'ordine parte subito
            SaveOrdine(_ordine, EnumStatoOrdine.Inviato);
        }
    }
    catch (Exception ex)
    {
        ShowErrMsg(ex);
    }
}
```

**Non così**: il confronto con il fido nascosto dentro il metodo SaveOrdine, oppure un metodo CheckOrdine che mostra da solo il messaggio all'utente. In tutti e due i casi il flusso non si legge più dal metodo pilota.

## P5. Ciò che deve gestire chi non ha scritto il codice sta fuori dal codice

**Perché**: non tutto quello che cambia lo cambia il tecnico che ha sviluppato l'applicazione. Un collega che conosce il db può dover correggere una query; un altro deve cambiare un indirizzo o un testo. Se quella cosa sta dentro il codice sorgente, il collega non la può toccare: deve chiamare il tecnico, che deve modificare, ricompilare e reinstallare. Se la cosa è separata dal codice e messa dove il collega sa arrivare, il collega ci mette le mani da solo. Quindi: ciò che gli esterni devono poter gestire si separa dal codice sorgente e si rende accessibile a loro.

**Come si applica**:
- Una query che un collega deve poter cambiare sta in un file a parte e non nella classe del codice.
- Un valore che i colleghi gestiscono sta in una tabella del db; un valore tecnico sta nel file di configurazione.
- Ciò che arriva da fuori viene controllato dal codice prima dell'uso: una modifica sbagliata del collega deve dare un errore che dice cosa correggere, non un dato perso in silenzio.
- Mentre prepara il piano, se non è chiaro chi dovrà cambiare una cosa, il modello lo chiede: «questa query la mantieni tu o un collega?».
