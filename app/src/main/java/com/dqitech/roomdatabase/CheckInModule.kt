package com.dqitech.roomdatabase

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CheckInModule {

    @Singleton
    @Provides
    fun getRepository(dao: CheckInDao): CheckInRepository {
        return CheckInRepository(dao)
    }

    @Singleton
    @Provides
    fun getDao(database: CheckInDatabase): CheckInDao {
        return database.checkInDao()
    }

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): CheckInDatabase {
        return Room.databaseBuilder(
            context.applicationContext, CheckInDatabase::class.java, "checkin_database"
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }
}