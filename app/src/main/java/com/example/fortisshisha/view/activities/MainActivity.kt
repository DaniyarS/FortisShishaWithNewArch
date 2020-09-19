package com.example.fortisshisha.view.activities

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.fortisshisha.R
import com.example.fortisshisha.view.adapters.Converter
import com.example.fortisshisha.view.adapters.HookahListAdapter
import com.example.fortisshisha.view.adapters.ProductAddRemoveCallback
import com.example.fortisshisha.view.fragments.CheckOutFragment
import com.example.fortisshisha.view.fragments.MainMenuFragment
import com.example.fortisshisha.view.fragments.ProfileFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setFragment(MainMenuFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val basketItem = menu?.findItem(R.id.checkOutButton)
        basketItem?.icon = Converter.convertLayoutToImage(this, 2, R.drawable.ic_basket)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.profileButton -> {
                setFragment(ProfileFragment())
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//
//                }
            }
            R.id.checkOutButton -> {
                setFragment(CheckOutFragment())
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainMenu, fragment)
        fragmentTransaction.commit()
    }
}