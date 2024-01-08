package com.homework.noteproject.repository

import android.content.Context
import com.homework.noteproject.dao.NoteDao
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResourceRepository @Inject constructor(@ApplicationContext val applicationContext: Context) {
    fun getString(resourceId: Int) : String{
        return  applicationContext.getString(resourceId)
    }
}