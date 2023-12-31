package com.homework.noteproject.features.fragments.AddNote

import androidx.lifecycle.ViewModel
import com.homework.noteproject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}