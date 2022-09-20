package com.dbappgame.challengespacex.data.repository

import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.utils.Resource

interface LaunchRepository {
    suspend fun getLaunches(): Resource<List<Launch>>
}