# Parallelismi fra Kotlin, Android Studio e il mondo C#

Serve a tenere allineate le spiegazioni: chi spiega riusa i parallelismi di questo file e aggiunge qui quelli nuovi. Aggiornato il 2026-10-19.

«Non contestato» vuol dire che l'utente ha letto il parallelo e non ha obiettato, non che l'argomento sia stato approfondito.

## Come vuole le spiegazioni l'utente

Indicazioni e correzioni date dall'utente:

- I parallelismi si fanno con Visual Studio e con C#, che l'utente conosce. Conosce anche VB6, SQL Server e un po' di .NET MAUI.
- Un nome del mondo .NET non basta se l'utente non lo ha mai approfondito. È successo con MSBuild e con Roslyn: vanno detti con ciò che fanno. MSBuild è «ciò che lavora quando premi Compila in Visual Studio». Roslyn è «il compilatore di C#».
- Un paragone con Visual Studio va detto come paragone: «in Visual Studio sarebbe». Alla frase «come un progetto dentro una solution di Visual Studio» l'utente ha risposto che qui usa Android Studio e non Visual Studio.
- La parola «modulo» per l'utente vuol dire una funzionalità comune riusabile, cioè una libreria nostra. In Gradle vuol dire un progetto dentro la solution, e l'utente lo aveva scambiato per un pacchetto NuGet. Quando si parla del modulo di Gradle va detto per esteso.
- Una frase con troppi nomi nuovi non passa. La frase «ART crea la classe MainActivity e chiama il suo metodo onCreate» non è stata capita. È servito partire da ciò che l'utente conosce: il `Main` di C# e il `Form_Load` di VB6.
- I percorsi dei file vanno detti come l'utente li vede. Nella vista «Android» di Android Studio la cartella `src` non compare, e l'utente non la trovava; per un periodo ha usato la vista «Project», che mostra le cartelle del disco. Dal 2026-10-19 preferisce la vista «Android», che per chi comincia si capisce meglio: i percorsi si dicono come lì, per esempio `mobile/kotlin+java/com.gabrielecusato.dietngo/ui.theme`.
- Le cose scritte nel file `IdeaIniziale.md` non si danno per note: quel file l'ha scritto Claude. Alla frase «la tabella delle registrazioni» l'utente ha risposto che non esiste nessuna tabella.
- I colori si nominano con i loro file. «Il tema Compose», da solo, all'utente non dice niente: si dice «il file `Theme.kt`», che sceglie i colori chiari o scuri, e «il file `Color.kt`», che li contiene. Il tema XML è quello che Android usa all'avvio.
- Le spiegazioni arrivano in pillole, su ciò che si sta facendo in quel momento, e molto brevi.

## Linguaggio: parallelismi usati e non contestati

Le righe vengono dal file `mobile/src/main/java/com/gabrielecusato/dietngo/MainActivity.kt`.

| Kotlin | In C# | Cosa cambia |
|---|---|---|
| `package com.gabrielecusato.dietngo` | `namespace` | il pacchetto ricalca le cartelle |
| `import android.os.Bundle` | `using` | si importa la singola classe |
| `class MainActivity : ComponentActivity()` | `class MainActivity : ComponentActivity` | le parentesi chiamano il costruttore della classe base |
| `override fun onCreate(savedInstanceState: Bundle?)` | `override void OnCreate(Bundle? savedInstanceState)` | `fun` apre ogni funzione, il tipo sta dopo il nome, `?` vuol dire «può essere null» |
| una funzione scritta fuori dalla classe | un metodo statico | in Kotlin una funzione può stare da sola nel file |
| `"Hello $name!"` | `$"Hello {name}!"` | senza graffe |
| `setContent { ... }` | `SetContent(() => { ... });` | la lambda passata per ultima sta fra graffe, fuori dalle parentesi |
| `@Composable` | un attributo fra parentesi quadre | segna una funzione che disegna un pezzo di interfaccia |
| `Meal("riso")` | `new Meal("riso")` | non c'è `new`, e non ci sono i punti e virgola |
| Kotlin rispetto a Java | VB.NET rispetto a C# | due linguaggi diversi, stesso codice intermedio, stesso runtime, stesse librerie |

## Interfaccia: parallelismi usati

Dati il 2026-10-19 per il punto 1 della home, con le domande dell'utente.

| Kotlin e Compose | In MAUI | Cosa cambia |
|---|---|---|
| funzione `@Composable` | pagina o controllo scritto in XAML | l'interfaccia si scrive in Kotlin; la funzione si chiama solo da un'altra `@Composable`, e Compose la ridisegna quando cambiano i dati che legge |
| cartella `ui.theme`, con `Color.kt`, `Type.kt`, `Theme.kt` | le risorse di stile in `App.xaml` | i colori si leggono con `MaterialTheme.colorScheme` |
| `isSystemInDarkTheme()` | `AppThemeBinding` | |
| `Modifier` | gli attributi comuni dei tag XAML: dimensione, `Margin`, `BackgroundColor` | l'ordine conta; le proprietà proprie di un controllo, come il testo, sono parametri della funzione |
| `@Preview` | l'anteprima XAML di Visual Studio | |
| `res/values/colors.xml` | nessun parallelo dato | risorse XML lette dal tema XML, separate dai colori di `Color.kt` |

## Strumenti e compilazione: parallelismi usati e non contestati

| Android | Mondo .NET | Nota |
|---|---|---|
| Android Studio | Visual Studio | l'editor intorno allo strumento che compila |
| Gradle | MSBuild, cioè ciò che lavora quando premi Compila | legge i file `build.gradle.kts` |
| modulo di Gradle | progetto `.csproj` dentro la solution | oggi `app` per l'orologio e `mobile` per il telefono |
| librerie del blocco `dependencies` | pacchetti NuGet | |
| Maven Central e l'archivio di Google | nuget.org | l'ordine sta nel file `settings.gradle.kts` |
| Sync, con il pulsante «Sync Project with Gradle Files» | restore dei pacchetti NuGet | parallelo proposto dall'utente |
| bytecode, nei file `.class` e poi nel formato DEX | IL, dentro i file `.dll` e `.exe` | |
| compilatore di Kotlin | Roslyn, cioè il compilatore di C# | |
| Gradle con il plugin Android, che produce l'APK | MSBuild, che impacchetta | il plugin è la riga `alias(libs.plugins.android.application)` |
| ART | runtime di .NET | esegue il bytecode sul dispositivo |
| WorkManager | pacchetto NuGet di job ricorrenti, come Hangfire | libreria aggiunta da noi; quando gira lo decide Android |
| pg_cron di Supabase | job di SQL Server Agent | lancia a orario un comando dentro il database |
| Edge Function di Supabase | Azure Function con trigger HTTP | codice nostro che gira sui server di Supabase |
| garbage collector | garbage collector | |
| pannello «Build Variants», con `debug` e `release` | menu Debug e Release nella barra di Visual Studio | la `release` va firmata con una chiave propria |
| versione di Gradle | versione di .NET con cui si compila | si cambia quando serve, non a ogni uscita |
| Gradle Daemon | nessun parallelo dato | il processo di Gradle che resta acceso fra una compilazione e l'altra |

## File del progetto: parallelismi usati e non contestati

I file `Directory.Build.props`, `Directory.Packages.props` e `global.json` l'utente non li ha contestati, ma potrebbe non conoscerli: se ritornano, vanno detti con ciò che fanno.

| File o cartella | In .NET |
|---|---|
| `settings.gradle.kts`, l'elenco dei moduli | il file `.sln` |
| `build.gradle.kts` nella radice, le impostazioni comuni | `Directory.Build.props` |
| `gradle/libs.versions.toml`, il catalogo di librerie e versioni | `Directory.Packages.props` |
| `gradlew`, `gradlew.bat`, `gradle/wrapper/`, che avviano la versione giusta di Gradle | `global.json` |
| `local.properties`, i percorsi di questo PC | i file `.user` |
| `.idea/`, `.gradle/` | `.vs` |
| `build/` | `bin` e `obj` |
| `build.gradle.kts` del modulo | il file `.csproj` |
| `AndroidManifest.xml`, che dichiara schermate, permessi, nome e icona | il file con lo stesso nome in MAUI |
| `MainActivity.kt`, la schermata che parte per prima | `MainActivity.cs` in MAUI |
| `ui/theme/` | gli stili |
| `src/main/res/`, con i testi in `values/strings.xml` | la cartella Resources e i file `.resx` |
| `src/test/` | un progetto di test |

## La vista «Android» e le cartelle del disco

| Nella vista «Android» | Sul disco |
|---|---|
| `manifests` | `src/main/AndroidManifest.xml` |
| `kotlin+java` | `src/main/java`, più le cartelle dei test |
| `res` | `src/main/res` |
| `Gradle Scripts` | tutti i file di Gradle, raccolti insieme |

## Ricordi dell'utente corretti

- Il codice intermedio di C# si chiama IL e sta nei file `.dll` e `.exe`. I file `.o` sono del C e del C++.
- Kotlin non deriva da Java: gli sta accanto, come VB.NET sta accanto a C#.
- Un modulo di Gradle non è un pacchetto NuGet: è un progetto dentro la solution.

## Rispiegati, senza conferma dell'utente

- In Android non si scrive un `Main`: è Android che decide quando far partire una schermata. Legge nel manifest qual è la prima, crea la classe `MainActivity` e chiama il suo metodo `onCreate`. Il metodo `onCreate` è il `Form_Load` di VB6.
