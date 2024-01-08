package com.homework.noteproject.repository

import androidx.lifecycle.LiveData
import com.homework.noteproject.dao.NoteDao
import com.homework.noteproject.model.Note
import javax.inject.Inject


interface NoteRepoInterface {
    suspend fun insert(note: Note)
    suspend fun update(note: Note)

    suspend fun delete(note: Note)
    fun getAll(): LiveData<List<Note>>
}

class NoteRepository @Inject constructor(private val noteDao: NoteDao) : NoteRepoInterface{
    override suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    override suspend fun update(note: Note){
        noteDao.update(note)
    }

    override suspend fun delete(note: Note){
        noteDao.delete(note)
    }


    override fun getAll(): LiveData<List<Note>> {
        return noteDao.getAll()
    }
}