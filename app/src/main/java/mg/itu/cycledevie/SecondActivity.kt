package mg.itu.cycledevie

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/** Second écran : mêmes callbacks, étiquette CYCLE-2 — pour observer l'entrelacement. */
class SecondActivity : AppCompatActivity() {

    private val tag = "CYCLE-2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(tag, "onCreate")
        setContentView(R.layout.activity_second)
    }

    override fun onStart() { super.onStart(); Log.i(tag, "onStart") }
    override fun onResume() { super.onResume(); Log.i(tag, "onResume") }
    override fun onPause() { Log.i(tag, "onPause"); super.onPause() }
    override fun onStop() { Log.i(tag, "onStop"); super.onStop() }
    override fun onDestroy() { Log.i(tag, "onDestroy"); super.onDestroy() }
}
