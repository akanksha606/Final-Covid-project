package android.example.covid_19tracker

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception

class SplashScreenActivity : AppCompatActivity() {
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        handler = Handler()
        handler.postDelayed({
            val intent= Intent(baseContext,LoadingScreen::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
