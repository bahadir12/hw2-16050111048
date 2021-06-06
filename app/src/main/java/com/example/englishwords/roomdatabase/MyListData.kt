package com.example.englishwords.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "WordList")
data class WordList(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "word") val word: String,
    @ColumnInfo(name = "def") val def: String,
    @ColumnInfo(name = "synonyms") val synonyms: String,
    @ColumnInfo(name = "antonyms") val antonyms: String,
    @ColumnInfo(name = "sentence") val sentence: String,
    @ColumnInfo(name = "type") val type: String
)