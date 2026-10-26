# Emoji animate di Google (Noto Animated Emoji)

Verificato il 2026-10-26.

## Cosa sono
Le emoji di Google animate, nello stile delle emoji di Android. Ogni emoji si scarica in tre formati: GIF, WebP animato e Lottie, il formato JSON di animazioni vettoriali che una libreria disegna nell'app.

## Dove si scaricano
- Indirizzo dei file: `https://fonts.gstatic.com/s/e/notoemoji/latest/<codice>/<file>`, dove `<codice>` è il codice Unicode dell'emoji e `<file>` è `512.gif`, `512.webp` oppure `lottie.json`.
- Il fuoco ha codice `1f525`. Il 2026-10-26 i tre file rispondono: GIF circa 475 KB, WebP circa 190 KB, Lottie circa 29 KB.
- Catalogo: https://googlefonts.github.io/noto-emoji-animation/ (la pagina si carica con JavaScript e non si legge con un download semplice).

## Licenza
- CC BY 4.0: uso gratuito con citazione dell'autore. Lo dicono le pagine dei pacchetti che le riusano, https://pub.dev/packages/animated_emoji e https://pub-web.flutter-io.cn/packages/dart_animated_emoji, non una pagina di Google letta direttamente: da verificare sulla pagina ufficiale prima di usarle nell'app.
- Il README del repository delle emoji statiche, https://github.com/googlefonts/noto-emoji, dà OFL 1.1 per i font e Apache 2.0 per le immagini, ma non parla di quelle animate.

## Nell'app
- Il file Lottie si disegna con la libreria Lottie, su Android con la versione per Compose e su iPhone con la versione per iOS (a memoria, da verificare online). È una dipendenza in più: va chiesta all'utente prima di adottarla.

## Pagine lette
- https://designcompass.org/en/2022/10/04/noto-emiji-animation/ (formati Lottie, WebP e GIF)
- https://pub.dev/packages/animated_emoji
- https://raw.githubusercontent.com/googlefonts/noto-emoji/main/README.md
