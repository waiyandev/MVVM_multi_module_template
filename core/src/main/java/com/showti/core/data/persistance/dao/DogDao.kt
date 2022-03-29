package com.showti.core.data.persistance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.showti.core.models.DogModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(dog:DogModel):Long

    @Query("SELECT * from dog")
    fun getAll(): List<DogModel>

    @Query("DELETE from dog where id = :itemId")
    suspend fun deleteItem(itemId:Int)

}