package com.example.fortisshisha.view.activities

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fortisshisha.R
import com.example.fortisshisha.models.Apparat
import com.example.fortisshisha.view.adapters.HookahListAdapter
import com.example.fortisshisha.view.adapters.MoreButtonClick
import com.example.fortisshisha.view.adapters.ProductAddRemoveCallback
import com.example.fortisshisha.view.adapters.RecyclerViewItemClick
import com.example.fortisshisha.view_model.ApparatViewModel
import com.example.fortisshisha.view_model.ViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_apparat_list.*

class ApparatListActivity : AppCompatActivity(), MoreButtonClick, ProductAddRemoveCallback {
    private lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var apparatViewModel: ApparatViewModel
    private lateinit var apparatListAdapter: HookahListAdapter
    private lateinit var apparatList: List<Apparat>
    private var cartCount = 0

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

        apparatListAdapter = HookahListAdapter(moreButtonClick = this, addRemoveListener = this)

        val gridLayoutManager = GridLayoutManager(this, 2)
        apparatListRecyclerView.layoutManager = gridLayoutManager
        apparatListRecyclerView.adapter = apparatListAdapter


        apparatListAdapter.apparatList = apparatList

    }

    override fun moreItemClick(position: Int, item: Any?) {
        val intent = Intent(this, ApparatDetailsActivity::class.java)
        intent.putExtra( "apparat", item as Apparat)
        startActivity(intent)
    }

    @SuppressLint("ResourceType")
    override fun onAddProduct() {
        cartCount++
        Log.d("count", cartCount.toString())
        invalidateOptionsMenu()
        Snackbar.make(findViewById<ConstraintLayout>(R.layout.activity_apparat_list),
            "Добавлено в корзину",
            Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()
    }

    override fun onRemoveProduct() {
        cartCount++
        invalidateOptionsMenu()
    }

}