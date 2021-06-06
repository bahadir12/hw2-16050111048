package com.example.englishwords

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.englishwords.roomdatabase.DbViewModel
import com.example.englishwords.roomdatabase.WordList
import kotlinx.android.synthetic.main.activity_add_word.*

class AddWord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_word)
        val viewModel = ViewModelProvider(this)[DbViewModel::class.java]

        add_to_list_button.setOnClickListener {
            viewModel.insertWordDetailList(
                WordList(
                    0,
                    word_edit.text.toString(),
                    def_edit.text.toString(),
                    sentence_edit.text.toString(),
                    synonyms_edit.text.toString(),
                    antonyms_edit.text.toString(),
                    type_edit.text.toString()
                )
            )

            val intent = Intent(this@AddWord, MainActivity::class.java)
            startActivity(intent)
        }
    }
}