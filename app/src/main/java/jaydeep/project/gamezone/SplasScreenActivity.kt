package jaydeep.project.gamezone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplasScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splas_screen)

        Handler().postDelayed({
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        },5000)

    }
}