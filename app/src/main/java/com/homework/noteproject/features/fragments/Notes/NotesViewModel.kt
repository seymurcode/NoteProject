package com.homework.noteproject.features.fragments.Notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.homework.noteproject.model.Note
import com.homework.noteproject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {

    // TODO: Implement the ViewModel
    var noteList = mutableListOf<Note>()
    fun getAllData() : LiveData<List<Note>> {
        return noteRepository.getAll()
    }
}