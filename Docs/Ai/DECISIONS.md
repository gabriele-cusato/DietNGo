# Decisioni

Scelte che valgono oltre la singola tappa: una riga per scelta, con la data.

- 2026-10-11 | Nome dell'app: DietNGo, definitivo. MealLog era il nome provvisorio e non si usa più.
- 2026-10-11 | Le parti del lavoro si chiamano «Tappe», non «Fasi».
- 2026-10-11 | Moduli: `app` è l'app dell'orologio, `mobile` è l'app del telefono. Nel file `IdeaIniziale.md` i nomi sono altri: `:wear` è l'orologio, `:app` è il telefono.
- 2026-10-11 | Nome del pacchetto: `com.gabrielecusato.dietngo`, uguale nei due moduli, al posto di `com.example.dietngo`.
- 2026-10-11 | Codice comune alle due app: il meno codice duplicato possibile, quando opportuno. Il codice nostro comune va in un modulo `shared`, che nasce quando arriva il primo codice comune e non prima. Le librerie esterne comuni si dichiarano una volta sola nel file `gradle/libs.versions.toml`.
- 2026-10-11 | Librerie nostre: una funzionalità che può servire anche ad app future si tiene separata dal codice specifico di DietNGo, in un modulo libreria suo. Si propone all'utente caso per caso.
- 2026-10-11 | Database locale: SQLite sul telefono.
- 2026-10-11 | Database remoto: confermato, su Supabase. Il database locale ne è lo specchio. Il remoto deve essere sostituibile con un server proprio, anche di tecnologia diversa, per esempio da Postgres a SQL Server.
- 2026-10-11 | Niente backend né server propri per ora. Unica eccezione: Supabase.
- 2026-10-11 | Account: accesso con Google, con Apple o con un account proprio nel database remoto. La frase «niente account propri» del file `IdeaIniziale.md` era un errore di chi ha scritto il file ed è stata corretta.
- 2026-10-11 | Più utenti: ogni utente ha i suoi dati. Le tabelle sono collegate alla tabella degli utenti.
- 2026-10-11 | Canale vocale: resta Google Tasks, che l'utente ha provato con Gemini. AppFunctions è ancora in anteprima privata: verificato il 2026-10-11 sulla pagina https://developer.android.com/ai/appfunctions, aggiornata al 2026-09-22.
- 2026-10-11 | L'elenco delle registrazioni dei pasti nel modello dati si chiama `MealEntry`, non più `MealLog`, per non confonderlo con il vecchio nome dell'app. Confermato dall'utente.
- 2026-10-11 | Piani: uno per tappa, nella cartella `Docs/Ai/Plans`.
- 2026-10-11 | Modalità: a moduli. Si cambia se non si rivela quella giusta.
- 2026-10-11 | Version control: git. La repo l'ha creata l'utente il 2026-10-11, e i commit li fa lui.
- 2026-10-11 | Dispositivi di prova: telefono vero collegato via cavo, orologio emulato.
