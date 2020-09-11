package com.example.fortisshisha.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import com.example.fortisshisha.R
import com.example.fortisshisha.models.SharedPreferences
import kotlinx.android.synthetic.main.activity_enter.*

class EnterActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        sharedPreferences = SharedPreferences(this)

        ageCheckBox.setOnCheckedChangeListener { _, _ ->
            if (userNameTextView.text.toString().trim().isNotEmpty()
                && phoneNumberTextView.text.toString().trim().isNotEmpty()
                && ageCheckBox.isChecked)
                {
                btEnter.isEnabled = true
                btEnter.alpha = 1f
            } else {
                btEnter.isEnabled = false
                btEnter.alpha = 0.5f
            }
        }

        btEnter.setOnClickListener {
            val phoneNumber = "${phoneNumberTextView.text}"

            sharedPreferences.let {
                it.setSetUserName(userNameTextView.text.toString())
                it.setPhoneNumber(phoneNumber)
                it.setLoginCount(true)
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}