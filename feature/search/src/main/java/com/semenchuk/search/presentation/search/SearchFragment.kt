package com.semenchuk.search.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.semenchuk.EntityType
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.SWSearch
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.base.BaseFragment
import com.semenchuk.search.R
import com.semenchuk.search.databinding.FragmentSearchBinding
import com.semenchuk.search.presentation.search.adapter.OnItemClickListener
import com.semenchuk.search.presentation.search.adapter.SearchItemsAdapter
import com.semenchuk.state.LoadState
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentSearchBinding.inflate(inflater)

    private val viewModel by viewModel<SearchViewModel>()

    private val adapter = SearchItemsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flowObserver(viewModel.result) { data -> observeData(data?.body()) }
        flowObserver(viewModel.loadState) { loadState -> loadingObserve(loadState) }

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

        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: Any) {
                when (item) {
                    is PeopleResponse ->  navigate(SearchFragmentDirections.actionSearchFragmentToDetailsNav(item, null, null))
                    is StarshipsResponse -> {navigate(SearchFragmentDirections.actionSearchFragmentToDetailsNav( null ,  item, null))}
                    is PlanetsResponse -> {navigate(SearchFragmentDirections.actionSearchFragmentToDetailsNav(null, null, item))}
                }
            }
        })
    }

    private fun loadingObserve(loadState: LoadState) {
        with(binding) {
            loading.isVisible = loadState == LoadState.Loading
        }
    }

    private fun observeData(data: SWSearch<Any>?) {
        adapter.submitList(data?.results)
    }
}