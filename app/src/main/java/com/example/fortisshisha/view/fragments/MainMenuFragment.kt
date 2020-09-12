package com.example.fortisshisha.view.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fortisshisha.R
import com.example.fortisshisha.models.MainMenuCategory
import com.example.fortisshisha.view.activities.*
import com.example.fortisshisha.view.adapters.MainMenuListAdapter
import com.example.fortisshisha.view_model.MainMenuViewModel
import com.example.fortisshisha.view_model.ViewModelProviderFactory
import kotlinx.android.synthetic.main.fragment_main_menu.*

class MainMenuFragment : Fragment(R.layout.fragment_main_menu), MainMenuListAdapter.RecyclerViewItemClick {
    private lateinit var viewModelFactory: ViewModelProviderFactory
    private lateinit var mainMenuViewModel: MainMenuViewModel
    private lateinit var mainMenuListAdapter: MainMenuListAdapter
    private lateinit var menuList: List<MainMenuCategory>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainMenuRecyclerView.layoutManager = LinearLayoutManager(this.activity as Context)
        mainMenuListAdapter = MainMenuListAdapter(itemClickListener = this)
        mainMenuRecyclerView.adapter = mainMenuListAdapter

        viewModelFactory = ViewModelProviderFactory(context = this.activity as Context)
        mainMenuViewModel = ViewModelProvider(this, viewModelFactory).get(MainMenuViewModel::class.java)
        menuList =  mainMenuViewModel.getMenuList()
        mainMenuListAdapter.categoryList = menuList
        mainMenuListAdapter.notifyDataSetChanged()
    }

    override fun itemClick(position: Int, item: MainMenuCategory?) {
        val intent: Intent
        when(item?.categoryId) {
            1 -> {
                intent = Intent(this.activity, ApparatListActivity::class.java)
                startActivity(intent)
            }
            2 -> {
                intent = Intent(this.activity, HookahListActivity::class.java)
                startActivity(intent)
            }
            3 -> {
                intent = Intent(this.activity, CoalListActivity::class.java)
                startActivity(intent)
            }
            4 -> {
                intent = Intent(this.activity, HookahOrderActivity::class.java)
                startActivity(intent)
            }
        }
    }
}