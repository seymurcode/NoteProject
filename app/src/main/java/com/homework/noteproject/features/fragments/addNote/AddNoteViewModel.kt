package com.homework.noteproject.features.fragments.addNote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.homework.noteproject.R
import com.homework.noteproject.di.StringResourcesProvider
import com.homework.noteproject.model.Note
import com.homework.noteproject.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    var noteRepository: NoteRepository, val resourcesProvider: StringResourcesProvider
) : ViewModel() {



    var addNoteEvent = MutableLiveData<Boolean>()
    var titleText = MutableLiveData<String>()
    var descriptionText = MutableLiveData<String>()
    var errorObserver = MutableLiveData<String>()


    fun saveNoteClick() {

        if(titleText.value.isNullOrEmpty() || descriptionText.value.isNullOrEmpty()){
            errorObserver.postValue(resourcesProvider.getString(R.string.add_error))
            return
        }
        addNoteEvent.postValue(true)
    }

    fun createNewNote() : Note {
        return Note(0, titleText.value ?: "", descriptionText.value ?: "")
    }

    fun insert(note: Note) {
        viewModelScope.launch {
            noteRepository.insert(note)
        }
    }
}