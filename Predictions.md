# MiniTP3 Prédictions

## Étape 1

| Scénario | Séquence EXACTE prédite (dans l'ordre) | Réponse à la question « + » (une phrase) |
|---|---|---|
| Scénario A — Rotation de l'écran + que devient un compteur stocké dans l'Activity ? | onPause → onStop → onDestroy → onCreate → onStart → onResume | Il est remis à 0 (l'instance est détruite puis recréée, le champ n'est pas conservé sans `onSaveInstanceState`). |
| Scénario B — Accueil, puis retour + quelle différence essentielle avec la rotation ? | onPause → onStop → onRestart → onStart → onResume | C'est la destruction de l'instance : la rotation détruit et recrée l'Activity, alors qu'Accueil + retour ne la détruit pas (elle est juste arrêtée puis relancée). |

## Étape 2

| Scénario | Séquence observée | Écart avec ma prédiction + explication |
|---|---|---|
| Rotation de l'écran | onPause → onStop → onDestroy (instance 259414445) → onCreate (instance 69397067) → onStart → onResume | Aucun écart — correspond exactement à la prédiction. Les hashCodes différents confirment que l'instance a bien été détruite et recréée. |
| Accueil, puis retour | onPause → onStop → onRestart → onStart → onResume | Aucun écart — correspond exactement à la prédiction. Pas de onDestroy/onCreate : l'instance a survécu, seulement stoppée puis relancée. |

**Question d'observation :** À chaque rotation, une nouvelle instance de l'Activity est créée (le numéro d'instance change). Cela prouve qu'un compteur stocké en champ simple serait remis à 0 à chaque rotation, car l'ancienne instance et son état sont détruits sans être conservés (sauf sauvegarde via `onSaveInstanceState`).
