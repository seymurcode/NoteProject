package com.homework.noteproject.features.fragments.editNote

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
class EditNoteViewModel @Inject constructor(var noteRepository: NoteRepository, val resourcesProvider: StringResourcesProvider) : ViewModel() {

    var editNoteEvent = MutableLiveData<Boolean>()
    var titleText = MutableLiveData<String>()
    var descriptionText = MutableLiveData<String>()
    var errorObserver = MutableLiveData<String>()


    fun saveNoteClick() {

        if(titleText.value.isNullOrEmpty() || descriptionText.value.isNullOrEmpty()){
            errorObserver.postValue(resourcesProvider.getString(R.string.edit_error))
            return
        }
        editNoteEvent.postValue(true)
    }

    fun setTexts(oldNote : Note){
        titleText.value=oldNote.title
        descriptionText.value=oldNote.description
    }

    fun createUpdatedNote(oldNote : Note) : Note {
        return Note(oldNote.uid, titleText.value ?: "", descriptionText.value ?: "")
    }

    fun update(note: Note) {
        viewModelScope.launch {
            noteRepository.update(note)
        }
    }
}