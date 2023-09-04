package com.semenchuk.favorite

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.base.BaseFragment
import com.semenchuk.favorite.databinding.FavoritPersonsBinding
import com.semenchuk.favorite.databinding.FavoriteStarshipsBinding
import com.semenchuk.favorite.databinding.FragmentFavoriteBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun initBinding(inflater: LayoutInflater): FragmentFavoriteBinding =
        FragmentFavoriteBinding.inflate(inflater)

    private val viewModel by viewModel<FavoriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loadFavoritePerson()
            viewModel.loadFavoriteStarship()
        }

        flowObserver(viewModel.favoritePerson) {
            it?.let { listResponse ->
                val customViews = createFavoritePersonView(requireContext(), listResponse)
                val linearLayout = binding.favoritePersons
                for (customView in customViews) {
                    linearLayout.addView(customView.root)
                }
            }
        }

        flowObserver(viewModel.favoriteStarships) {
            it?.let { listResponse ->
                val customViews = createFavoriteStarshipView(requireContext(), listResponse)
                val linearLayout = binding.favoriteStarships
                for (customView in customViews) {
                    linearLayout.addView(customView.root)
                }
            }
        }
    }

    @SuppressLint("InflateParams")
    fun createFavoritePersonView(
        context: Context,
        persons: List<PeopleResponse>,
    ): List<FavoritPersonsBinding> {
        val customViews = mutableListOf<FavoritPersonsBinding>()

        for (person in persons) {
            val inflater = LayoutInflater.from(context)
            val customView = FavoritPersonsBinding.inflate(inflater)
            customView.name.text = getString(R.string.name, person.name)
            customView.gender.text = getString(R.string.gender, person.gender)
            customView.sumOfStarships.text =
                getString(R.string.fleet, person.starships.size.toString())

            customViews.add(customView)
        }

        return customViews
    }

    @SuppressLint("InflateParams")
    fun createFavoriteStarshipView(
        context: Context,
        starships: List<StarshipsResponse>,
    ): List<FavoriteStarshipsBinding> {
        val customViews = mutableListOf<FavoriteStarshipsBinding>()

        for (starship in starships) {
            val inflater = LayoutInflater.from(context)
            val customView = FavoriteStarshipsBinding.inflate(inflater)
            customView.name.text =
                getString(com.semenchuk.details.R.string.starship_name, starship.name)
            customView.manufacturer.text = getString(R.string.manufacturer, starship.manufacturer)
            customView.model.text =
                getString(R.string.model, starship.model)
            customView.passenger.text =
                getString(R.string.passengers, starship.passengers)

            customViews.add(customView)
        }

        return customViews
    }
}