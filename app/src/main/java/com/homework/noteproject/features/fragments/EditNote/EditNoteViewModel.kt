package com.homework.noteproject.features.fragments.EditNote

import androidx.lifecycle.ViewModel
import com.homework.noteproject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {
}