package com.example.englishwords.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Words::class, WordList::class], version = 1)
abstract class WordDatabase : RoomDatabase() {
    abstract fun dao(): Dao

    companion object {
        private var INSTANCE: WordDatabase? = null
        fun getAppDatabase(context: Context): WordDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, WordDatabase::class.java, "WordDatabase"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}