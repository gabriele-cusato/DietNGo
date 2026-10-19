# Versioni stabili delle librerie del telefono

Verificato online il 2026-10-19. Le versioni cambiano nel tempo: prima di agire, ricontrollare le pagine in fondo.

| Libreria nel catalogo | Nel progetto | Stabile più recente | Note |
|---|---|---|---|
| `composeBom` | 2024.09.00 | 2026.09.00 | porta ui e foundation 1.12.1, material3 1.4.0 |
| `activityCompose` | 1.8.0 | 1.13.0 | uscita l'11 marzo 2026 |
| `coreKtx` | 1.10.1 | 1.19.1 | dalla 1.19 è un pacchetto vuoto di compatibilità: le funzioni stanno in `core` |
| `lifecycleRuntimeKtx` | 2.6.1 | 2.11.0 | uscita il 17 giugno 2026 |
| `junitVersion` (`androidx.test.ext:junit`) | 1.1.5 | 1.3.0 | |
| `espressoCore` | 3.5.1 | 3.7.0 | |
| `kotlin` | 2.2.10 | 2.4.21 | uscita l'8 ottobre 2026 |

## Kotlin con il plugin Android 9

- Il plugin Android 9 ha Kotlin integrato e dipende dal plugin Kotlin per Gradle 2.2.10: senza altro, usa quella versione.
- Per una versione più alta, le note di rilascio di AGP 9.0 dicono di aggiungere nel file `build.gradle.kts` della radice:

  ```kotlin
  buildscript {
      dependencies {
          classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:KGP_VERSION")
      }
  }
  ```
- Il plugin del compilatore di Compose, `org.jetbrains.kotlin.plugin.compose`, ha la stessa versione di Kotlin: nel catalogo usa già il campo `kotlin`.
- Le note di AGP 9.4 non dicono la versione minima di Kotlin.

## Sfondo all'avvio

- Dal sistema Android 12 la schermata d'avvio usa come sfondo il `windowBackground` del tema XML, se è un colore unico.
- Il colore del tema scuro si dà con un secondo file del tema nella cartella `res/values-night`: è la regola generale delle risorse di Android, la pagina non lo mostra.
- La libreria `core-splashscreen` serve solo per avere la stessa schermata d'avvio anche sui sistemi fino ad Android 11. Senza, lì si vede il `windowBackground` semplice.

## Pagine lette

- Elenco delle versioni del BOM di Compose: https://developer.android.com/develop/ui/compose/bom/bom-mapping e https://developer.android.com/develop/ui/compose/bom
- Activity: https://developer.android.com/jetpack/androidx/releases/activity
- Core: https://developer.android.com/jetpack/androidx/releases/core
- Lifecycle: https://developer.android.com/jetpack/androidx/releases/lifecycle
- Test: https://developer.android.com/jetpack/androidx/releases/test
- Kotlin: https://kotlinlang.org/docs/releases.html
- AGP 9.0, dipendenza da Kotlin: https://developer.android.com/build/releases/agp-9-0-0-release-notes
- AGP 9.4: https://developer.android.com/build/releases/agp-9-4-0-release-notes
- Schermata d'avvio: https://developer.android.com/develop/ui/views/launch/splash-screen
