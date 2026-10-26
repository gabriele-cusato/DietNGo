# Effetto gooey (metaball)

Verificato il 2026-10-26. Provato sul bollino della pillola del diario e bocciato dall'utente lo stesso giorno: resta qui come informazione.

## Cos'è
Due forme vicine si fondono in una sola, con un collo liquido fra le due, come una goccia che entra nell'acqua. In inglese si chiama «gooey effect»; il nome tecnico è «metaball». La ricetta è sempre la stessa: si sfocano le forme insieme, poi si taglia la sfocatura a una soglia di trasparenza, così dove le sfocature si toccano nasce il collo.

## Sul web
Filtro SVG: `feGaussianBlur` per la sfocatura, poi `feColorMatrix` per la soglia sulla trasparenza. Il contenuto (icone, testo) sta fuori dal filtro, sopra, altrimenti si sfoca anche lui.

## Su Android, con Compose
- Sfocatura con `RenderEffect` da Android 12 (API 31).
- Soglia: con una matrice di colore da API 31; con uno shader AGSL, il linguaggio degli shader di Android, da Android 13 (API 33), che filtra meglio la trasparenza.
- Sotto API 31 serve un'alternativa: da decidere quando si scrive il diario.

## Su iPhone
SwiftUI applica sfocatura e soglia nel componente Canvas, anche con gli effetti Metal (a memoria, da verificare online sulla documentazione Apple).

## Pagine lette
- https://21st.dev/@rigayaya/components/gooey-cta-button.md (pillola e cerchio che si fondono con un filtro SVG)
- https://freefrontend.com/css-gooey/
- https://proandroiddev.com/jetpack-compose-metaball-edge-effect-final-part-ac8a4cc7a425 (metaball in Compose: sfocatura e soglia, API 31 e 33)
- https://canopas.com/how-to-use-render-effects-in-jetpack-compose-for-stunning-visuals-01287d7f00db (RenderEffect in Compose, API 31)
- https://ikyle.me/blog/2026/creating-cool-ui-shape-morphing-directly-with-metal (lo stesso trucco su iOS)
