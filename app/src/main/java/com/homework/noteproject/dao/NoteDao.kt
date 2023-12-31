package com.homework.noteproject.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.homework.noteproject.model.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(note: Note) //suspebancaq backgroundda calisir, basqa threadda cagirmaliyiq

    @Query("SELECT * FROM note")
    fun getAll() : LiveData<List<Note>>

    @Delete
    suspend fun delete (note: Note)
}