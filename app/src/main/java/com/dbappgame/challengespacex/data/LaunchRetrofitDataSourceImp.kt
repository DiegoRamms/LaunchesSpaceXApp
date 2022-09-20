package com.dbappgame.challengespacex.data

import com.dbappgame.challengespacex.data.service.LaunchService
import com.dbappgame.challengespacex.data.model.LaunchDTO
import javax.inject.Inject

class LaunchRetrofitDataSourceImp @Inject constructor(
    private val launchService: LaunchService
    ) : LaunchNetDataSource {

    override suspend fun getLaunches(): List<LaunchDTO> =
        launchService.getLaunches()
}