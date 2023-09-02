package com.semenchuk.search.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.search.R
import com.semenchuk.search.databinding.SearchPeopleListItemBinding
import com.semenchuk.search.databinding.SearchPlanetListItemBinding
import com.semenchuk.search.databinding.SearchStarshipListItemBinding

class SearchItemsAdapter() : ListAdapter<Any, RecyclerView.ViewHolder>(SearchItemDifUtil()) {

    private var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_PEOPLE -> PeopleViewHolder(
                SearchPeopleListItemBinding.inflate(inflater, parent, false)
            )

            TYPE_PLANETS -> PlanetsViewHolder(
                SearchPlanetListItemBinding.inflate(inflater, parent, false)
            )

            TYPE_STARSHIPS -> StarshipsViewHolder(
                SearchStarshipListItemBinding.inflate(inflater, parent, false)
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            TYPE_PEOPLE -> {
                val item = getItem(position) as PeopleResponse
                (holder as PeopleViewHolder).bind(item)
                holder.itemView.setOnClickListener {
                    onItemClickListener?.onItemClick(item)
                }
            }

            TYPE_PLANETS -> {
                val item = getItem(position) as PlanetsResponse
                (holder as PlanetsViewHolder).bind(item)
                holder.itemView.setOnClickListener {
                    onItemClickListener?.onItemClick(item)
                }
            }

            TYPE_STARSHIPS -> {
                val item = getItem(position) as StarshipsResponse
                (holder as StarshipsViewHolder).bind(item)
                holder.itemView.setOnClickListener {
                    onItemClickListener?.onItemClick(item)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is PeopleResponse -> TYPE_PEOPLE
            is PlanetsResponse -> TYPE_PLANETS
            is StarshipsResponse -> TYPE_STARSHIPS
            else -> throw IllegalArgumentException("Invalid item type")
        }
    }

    inner class PeopleViewHolder(private val binding: SearchPeopleListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bind(item: PeopleResponse) {
            binding.name.text = context.getString(R.string.name, item.name)
            binding.gender.text = context.getString(R.string.gender, item.gender)
            binding.sumOfStarships.text =
                context.getString(R.string.fleet, (item.starships).size.toString())
        }
    }

    inner class PlanetsViewHolder(private val binding: SearchPlanetListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bind(item: PlanetsResponse) {
            binding.name.text = context.getString(R.string.name, item.name)
            binding.diameter.text = context.getString(R.string.diameter, item.diameter)
            binding.population.text = context.getString(R.string.population, item.population)
        }
    }

    inner class StarshipsViewHolder(private val binding: SearchStarshipListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val context = binding.root.context
        fun bind(item: StarshipsResponse) {
            binding.name.text = context.getString(R.string.name, item.name)
            binding.model.text = context.getString(R.string.model, item.model)
            binding.manufacturer.text = context.getString(R.string.manufacturer, item.manufacturer)
            binding.passengers.text = context.getString(R.string.passengers, item.passengers)
        }
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

    companion object {
        private const val TYPE_PEOPLE = 0
        private const val TYPE_PLANETS = 1
        private const val TYPE_STARSHIPS = 2
    }
}

interface OnItemClickListener {
    fun onItemClick(item: Any)
}



