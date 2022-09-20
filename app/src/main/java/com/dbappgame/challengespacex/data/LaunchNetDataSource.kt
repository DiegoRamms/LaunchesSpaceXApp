package com.dbappgame.challengespacex.data

import com.dbappgame.challengespacex.data.model.LaunchDTO

interface LaunchNetDataSource{
    suspend fun getLaunches(): List<LaunchDTO>
}