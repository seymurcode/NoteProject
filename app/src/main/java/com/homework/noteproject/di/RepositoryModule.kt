package com.homework.noteproject.di

import com.homework.noteproject.repository.NoteRepoInterface
import com.homework.noteproject.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindNoteRepository(prm : NoteRepository) : NoteRepoInterface
}