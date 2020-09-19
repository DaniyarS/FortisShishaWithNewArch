package com.example.fortisshisha.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.fortisshisha.R
import com.example.fortisshisha.models.Apparat
import com.example.fortisshisha.view.activities.ApparatDetailsActivity
import com.example.fortisshisha.view.adapters.HookahListAdapter
import com.example.fortisshisha.view.adapters.MoreButtonClick
import com.example.fortisshisha.view_model.ApparatViewModel
import com.example.fortisshisha.view_model.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_apparat_list.*

class ApparatListFragment : Fragment(R.layout.fragment_apparat_list), MoreButtonClick {

    private lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var apparatViewModel: ApparatViewModel
    private lateinit var apparatListAdapter: HookahListAdapter
    private lateinit var apparatList: List<Apparat>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelFactory = ViewModelProviderFactory(context = this.activity as Context)
        apparatViewModel = ViewModelProvider(this, viewModelFactory).get(ApparatViewModel::class.java)
        apparatList = apparatViewModel.generateApparatList()

        apparatListAdapter = HookahListAdapter(moreButtonClick = this)
        apparatListAdapter.setContext(this.activity as Context)

        val gridLayoutManager = GridLayoutManager(this.activity as Context, 2)
        apparatListRecyclerView.layoutManager = gridLayoutManager
        apparatListRecyclerView.adapter = apparatListAdapter
        apparatListAdapter.apparatList = apparatList
    }

    override fun moreItemClick(position: Int, item: Any?) {
        val intent = Intent(this.activity as Context, ApparatDetailsActivity::class.java)
        intent.putExtra( "apparat", item as Apparat)
        startActivity(intent)
    }

}