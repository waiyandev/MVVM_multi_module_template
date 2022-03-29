package com.showti.temphilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.showti.core.data.Repository
import com.showti.core.models.DogResponse
import com.showti.core.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()
    val response:LiveData<NetworkResult<DogResponse>> =_response

    fun fetchDogResponse() = viewModelScope.launch {
        repository.getDog().collect {
            values -> _response.value = values
        }
    }
}