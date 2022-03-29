package com.showti.features.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.showti.core.binding.BindingViewModel
import com.showti.core.data.Repository
import com.showti.core.models.DogModel
import com.showti.core.models.DogResponse
import com.showti.core.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val repository: Repository
):BindingViewModel() {

    private val _response: MutableLiveData<NetworkResult<DogResponse>> = MutableLiveData()
    val response: LiveData<NetworkResult<DogResponse>> =_response

    private val _dogResponse : MutableLiveData<List<DogModel>> = MutableLiveData()
    val dogResponse: LiveData<List<DogModel>> = _dogResponse


    private val _insertId : MutableLiveData<Long> = MutableLiveData()
    val insertId :LiveData<Long> = _insertId


    fun getResponse() = viewModelScope.launch {
        repository.getDog().collect { values ->
            _response.value = values
        }
    }

    fun insertDog(dogModel: DogModel) = viewModelScope.launch {
        val id = repository.insertDog(dogModel)
        _insertId.value = id
    }

    fun getAllDogs() = viewModelScope.launch {
        repository.getAll().collect { values ->
            _dogResponse.value = values
        }
    }

    fun deleteDog(id:Int) = viewModelScope.launch {
        repository.deleteDog(id)
    }

    init {
        getResponse()
    }

}