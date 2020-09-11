package com.example.fortisshisha.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fortisshisha.R
import com.example.fortisshisha.view_model.MainMenuViewModel
import com.example.fortisshisha.view_model.ViewModelProviderFactory

class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {
    private lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var mainMenuViewModel: MainMenuViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFactory = ViewModelProviderFactory(context = this.activity as Context)
        mainMenuViewModel = ViewModelProvider(this, viewModelFactory).get(MainMenuViewModel::class.java)

        
    }
}