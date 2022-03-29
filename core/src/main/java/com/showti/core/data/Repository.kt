package com.showti.core.data

import com.showti.core.data.persistance.dao.DogDao
import com.showti.core.data.remote.RemoteDataSource
import com.showti.core.models.BaseApiResponse
import com.showti.core.models.DogModel
import com.showti.core.models.DogResponse
import com.showti.core.utils.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val dogDao: DogDao
) : BaseApiResponse(){

    suspend fun getDog() : Flow<NetworkResult<DogResponse>> {
        return flow<NetworkResult<DogResponse>>{
            emit(safeApiCall { remoteDataSource.getDog() })
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getAll() : Flow<List<DogModel>> {
        return flow{
            emit(dogDao.getAll())
        }.flowOn(Dispatchers.IO)
    }

    suspend fun insertDog(dogModel: DogModel):Long = dogDao.insertDog(dogModel)

    suspend fun deleteDog(id:Int) = dogDao.deleteItem(id)
}