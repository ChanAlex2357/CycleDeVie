package mg.itu.cycledevie

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Mini-TP 3 — « Observer le cycle de vie »
 *
 * Cette Activity journalise TOUS ses callbacks avec l'étiquette CYCLE.
 * Dans le Logcat d'Android Studio, filtrez sur :  tag:CYCLE
 *
 * Scénarios à jouer (APRÈS avoir soumis vos prédictions sur Moodle) :
 *   1. Tourner l'écran (rotation)          -> notez la séquence observée
 *   2. Bouton accueil, puis revenir        -> notez la séquence observée
 *   3. (bonus) Ouvrir le second écran      -> observez l'ENTRELACEMENT
 *      des callbacks des deux Activities (étiquettes CYCLE et CYCLE-2)
 *
 * Tâche de modification : compléter partagerCollecte() — voir le TODO.
 */
class MainActivity : AppCompatActivity() {

    private val tag = "CYCLE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(tag, "onCreate — l'écran se construit (instance ${hashCode()})")
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSecond).setOnClickListener {
            // Intent EXPLICITE : on nomme la classe visée.
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<Button>(R.id.btnPartager).setOnClickListener {
            partagerCollecte()
        }
    }

    private fun partagerCollecte() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, "Collecte du jour : 4,5 kg de vanille")

        val chooser = Intent.createChooser(intent,"Partager")
        startActivity(chooser)
    }

    override fun onStart() {
        super.onStart()
        Log.i(tag, "onStart — l'écran devient visible")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tag, "onResume — premier plan, interactif")
    }

    override fun onPause() {
        Log.i(tag, "onPause — perd le premier plan")
        super.onPause()
    }

    override fun onStop() {
        Log.i(tag, "onStop — plus visible")
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tag, "onRestart — l'écran stoppé va redevenir visible")
    }

    override fun onDestroy() {
        Log.i(tag, "onDestroy — instance détruite (instance ${hashCode()})")
        super.onDestroy()
    }
}
