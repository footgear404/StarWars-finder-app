package com.semenchuk.search.presentation.search.adapter

import androidx.recyclerview.widget.DiffUtil
import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.PlanetsResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse

class SearchItemDifUtil : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is PeopleResponse && newItem is PeopleResponse) {
            return oldItem.name == newItem.name
        } else if (oldItem is PlanetsResponse && newItem is PlanetsResponse) {
            return oldItem.name == newItem.name
        } else if (oldItem is StarshipsResponse && newItem is StarshipsResponse) {
            return oldItem.name == newItem.name
        }
        return false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
        if (oldItem is PeopleResponse && newItem is PeopleResponse) {
            return oldItem == newItem
        } else if (oldItem is PlanetsResponse && newItem is PlanetsResponse) {
            return oldItem == newItem
        } else if (oldItem is StarshipsResponse && newItem is StarshipsResponse) {
            return oldItem == newItem
        }
        return false
    }
}
