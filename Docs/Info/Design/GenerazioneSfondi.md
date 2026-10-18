# Generare le scene di sfondo e le notifiche con pulsanti

Verificato il 2026-10-18. Le fonti sono in gran parte di terze parti, non documentazione ufficiale.

## Notifiche con pulsanti

- Android: una notifica ha fino a tre pulsanti di azione, che non devono ripetere l'azione del tocco sulla notifica. Pagina aggiornata al 2026-10-16: https://developer.android.com/develop/ui/views/notifications/build-notification

## Generare immagini nello stesso stile

- Nano Banana 2 (Gemini 3.1 Flash Image) accetta fino a 14 immagini di riferimento e mantiene lo stile in una serie. Fonti: https://docs.krea.ai/user-guide/features/nano-banana-2 , https://community.adobe.com/announcements-402/gemini-3-1-w-nano-banana-2-now-available-in-firefly-1551685 . Una versione 2.1 è riportata da https://letsdatascience.com/news/google-rolls-out-nano-banana-21-image-model-c6ac3b89 , senza conferma ufficiale.
- Recraft V4 Styles richiede almeno un'immagine di riferimento dello stile e ne riproduce tecnica, colori e composizione: https://openrouter.ai/recraft/recraft-v4-styles/api
- Guida generale sulla coerenza di stile: https://getimg.ai/blog/how-to-generate-images-in-consistent-brand-style-with-ai

## Dividere un'immagine in strati

- Luma Agents, modalità layering: fino a 10 strati trasparenti ordinati dal davanti al fondo, l'ultimo opaco: https://docs.agents.lumalabs.ai/guides/images/layering/
- Image to Layers: carica PNG, JPG o WebP, sceglie il numero di strati, esporta anche in PSD: https://creati.ai/ai-tools/imagetolayers/

## Immagini già fatte

- Adobe Stock, licenza standard: secondo un esperto del forum, non Adobe, va bene in un'app se l'immagine non è il motivo per cui si compra il prodotto. Da confermare sui termini ufficiali: https://community.adobe.com/questions-32/about-the-license-of-4-images-for-the-commercial-use-of-an-app-i-m-developing-1495546
- Su Freepik non è stato trovato niente: vanno letti i suoi termini.

## Licenze di materiale già pronto (verificato il 2026-10-18)

- Pexels: foto e video gratuiti, anche nelle app, modificabili, citazione facoltativa. Vietato: mostrare persone riconoscibili in cattiva luce, far credere che persone o marchi approvino il prodotto, rivendere copie non modificate, usarli in un marchio. Pagina senza data: https://www.pexels.com/license/
- LottieFiles, animazioni gratuite: Lottie Simple License (FL 9.13.21). Uso commerciale ammesso, modifiche ammesse con la stessa licenza, citazione facoltativa: https://lottiefiles.com/page/license
