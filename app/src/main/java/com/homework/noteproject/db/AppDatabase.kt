package com.homework.noteproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.homework.noteproject.dao.NoteDao
import com.homework.noteproject.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao

    companion object {
        private var DATABASE_INSTANCE : AppDatabase? = null
        fun getDatabase(context : Context) : AppDatabase{
            if(DATABASE_INSTANCE!=null) {
                return DATABASE_INSTANCE!!
            }
            else {
                synchronized(this) {
                    val DATABASE_INSTANCE =
                        Room.databaseBuilder(context, AppDatabase::class.java, "notedb").build()
                    return DATABASE_INSTANCE!!
                }
            }
        }
    }
}