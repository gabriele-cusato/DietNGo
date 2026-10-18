# Google Tasks: avvisi e controlli periodici

Verificato il 2026-10-18.

- L'API di Google Tasks non avvisa quando si aggiunge un'attività: le risorse tasklists e tasks hanno solo delete, get, insert, list, patch, update, più clear e move per tasks. Nessun metodo watch né canali push. Pagina aggiornata al 2025-03-13: https://developers.google.com/workspace/tasks/reference/rest
- Quindi qualcuno deve controllare a intervalli, chiedendo le attività cambiate dopo l'ultimo controllo.
- WorkManager: un lavoro periodico si ripete al minimo ogni 15 minuti, come JobScheduler. Pagina aggiornata al 2026-10-16: https://developer.android.com/develop/background-work/background-tasks/persistent/getting-started/define-work
- Supabase: una Edge Function si lancia a intervalli con le estensioni pg_cron (pianificatore dentro Postgres) e pg_net (chiamata HTTP). L'esempio della pagina gira ogni minuto; il minimo non è indicato. Pagina senza data: https://supabase.com/docs/guides/functions/schedule-functions
- Limite d'uso dell'API di Google Tasks: 50.000 richieste al giorno per progetto, alzabile chiedendolo dalla console di Google Cloud. Un controllo al minuto per utente fa 1.440 richieste al giorno, quindi il limite basta per circa 34 utenti. Pagina aggiornata al 2026-09-03: https://developers.google.com/workspace/tasks/limits
