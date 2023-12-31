package com.homework.noteproject.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Note(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name="title") val title: String,
    @ColumnInfo(name="description") val description : String,
) : Parcelable {}