package com.homework.noteproject.features.fragments.notesRecycleView

import androidx.lifecycle.ViewModel
import com.homework.noteproject.repository.NoteRepository
import com.homework.noteproject.repository.ResourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteFragmentRecycleViewModel  @Inject constructor(
    var noteRepository: NoteRepository, val resourcesProvider: ResourceRepository
) : ViewModel() {
    // TODO: Implement the ViewModel
}