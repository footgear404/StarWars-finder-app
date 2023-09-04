package com.semenchuk.details.utils

import com.semenchuk.api.retrofit.models.PeopleResponse
import com.semenchuk.api.retrofit.models.StarshipsResponse
import com.semenchuk.data.models.Person
import com.semenchuk.data.models.Starship


class Mapper {
    companion object {
        fun PeopleResponse.toPerson(): Person {
            return Person(
                name = this.name!!,
                sumOfStarships = this.starships.size ?: 0,
                birthYear = this.birthYear,
                eyeColor = this.eyeColor,
                gender = this.gender!!,
                hairColor = this.hairColor!!,
                height = this.height!!,
                homeworld = this.homeworld!!,
                mass = this.mass!!,
                skinColor = this.skinColor!!
            )
        }

        fun Person.toPeopleResponse(): PeopleResponse {
            return PeopleResponse(
                name = this.name,
                birthYear = this.birthYear,
                eyeColor = this.eyeColor,
                gender = this.gender,
                hairColor = this.hairColor,
                height = this.height,
                homeworld = this.homeworld,
                mass = this.mass,
                skinColor = this.skinColor,
                created = null,
                edited = null,
                films = emptyList(),
                species = emptyList(),
                starships = emptyList(),
                url = null,
                vehicles = emptyList()
            )
        }

        fun StarshipsResponse.toStarshipEntity(): Starship {
            return Starship(
                name = this.name,
                cargoCapacity = this.cargoCapacity,
                consumables = this.consumables,
                costInCredits = this.costInCredits,
                created = this.created,
                crew = this.crew,
                edited = this.edited,
                hyperdriveRating = this.hyperdriveRating,
                length = this.length,
                mGLT = this.mGLT,
                manufacturer = this.manufacturer,
                maxAtmospheringSpeed = this.maxAtmospheringSpeed,
                model = this.model,
                passengers = this.passengers,
                starshipClass = this.starshipClass,
                url = this.url
            )
        }

        fun Starship.toStarshipResponse(): StarshipsResponse {
            return StarshipsResponse(
                name = this.name,
                cargoCapacity = this.cargoCapacity ?: "",
                consumables = this.consumables,
                costInCredits = this.costInCredits,
                created = this.created,
                crew = this.crew,
                edited = this.edited,
                hyperdriveRating = this.hyperdriveRating,
                length = this.length,
                mGLT = this.mGLT,
                manufacturer = this.manufacturer,
                maxAtmospheringSpeed = this.maxAtmospheringSpeed,
                model = this.model,
                passengers = this.passengers,
                starshipClass = this.starshipClass,
                url = this.url,
                films = emptyList(),
                pilots = emptyList()
            )
        }
    }
}