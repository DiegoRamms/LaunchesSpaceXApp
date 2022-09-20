package com.dbappgame.challengespacex.data.service

import com.dbappgame.challengespacex.data.model.LaunchDTO
import retrofit2.http.GET

interface LaunchService {

    @GET("launches")
    suspend fun getLaunches(): List<LaunchDTO>
}