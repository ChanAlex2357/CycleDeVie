ITUniversity — Module M1 · Développement mobile Kotlin — Séance 3

**MINI-TP 3 — ANATOMIE ANDROID**

« Observer le cycle de vie »

*Cycle de vie, Intents, Logcat — travail individuel, sur l’application fournie « CycleDeVie »*

# 1. Objectifs

* Prédire la séquence exacte des callbacks du cycle de vie pour deux scénarios, puis la vérifier au Logcat.
* Observer qu'à la rotation, l'Activity est détruite puis recréée — et noter ce que cela détruit.
* Compléter un Intent implicite de partage.
* Juger le diagnostic d'une stack trace proposé par l'IA.

# 2. Règles du mini-TP

1. Les prédictions se remplissent dans le modèle de l'étape 1 AVANT tout lancement de l'application : lire, prédire, puis seulement exécuter — c'est l'ordre des étapes qui fait tout l'intérêt du mini-TP.
2. Pendant les étapes 1 à 3, aucune assistance IA — complétion IA de l’IDE désactivée.
3. Émulateur lent ? Les appareils physiques de prêt sont là — demandez.

**ÉTAPE 1 — LIRE ET PRÉDIRE (SUR PAPIER, AVANT TOUT LANCEMENT)**

Téléchargez MiniTP3\_CycleDeVie.zip depuis le dossier Drive de la séance, décompressez-le, ouvrez le projet dans Android Studio (File → Open) et LISEZ MainActivity.kt — sans lancer l'application. Puis, pour chacun des deux scénarios, remplissez le modèle ci-dessous avec la séquence exacte et complète des callbacks (parmi : onCreate, onStart, onResume, onPause, onStop, onRestart, onDestroy) :

* scénario A : vous tournez l’écran (rotation portrait → paysage) ;
* scénario B : vous appuyez sur le bouton accueil, puis vous revenez à l’application.

| **Scénario** | **Séquence EXACTE prédite (dans l’ordre)** | **Réponse à la question « + » (une phrase)** |
| --- | --- | --- |
| **Scénario A — Rotation de l’écran + que devient un compteur stocké dans l’Activity ?** |  |  |
| **Scénario B — Accueil, puis retour + quelle différence essentielle avec la rotation ?** |  |  |

Ne lancez rien avant d'avoir rempli les deux lignes du modèle.

**ÉTAPE 2 — OBSERVER AU LOGCAT**

1. Lancez maintenant l'application sur émulateur ou appareil (laissez Gradle finir sa synchronisation à la première ouverture).
2. Dans le Logcat, filtrez avec : tag:CYCLE
3. Jouez les deux scénarios et remplissez le tableau :

| **Scénario** | **Séquence observée** | **Écart avec ma prédiction + explication** |
| --- | --- | --- |
| **Rotation de l’écran** |  |  |
| **Accueil, puis retour** |  |  |

**Question d’observation (à répondre en une phrase sur cette feuille) :** à la rotation, le numéro d’instance affiché par onCreate change. Qu’est-ce que cela prouve — et qu’arriverait-il à un compteur stocké dans l’Activity ?

**Bonus :** ouvrez le second écran (bouton) et observez l’entrelacement des étiquettes CYCLE et CYCLE-2 : qui se met en pause avant que qui ne se crée ?

**ÉTAPE 3 — COMPLÉTER LE PARTAGE**

Dans MainActivity, la fonction partagerCollecte() contient un TODO : complétez-la avec un Intent implicite ACTION\_SEND (type « text/plain », texte « Collecte du jour : 4,5 kg de vanille »), lancé via Intent.createChooser. Le modèle exact est sur la diapositive « Les Intents » du cours. Vérifiez que le sélecteur de partage s'ouvre.

**VOIE OUVERTE — UNE TÂCHE IA UNIQUE : JUGER UN DIAGNOSTIC**

Une variante de l'application (que vous n'avez pas) plante au démarrage avec la stack trace ci-dessous. La ligne 29 de sa MainActivity est :

findViewById<Button>(R.id.btnPartage).setOnClickListener { partagerCollecte() }

La stack trace :

java.lang.RuntimeException: Unable to start activity

ComponentInfo{mg.itu.cycledevie/mg.itu.cycledevie.MainActivity}:

java.lang.NullPointerException: findViewById(R.id.btnPartage)

must not be null

at android.app.ActivityThread.performLaunchActivity(...)

at android.app.ActivityThread.handleLaunchActivity(...)

at android.os.Handler.dispatchMessage(Handler.java:106)

at android.app.ActivityThread.main(ActivityThread.java:8177)

Caused by: java.lang.NullPointerException:

findViewById(R.id.btnPartage) must not be null

at mg.itu.cycledevie.MainActivity.onCreate(MainActivity.kt:29)

at android.app.Activity.performCreate(Activity.java:8342)

... 11 more

1. Soumettez cette stack trace (et la ligne 29) à l'IA de votre choix, en lui demandant : « Diagnostique ce crash : quelle ligne, quelle cause, quelle correction ? »
2. Puis JUGEZ son diagnostic en trois lignes : désigne-t-il la bonne ligne (celle de NOTRE paquet) ? La bonne cause ? La correction proposée est-elle la bonne ? Comparez avec le vrai layout du projet que vous avez sous les yeux (fichier activity\_main.xml) — un indice s'y trouve. Vous recopierez ce verdict dans le champ « JOURNAL-IA » du formulaire de dépôt.

# 3. Livrables (formulaire « S3 · Dépôt des livrables »)

Tout se dépose en fin de séance dans le formulaire unique « S3 · Dépôt des livrables » — le lien est affiché en séance et dans le dossier Drive de la séance :

* cette feuille remplie (modèle de prédictions, tableau d’observation, question et bonus), en photo ou PDF ;
* les captures du Logcat filtré (une par scénario), annotées ;
* le projet avec le partage fonctionnel, en lien GIT public ;
* votre verdict en trois lignes sur le diagnostic de l’IA, recopié directement dans le champ « JOURNAL-IA » du formulaire.

Ces dépôts servent au suivi de votre progression. Les modalités d'évaluation du module vous seront précisées ultérieurement.