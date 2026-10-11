# Aggiornare Gradle

Verificato online il 2026-10-11. Le versioni cambiano nel tempo: prima di agire, ricontrollare le pagine in fondo.

## Cosa usa il progetto

- Gradle 9.6.0: riga `distributionUrl` del file `gradle/wrapper/gradle-wrapper.properties`.
- Plugin Android per Gradle 9.4.1: campo `agp` del file `gradle/libs.versions.toml`. È il pezzo che insegna a Gradle a costruire un'app Android.
- Su questo PC Gradle gira con JDK 25: lo dice il messaggio di Android Studio dopo la compilazione.

## Versioni stabili di Gradle

| Versione | Data di uscita |
|---|---|
| 9.8.1 | 2026-10-07 |
| 9.8.0 | 2026-09-24 |
| 9.7.1 | 2026-08-19 |
| 9.7.0 | 2026-08-06 |

## Cosa chiede il plugin Android 9.4

| Componente | Versione minima | Versione predefinita |
|---|---|---|
| Gradle | 9.6.0 | 9.6.0 |
| SDK Build Tools | 36.0.0 | 36.0.0 |
| JDK | 17 | 17 |

Il livello massimo di API supportato è il 37. La pagina non dice se le versioni di Gradle successive alla 9.6.0 sono provate con questo plugin.

## Consiglio dato all'utente

- Non aggiornare adesso: il progetto è vuoto, la 9.6.0 è la versione con cui il plugin 9.4 viene distribuito e la 9.8.1 non gli dà niente.
- Gradle e il plugin Android si aggiornano insieme, quando Android Studio propone il plugin nuovo.
- Aggiornare dopo che il progetto è sotto git, per poter tornare indietro se la compilazione si rompe.

## Come si aggiorna

1. Nel terminale di Android Studio, dalla cartella del progetto:

   ```
   gradlew.bat :wrapper --gradle-version 9.8.1
   ```

   Al posto del numero si può scrivere `latest`, che prende l'ultima versione stabile.
2. Il comando cambia la riga `distributionUrl` del file `gradle/wrapper/gradle-wrapper.properties`.
3. Per aggiornare anche il file `gradle-wrapper.jar` e gli script `gradlew` e `gradlew.bat`, la documentazione consiglia di eseguire il comando una seconda volta.
4. In Android Studio si lancia «Sync Project with Gradle Files».

Da verificare prima di farlo: nel file `gradle/wrapper/gradle-wrapper.properties` c'è anche la riga `distributionSha256Sum`, l'impronta che verifica il download. Deve corrispondere alla versione nuova, e non è stato verificato se il comando la aggiorna da solo.

## Pagine lette

- Versioni di Gradle: https://gradle.org/releases/
- Plugin Android per Gradle 9.4, pagina aggiornata al 2026-10-08: https://developer.android.com/build/releases/gradle-plugin
- Aggiornamento del wrapper, pagina riferita a Gradle 9.8.1: https://docs.gradle.org/current/userguide/gradle_wrapper.html
