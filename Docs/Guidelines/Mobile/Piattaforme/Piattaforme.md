# Piattaforme

Regole per le app su Android e iPhone. Valgono solo fra queste due piattaforme: per altri sistemi non serve un corrispettivo. L'indice di tutte le voci è `Docs/Guidelines/Indice.md`.

---

## M1. Ogni soluzione usa la strada ufficiale e ha un corrispettivo ufficiale sull'altra piattaforma

**Perché**: una soluzione che aggira la piattaforma funziona oggi e si rompe al prossimo aggiornamento del sistema, oppure consuma batteria e viene chiusa dal sistema senza avviso. Il programmatore se ne accorge tardi, dalle segnalazioni degli utenti, e deve rifare il pezzo. Se poi l'app deve arrivare anche sull'altra piattaforma e la soluzione lì non ha un equivalente, il pezzo va ripensato da zero. Con la strada ufficiale su tutte e due, il comportamento è quello che il sistema garantisce e il passaggio all'altra piattaforma è una traduzione, non un progetto nuovo. Quindi: prima di adottare una soluzione si verifica che sia la strada ufficiale e che l'altra piattaforma ne abbia una ufficiale per la stessa cosa.

**Quando**: a ogni scelta che tocca il sistema: lavori in sottofondo, notifiche, comandi vocali, permessi, sincronizzazione, avvio dell'app da fuori.

**Come**:
- Si cerca nella documentazione ufficiale di tutte e due le piattaforme come si fa la cosa, e si scrivono le due strade una accanto all'altra.
- Se una delle due non ha una strada ufficiale, oppure ce l'ha solo in anteprima, lo si dice all'utente e si propone di rivedere la richiesta: rimandare la funzione, ridurla, oppure farla in un momento in cui la strada ufficiale esiste.
- Una strada ufficiale ma in anteprima non si adotta come unica: si affianca a una soluzione stabile, che resta come ripiego.

**Non così**: un controllo periodico che gira in sottofondo per accorgersi di un cambiamento, quando né il servizio esterno né il sistema danno un avviso; un servizio tenuto vivo a forza perché il sistema non lo chiuda; una soluzione adottata «perché su Android funziona» senza aver guardato come si fa su iPhone.
