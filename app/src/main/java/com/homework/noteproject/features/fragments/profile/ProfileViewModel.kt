package com.homework.noteproject.features.fragments.profile

import androidx.lifecycle.ViewModel
import com.homework.noteproject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(var noteRepository: NoteRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}