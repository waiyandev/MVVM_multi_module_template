package com.showti.core.data.remote

import com.showti.core.models.DogResponse
import com.showti.core.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>
}