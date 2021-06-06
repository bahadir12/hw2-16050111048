package com.example.englishwords.roomdatabase

import androidx.lifecycle.LiveData

class DbRepository(private val dao: Dao) {
    val all_word_detail: LiveData<List<Words>> = dao.get_all()
    val all_word_detail_list: LiveData<List<WordList>> = dao.get_all_mylist()

    fun insertWordDetail(words: Words) {
        dao.insert_to_database(words)
    }

    fun insertWordDetailList(wordList: WordList) {
        dao.insert_list(wordList)
    }

    fun checkList(): Int {
        return dao.check()
    }

    fun deleteWordDetailList(wordList: WordList) {
        dao.delete_list(wordList)
    }
}