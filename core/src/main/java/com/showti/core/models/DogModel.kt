package com.showti.core.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog")
data class DogModel(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null ,
    var name:String = "",
    var url:String = ""
)