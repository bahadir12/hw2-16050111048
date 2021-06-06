package com.example.englishwords

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.englishwords.roomdatabase.DbViewModel
import com.example.englishwords.roomdatabase.WordList
import com.example.englishwords.roomdatabase.Words
import kotlinx.android.synthetic.main.activity_words_detail.*

class WordsDetail : AppCompatActivity() {
    private lateinit var words_list: List<Words>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_detail)
        val viewModel = ViewModelProvider(this)[DbViewModel::class.java]

        viewModel.all_word_detail.observe(this, { wordsFromDatabase ->
            words_list = wordsFromDatabase
            val randomWord = words_list.random()
            word_text.text = randomWord.word
            type_text.text = randomWord.type
            def_text.text = randomWord.def
            sentence_text.text = randomWord.sentence
            synonyms_text.text = randomWord.synonyms
            antonyms_text.text = randomWord.antonyms
        })

        next_button.setOnClickListener {
            val randomWord = words_list.random()
            word_text.text = randomWord.word
            type_text.text = randomWord.type
            def_text.text = randomWord.def
            sentence_text.text = randomWord.sentence
            synonyms_text.text = randomWord.synonyms
            antonyms_text.text = randomWord.antonyms
        }

        add_button.setOnClickListener {
            viewModel.insertWordDetailList(
                WordList(
                    0,
                    word_text.text.toString(),
                    def_text.text.toString(),
                    sentence_text.text.toString(),
                    synonyms_text.text.toString(),
                    antonyms_text.text.toString(),
                    type_text.text.toString()
                )
            )
        }

    }




}