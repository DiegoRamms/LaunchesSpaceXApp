package com.dbappgame.challengespacex.domain.usecase

import com.dbappgame.challengespacex.data.repository.LaunchRepository
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.utils.Resource
import javax.inject.Inject

class GetLaunchesUseCase @Inject constructor(private val repository: LaunchRepository) {

    suspend  operator fun invoke(): Resource<List<Launch>>{
        return repository.getLaunches()
    }

}