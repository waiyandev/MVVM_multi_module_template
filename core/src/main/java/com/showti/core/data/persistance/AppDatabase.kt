package com.showti.core.data.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.showti.core.data.persistance.dao.DogDao
import com.showti.core.models.DogModel

@Database(entities = [DogModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dogDao():DogDao

    companion object{
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase =
            instance?: synchronized(this){ instance?: buildDatabase(context).also { instance = it }}

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext,AppDatabase::class.java,"mydb")
                .fallbackToDestructiveMigration()
                .build()
    }


}