# Piano: la home del telefono

Modalità: a moduli. Stato: in costruzione.

## Obiettivo
La home del telefono costruita un pezzo alla volta. Prima l'app vuota con lo sfondo deciso, poi le fondamenta una alla volta, poi i componenti grafici, ciascuno con la sua animazione. Per ora niente database: i dati passano da un punto solo, così il database si aggiunge dopo senza toccare il resto. La descrizione della home sta in `Docs/Progetto/Home.md`.

I punti si aggiungono uno alla volta, quando l'utente approva quello prima.

## Via standard
- Versioni delle librerie: le pagine delle release di AndroidX e di Kotlin, riassunte in `Docs/Info/Gradle/VersioniLibrerie.md` (verificate il 2026-10-19).
- Kotlin più recente con il plugin Android 9: la riga `classpath` nel blocco `buildscript` del file della radice, dalle note di rilascio di AGP 9.0, https://developer.android.com/build/releases/agp-9-0-0-release-notes.
- Sfondo all'avvio: il `windowBackground` del tema XML, che dal sistema Android 12 fa anche da sfondo alla schermata d'avvio, https://developer.android.com/develop/ui/views/launch/splash-screen. Il tema scuro sta nella cartella `res/values-night`.
- Barra di stato: `enableEdgeToEdge()`, già presente in `MainActivity`, fa disegnare l'app sotto la barra e sceglie da solo le icone chiare o scure secondo il tema del sistema.

## NB
- I due colori di sfondo stanno in due copie, in `colors.xml` per il tema XML e in `Color.kt` per Compose, ognuna con un commento che rimanda all'altra. È un'eccezione a P2 scelta dall'utente: il tema XML legge solo `colors.xml`, e la palette di Compose sta in Kotlin.
- `core-ktx` dalla versione 1.19 è un pacchetto vuoto di compatibilità, perché le sue funzioni sono passate in `androidx.core:core`. Per ora resta, aggiornato alla 1.19.1.
- Il plugin Kotlin per Gradle si legge dal catalogo anche nel blocco `buildscript` (a memoria, da verificare online). Se Gradle non lo accetta, la versione si scrive per esteso nel blocco, con un commento che rimanda al campo `kotlin` del catalogo, e lo si riporta all'utente.

## Passi

### 1. L'app parte e mostra la home vuota con lo sfondo deciso [eseguito]
Perché: è la base visibile su cui si aggiungono le fondamenta e i componenti.
Regole: P1 e P2 in `Docs/Guidelines/Generali/Propedeutici/Propedeutici.md`.

Già fatto a mano dall'utente, il 2026-10-19:
- tolte da `mobile/.../MainActivity.kt` le funzioni `Greeting` e `GreetingPreview`;
- tolti da `mobile/.../ui/theme/Color.kt` i colori `Purple80`, `PurpleGrey80`, `Pink80`, `Purple40`, `PurpleGrey40`, `Pink40`;
- svuotato `mobile/src/main/res/values/colors.xml`;
- cancellati `ExampleUnitTest.kt` ed `ExampleInstrumentedTest.kt`;
- creati, vuoti, `mobile/src/main/java/com/gabrielecusato/dietngo/ui/home/HomeScreen.kt` (solo la riga `package`) e `mobile/src/main/res/values-night/themes.xml`.

Da scrivere nella fase di codice:
- `gradle/libs.versions.toml`: `composeBom` 2026.09.00, `activityCompose` 1.13.0, `coreKtx` 1.19.1, `lifecycleRuntimeKtx` 2.11.0, `junitVersion` 1.3.0, `espressoCore` 3.7.0, `kotlin` 2.4.21. Nuova voce in `[libraries]`: `kotlin-gradle-plugin = { group = "org.jetbrains.kotlin", name = "kotlin-gradle-plugin", version.ref = "kotlin" }`. Le altre versioni restano come sono: `agp` è già la più recente, quelle delle librerie Wear sono del progetto dello smartwatch e non sono state verificate.
- `build.gradle.kts` della radice: in cima, prima del blocco `plugins`, il blocco `buildscript { dependencies { classpath(libs.kotlin.gradle.plugin) } }`, con un commento: senza, il plugin Android 9 usa il Kotlin 2.2.10 che porta con sé.
- `mobile/src/main/res/values/colors.xml`: `background_light` #FFFCFCFB e `background_dark` #FF151515, con il commento «stessi colori di BackgroundLight e BackgroundDark in ui/theme/Color.kt: si cambiano insieme».
- `mobile/src/main/res/values/themes.xml`: lo stile `Theme.DietNGo` resta con il genitore `android:Theme.Material.Light.NoActionBar` e riceve `<item name="android:windowBackground">@color/background_light</item>`.
- `mobile/src/main/res/values-night/themes.xml`: lo stesso stile `Theme.DietNGo`, con il genitore `android:Theme.Material.NoActionBar` e `android:windowBackground` uguale a `@color/background_dark`. Un commento dice che è il tema mostrato all'avvio nel tema scuro, per evitare il lampo bianco.
- `ui/theme/Color.kt`: `val BackgroundLight = Color(0xFFFCFCFB)` e `val BackgroundDark = Color(0xFF151515)`, con il commento che rimanda a `colors.xml`.
- `ui/theme/Theme.kt`: il file resta quello del modello di Android Studio, con tre modifiche.
  - Nella funzione `DietNGoTheme` il valore predefinito del parametro `dynamicColor` passa da `true` a `false`. Il commento sopra, «Dynamic color is available on Android 12+», diventa: la palette è dell'app; con `true`, dal sistema Android 12, i colori verrebbero dallo sfondo del telefono.
  - Nella `val` `DarkColorScheme` le righe `primary`, `secondary` e `tertiary`, che usano i colori viola tolti da `Color.kt`, diventano `background = BackgroundDark`.
  - Nella `val` `LightColorScheme` le stesse tre righe diventano `background = BackgroundLight`. Il blocco commentato «Other default colors to override» resta: ricorda gli altri colori, che entrano con i componenti che li usano.
- `ui/home/HomeScreen.kt`: la funzione `HomeScreen`, un `Box` con `Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)` e un commento che la dice pagina iniziale, per ora vuota. Due anteprime, «Chiaro» e «Scuro», la seconda con `uiMode = Configuration.UI_MODE_NIGHT_YES`, in una funzione privata `HomeScreenPreview` che avvolge `HomeScreen` in `DietNGoTheme`.
- `MainActivity.kt`: `setContent { DietNGoTheme { HomeScreen() } }` al posto dello `Scaffold`, con `enableEdgeToEdge()` che resta dov'è. Si tolgono gli import non più usati.
- Compilazione dei due moduli: `gradlew.bat :mobile:assembleDebug :app:assembleDebug`. I warning nuovi si riportano all'utente, senza sopprimerli.

Provato dall'utente il 2026-10-21 sull'emulatore del telefono: l'app parte e funziona. Sul telefono vero non è ancora stato provato.

FERMATA: chiedi conferma prima del passo 2.

### 2. La struttura del codice: interfaccia, logica, dati e pilota [da spiegare]

## Parti visibili
- La home vuota con lo sfondo #FCFCFB nel tema chiaro e #151515 nel tema scuro.
- La barra di stato prende lo sfondo dell'app, con le icone scure nel tema chiaro e chiare nel tema scuro.

## Da non fare
- Non toccare i file del modulo `app`, il progetto dello smartwatch: cambiano solo le versioni del catalogo che condivide.
- Non colorare la barra di stato e non togliere `enableEdgeToEdge()`: la barra segue il tema da sola.
- Non aggiungere la libreria `core-splashscreen`: lo sfondo all'avvio viene dal `windowBackground`.
- In `Theme.kt` non togliere il blocco `when`, il ramo dei colori dinamici e i loro `import`: restano per poter riprovare i colori del sistema rimettendo `dynamicColor` a `true`.

## Cosa provare
- Telefono in tema chiaro: all'avvio e nella home lo sfondo è #FCFCFB, le icone della barra di stato sono scure.
- Telefono in tema scuro: lo sfondo è #151515 fin dall'avvio, senza lampo bianco, e le icone della barra di stato sono chiare.
- Cambiando il tema del telefono con l'app aperta, lo sfondo cambia.
- In Android Studio le anteprime «Chiaro» e «Scuro» di `HomeScreen` mostrano i due sfondi.
- Il progetto dello smartwatch compila e parte come prima.
