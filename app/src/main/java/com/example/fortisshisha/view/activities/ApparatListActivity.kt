package com.example.fortisshisha.view.activities

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fortisshisha.R
import com.example.fortisshisha.models.Apparat
import com.example.fortisshisha.models.MainMenuCategory
import com.example.fortisshisha.view.adapters.HookahListAdapter
import com.example.fortisshisha.view.adapters.MainMenuListAdapter
import com.example.fortisshisha.view.adapters.RecyclerViewItemClick
import com.example.fortisshisha.view_model.ApparatViewModel
import com.example.fortisshisha.view_model.MainMenuViewModel
import com.example.fortisshisha.view_model.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_apparat_list.*

class ApparatListActivity : AppCompatActivity(), RecyclerViewItemClick {
    private lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var apparatViewModel: ApparatViewModel
    private lateinit var apparatListAdapter: HookahListAdapter
    private lateinit var apparatList: List<Apparat>

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apparat_list)

        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        viewModelFactory = ViewModelProviderFactory(this)
        apparatViewModel = ViewModelProvider(this, viewModelFactory).get(ApparatViewModel::class.java)
        apparatList = apparatViewModel.generateApparatList()

        apparatListAdapter = HookahListAdapter(itemClickListener = this)

        val gridLayoutManager = GridLayoutManager(this, 2)
        apparatListRecyclerView.layoutManager = gridLayoutManager
        apparatListRecyclerView.adapter = apparatListAdapter


        apparatListAdapter.apparatList = apparatList

    }

    override fun itemClick(position: Int, item: Any?) {

    }
}