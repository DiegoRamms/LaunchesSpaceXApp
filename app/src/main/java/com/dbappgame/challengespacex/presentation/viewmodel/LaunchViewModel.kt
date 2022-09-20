package com.dbappgame.challengespacex.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.domain.usecase.GetLaunchesUseCase
import com.dbappgame.challengespacex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val getLaunchesUseCase: GetLaunchesUseCase
) : ViewModel() {

    private val _launches = MutableLiveData<List<Launch>>()
    val launches get(): LiveData<List<Launch>> = _launches
    private val _isLoading = MutableLiveData(false)
    val isLoading get(): LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData("")
    val error get(): LiveData<String> = _error
    var launchSelected: Launch? = null
    var currentPosition: Int = 0

     fun getLaunches() {
        _isLoading.value = true
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
                _error.postValue(
                    "Error" + throwable.message
                )
            }) {
                when (val resource = getLaunchesUseCase()) {
                    is Resource.Success -> {
                        withContext(Dispatchers.Main) { resource.data.reversed().let { _launches.value = it } }
                    }
                    is Resource.Error -> {
                        _error.postValue(resource.message)
                    }
                }

            }
            _isLoading.value = false
        }
    }

    fun selectLaunch(launch: Launch, position: Int){
        launchSelected = launch
        currentPosition = position
    }

}