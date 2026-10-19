# Conoscenze dell'utente

Ciò che l'utente ha già capito: una riga per voce, in generale, senza nomi del progetto.

- Funzione @Composable: una funzione Kotlin che disegna un pezzo di interfaccia, al posto dello XAML; si chiama solo da un'altra @Composable e Compose la ridisegna quando cambiano i dati che legge. (2026-10-19)
- File Color.kt e Theme.kt: i colori che l'app usa nelle funzioni Compose; Color.kt li contiene, Theme.kt sceglie fra chiari e scuri e li passa alle pagine, che li leggono con MaterialTheme.colorScheme. (2026-10-19)
- isSystemInDarkTheme: la funzione di Compose che dice se il sistema è in tema scuro, come AppThemeBinding di MAUI. (2026-10-19)
- Modifier: le proprietà uguali per tutti i controlli, come in MAUI dimensione, Margin e BackgroundColor, più i tocchi; si scrivono in catena e l'ordine conta. (2026-10-19)
- @Preview: l'annotazione che disegna una funzione @Composable nell'anteprima di Android Studio senza avviare l'app. (2026-10-19)
- Tema XML e colors.xml: il tema che Android usa all'avvio, per la schermata d'avvio e prima che l'app disegni, e i colori XML che legge; sono separati da Color.kt e Theme.kt. (2026-10-19)
- Catalogo delle versioni: il file `libs.versions.toml`, unico per tutti i moduli, come Directory.Packages.props in .NET. (2026-10-19)
- Kotlin File e Kotlin Class: una funzione può stare da sola in un file, quindi per una pagina Compose si crea un Kotlin File. (2026-10-19)
