package com.dbappgame.challengespacex.data.repository

import com.dbappgame.challengespacex.data.LaunchNetDataSource
import com.dbappgame.challengespacex.domain.LaunchMapper.toDomainList
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.utils.Resource
import retrofit2.Retrofit
import javax.inject.Inject

class LaunchRepositoryImp @Inject constructor(
    private val dataSource: LaunchNetDataSource
) : LaunchRepository {
    override suspend fun getLaunches(): Resource<List<Launch>> {
        val response  = dataSource.getLaunches()
        val launches = response.toDomainList()
        return Resource.Success(launches)
    }
}