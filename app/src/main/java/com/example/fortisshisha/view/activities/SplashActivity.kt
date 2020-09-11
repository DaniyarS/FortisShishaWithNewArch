package com.example.fortisshisha.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fortisshisha.R
import com.example.fortisshisha.models.SharedPreferences
import kotlinx.android.synthetic.main.activity_spalsh.*

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)

        sharedPreferences = SharedPreferences(this)

        ivCompanyLogo.alpha = 0f
        ivCompanyLogo.animate().setDuration(3000).alpha(1f).withEndAction {
            val intent: Intent = if (sharedPreferences.getLoginCount() == true) {
                Intent(this, MainActivity::class.java)
            } else {
                Intent(this, EnterActivity::class.java)
            }
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}