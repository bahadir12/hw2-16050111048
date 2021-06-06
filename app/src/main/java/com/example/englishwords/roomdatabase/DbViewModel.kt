package com.example.englishwords.roomdatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DbViewModel(application: Application) : AndroidViewModel(application) {
    val all_word_detail: LiveData<List<Words>>
    val all_word_detail_list: LiveData<List<WordList>>
    private val dbRepository: DbRepository

    init {
        val dao = WordDatabase.getAppDatabase(application)?.dao()
        dbRepository = DbRepository(dao!!)
        all_word_detail = dbRepository.all_word_detail
        all_word_detail_list = dbRepository.all_word_detail_list
    }

    fun insertWordDetail(words: Words) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.insertWordDetail(words)
        }
    }

    fun insertWordDetailList(wordList: WordList) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.insertWordDetailList(wordList)
        }
    }
    fun checkEmptyList(): Int {
        return dbRepository.checkList()
    }
    fun deleteWordDetailList(wordList: WordList) {
        viewModelScope.launch(Dispatchers.IO) {
            dbRepository.deleteWordDetailList(wordList)
        }
    }
}