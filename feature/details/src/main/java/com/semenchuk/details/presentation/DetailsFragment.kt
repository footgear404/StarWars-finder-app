package com.semenchuk.details.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ToggleButton
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.semenchuk.api.retrofit.models.FilmsResponse
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.base.BaseFragment
import com.semenchuk.details.R
import com.semenchuk.details.databinding.FragmentDetailsBinding
import com.semenchuk.details.databinding.MovieViewBinding
import com.semenchuk.details.databinding.StarsipViewBinding
import com.semenchuk.state.LoadState
import com.semenchuk.utils.UrlIdExtractor
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    private val args by navArgs<DetailsFragmentArgs>()
    private val viewModel by viewModel<DetailsViewModel>()

    override fun initBinding(inflater: LayoutInflater): FragmentDetailsBinding =
        FragmentDetailsBinding.inflate(inflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        args.peopleResponse?.let { bindViewForPerson(it) }
        args.starshipResponse?.let { bindViewForStarship(it) }
        args.planetsResponse?.let { bindViewForPlanet(it) }

        setupHomeworldObserver()
        setupFilmsObserver()
        setupFilmsStateObserver()
        setupStarshipsObserver()
        setupStarshipsStateObserver()
    }


    private fun bindViewForPerson(item: PeopleResponse) {
        with(binding) {
            name.text = item.name
            personInfo.apply {
                root.visibility = View.VISIBLE
                gender.text = getString(R.string.sex, item.gender)
                height.text = getString(R.string.height, item.height)
                birthYear.text = getString(R.string.birth_year, item.birthYear)
                eyeColor.text = getString(R.string.eye_color, item.eyeColor)
                hairColor.text = getString(R.string.hair_color, item.hairColor)
                homeworld.text = getString(R.string.loading)
                skinColor.text = getString(R.string.skin_color, item.skinColor)
                mass.text = getString(R.string.mass, item.mass)
            }
            UrlIdExtractor.extractIdFromUrl(item.homeworld)?.let { viewModel.getHomeworldName(it) }
            UrlIdExtractor.bulkExtractIdsFromUrls(item.films).let { viewModel.getFilmsById(it) }
            UrlIdExtractor.bulkExtractIdsFromUrls(item.starships)
                .let { viewModel.getStarshipsById(it) }
        }

        binding.addToFavorite.setOnClickListener {
            when ((it as ToggleButton).isChecked) {
                true -> viewModel.addPeopleToFavorite(item)
                false -> viewModel.removePeopleFromFavorite(item)
            }
        }
    }

    private fun bindViewForStarship(item: StarshipsResponse) {
        with(binding) {
            name.text = item.name
            starshipInfo.apply {
                root.visibility = View.VISIBLE
                name.text = getString(R.string.starship_name, item.name)
                model.text = getString(R.string.model, item.model)
                manufacturer.text = getString(R.string.manufacturer, item.manufacturer)
                cost.text = getString(R.string.cost_in_credits, item.costInCredits)

            }
        }
        binding.addToFavorite.setOnClickListener {
            when ((it as ToggleButton).isChecked) {
                true -> viewModel.addStarshipToFavorite(item)
                false -> viewModel.removeStarshipFromFavorite(item)
            }
        }
    }

    private fun bindViewForPlanet(item: PlanetsResponse) {
        binding.planetInfo.root.visibility = View.VISIBLE
        toast(item.name.toString())
    }

    private fun setupHomeworldObserver() {
        flowObserver(viewModel.homeworld) { homeworld ->
            binding.personInfo.homeworld.text = getString(R.string.homeworld, homeworld)
        }
    }

    private fun setupFilmsStateObserver() {
        flowObserver(viewModel.loadFilmState) {
            binding.personInfo.filmList.progress.isVisible = it == LoadState.Loading
        }
    }

    private fun setupStarshipsStateObserver() {
        flowObserver(viewModel.loadStarshipsState) {
            binding.personInfo.starshipList.progress.isVisible = it == LoadState.Loading
        }
    }


    private fun setupFilmsObserver() {
        flowObserver(viewModel.films) { data ->
            binding.personInfo.filmList.headerTitle.text = getString(R.string.films_with_person)
            val customViews = createCustomMovieViews(requireContext(), data)
            val linearLayout = binding.personInfo.filmList.root
            for (customView in customViews) {
                linearLayout.addView(customView.root)
            }
        }
    }

    private fun setupStarshipsObserver() {
        flowObserver(viewModel.starships) { data ->
            binding.personInfo.starshipList.headerTitle.text = getString(R.string.starships)
            val customViews = createCustomStarshipViews(requireContext(), data)
            val linearLayout = binding.personInfo.starshipList.root
            for (customView in customViews) {
                linearLayout.addView(customView.root)
            }
        }
    }

    @SuppressLint("InflateParams")
    fun createCustomMovieViews(
        context: Context,
        filmsList: List<FilmsResponse>,
    ): List<MovieViewBinding> {
        val customViews = mutableListOf<MovieViewBinding>()

        for (film in filmsList) {
            val inflater = LayoutInflater.from(context)
            val customView = MovieViewBinding.inflate(inflater)
            customView.filmName.text = getString(R.string.film_name, film.title)
            customView.director.text = getString(R.string.director, film.director)
            customView.producer.text = getString(R.string.producer, film.producer)
            customView.year.text = getString(R.string.year, film.releaseDate)

            customViews.add(customView)
        }

        return customViews
    }

    @SuppressLint("InflateParams")
    fun createCustomStarshipViews(
        context: Context,
        starshipList: List<StarshipsResponse>,
    ): List<StarsipViewBinding> {
        val customViews = mutableListOf<StarsipViewBinding>()

        for (starship in starshipList) {
            val inflater = LayoutInflater.from(context)
            val customView = StarsipViewBinding.inflate(inflater)
            customView.starshipName.text = getString(R.string.starship_name, starship.name)
            customView.model.text = getString(R.string.model, starship.model)
            customView.manufacturer.text = getString(R.string.manufacturer, starship.manufacturer)
            customView.cost.text = getString(R.string.cost_in_credits, starship.costInCredits)

            customViews.add(customView)
        }

        return customViews
    }
}
