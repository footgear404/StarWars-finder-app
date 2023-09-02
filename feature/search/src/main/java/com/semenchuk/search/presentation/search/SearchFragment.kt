package com.semenchuk.search.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import com.semenchuk.EntityType
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.base.BaseFragment
import com.semenchuk.search.R
import com.semenchuk.search.databinding.FragmentSearchBinding
import com.semenchuk.search.presentation.search.adapter.OnItemClickListener
import com.semenchuk.search.presentation.search.adapter.SearchItemsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    private val viewModel by viewModel<SearchViewModel>()

    private val adapter = SearchItemsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchList.adapter = adapter

        binding.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.people_btn -> viewModel.entityType = EntityType.PEOPLE
                R.id.starship_btn -> viewModel.entityType = EntityType.STARSHIPS
                R.id.planets_btn -> viewModel.entityType = EntityType.PLANETS
            }
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchPeople(entity = viewModel.entityType, name = query.toString())
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                val characterCount = query?.length ?: 0
                if (characterCount >= 2) {
                    viewModel.searchPeople(entity = viewModel.entityType, name = query.toString())
                }
                return true
            }
        })

        flowObserver(viewModel.result) { data ->
            observeData(data?.body())
        }

        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Any) {
                toast(item.toString())
            }
        })
    }

    private fun observeData(data: SWSearch<Any>?) {
        adapter.submitList(data?.results)
    }
}