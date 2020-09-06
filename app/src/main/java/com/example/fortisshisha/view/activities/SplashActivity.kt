package com.example.fortisshisha.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fortisshisha.R
import kotlinx.android.synthetic.main.activity_spalsh.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        ivCompanyLogo.alpha = 0f
        ivCompanyLogo.animate().setDuration(3000).alpha(1f).withEndAction {
            val intent = Intent(this, EnterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}