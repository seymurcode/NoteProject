package com.homework.noteproject.features.fragments.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homework.noteproject.model.Note
import com.homework.noteproject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {

    // TODO: Implement the ViewModel
    var noteList = mutableListOf<Note>()
    fun getAllData() : LiveData<List<Note>> {
        return noteRepository.getAll()
    }
    fun delete(note: Note) {
        viewModelScope.launch {
            noteRepository.delete(note)
        }
    }
}