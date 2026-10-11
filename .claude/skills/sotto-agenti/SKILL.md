---
name: sotto-agenti
description: Caricare nella fase di codice quando DECISIONS.md prevede i sotto-agenti o quando l'utente li chiede; altrimenti la fase di codice lavora da sola. Contiene chi esegue la modifica, cosa si delega ad Agent-Explorer, Agent-Code e Agent-Search e cosa si passa loro. È la skill del setup a due fasi, mentre orchestrazione, flusso-rapido e flusso-completo sono del setup con howTo.
---

# Sotto-agenti

Il piano è già scritto e approvato nella fase di spiegazione: qui si decide solo chi esegue e cosa gli si passa. Le regole di «Come scrivo» valgono anche per le istruzioni ai sotto-agenti.

## Chi esegue
- Dichiaro chi eseguirà la modifica: io, o quale sotto-agente. Se prevedo più sotto-agenti, motivo perché servono più istanze invece di una sola, con i criteri della skill parallelizzazione, da caricare prima.
- Con un sotto-agente il tempo cresce, perché riparte senza contesto, e in cambio il mio contesto resta pulito: lo dico in una riga quando propongo la delega, e la scelta resta all'utente.
- Quando servono altri file da leggere, mi fermo prima di aprirli e propongo: li leggo io, oppure li cerca Agent-Explorer con istruzioni mirate e mi restituisce una sintesi. La risposta va in DECISIONS.md e da lì in poi vale senza richiederla. Un bug ostico che la delega non ha risolto lo guardo io.

## Cosa delego
- Esplorazione del codice: Agent-Explorer, in sola lettura, quando l'utente lo ha scelto o DECISIONS.md lo prevede.
- Scrittura di codice: Agent-Code, con il percorso del piano. Gli passo i fatti che ho già verificato, i file da toccare, i vincoli, le decisioni prese sui punti aperti, compreso un comportamento nativo mascherato che l'utente ha approvato, e le eventuali skill di progetto da caricare; le regole in .claude/rules/ non vanno indicate, si caricano da sole. Un passo del piano per volta: passo il piano, aspetto la fine, verifico il codice contro il piano, poi passo al successivo; mai l'intera feature in una chiamata.
- Ricerche online ampie, con più fonti e verifica lunga: Agent-Search, quando l'utente lo ha scelto; quelle brevi le faccio io.
- Documentazione locale generata da un sito: sempre Agent-Code; la procedura di verifica e preparazione sta nella skill docs-workflow-guide, da caricare quando l'utente chiede lo scraping di documentazione. Non eseguo mai scraping e non carico la skill docs-scraper.
