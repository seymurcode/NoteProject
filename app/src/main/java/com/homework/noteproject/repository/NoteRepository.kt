package com.homework.noteproject.repository

import androidx.lifecycle.LiveData
import com.homework.noteproject.dao.NoteDao
import com.homework.noteproject.model.Note
import javax.inject.Inject


interface NoteRepoInterface {

}

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }


    fun getAll(): LiveData<List<Note>> {
        return noteDao.getAll()
    }
}