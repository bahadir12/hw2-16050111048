package com.example.englishwords.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Query("SELECT * FROM Words ORDER BY word")
    fun get_all(): LiveData<List<Words>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert_to_database(words: Words)

    @Query("SELECT * FROM WordList ORDER BY word")
    fun get_all_mylist(): LiveData<List<WordList>>

    @Delete
    fun delete_list(wordList: WordList)

    @Query("SELECT COUNT(*) FROM WordList")
    fun check(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert_list(wordList: WordList)


}