package com.homework.noteproject.di

import android.content.Context
import androidx.room.Room
import com.homework.noteproject.dao.NoteDao
import com.homework.noteproject.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providerNoteDao(database: AppDatabase) : NoteDao{
        return database.noteDao()
    }

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context : Context) : AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "notedb").build()
    }
}