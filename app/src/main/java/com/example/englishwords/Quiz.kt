package com.example.englishwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.englishwords.roomdatabase.DbViewModel
import com.example.englishwords.roomdatabase.Words
import kotlinx.android.synthetic.main.activity_quiz.*
import kotlinx.android.synthetic.main.activity_quiz_type.*

class Quiz : AppCompatActivity() {
    private lateinit var viewModel: DbViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        viewModel = ViewModelProvider(this)[DbViewModel::class.java]
        val quizType: String? = intent.getStringExtra("type")
        viewModel.all_word_detail.observe(this, {it ->
            val quizList: ArrayList<Words> = ArrayList()
            var puan = 0;
            var index = 0;
            for (i in it) {
                if (i.type == quizType)
                    quizList.add(i)
            }

            definition_quiz_text.text = quizList[0].def
            sentence_quiz_text.text = quizList[0].sentence
            synonyms_quiz_text.text = quizList[0].synonyms
            antonyms_quiz_text.text = quizList[0].antonyms

            button9.setOnClickListener {
                if(edit_word_quiz.text.toString() == (quizList[index].word)) {
                    puan++
                    Toast.makeText(this, "True",Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "False",Toast.LENGTH_LONG).show()
                }
                index++
                if(index == 10) {
                    val intent = Intent(this@Quiz, MainActivity::class.java)
                    Toast.makeText(this, "Point:$puan",Toast.LENGTH_LONG).show()
                    startActivity(intent)
                }
                if(index != 10) {
                    definition_quiz_text.text = quizList[index].def
                    sentence_quiz_text.text = quizList[index].sentence
                    synonyms_quiz_text.text = quizList[index].synonyms
                    antonyms_quiz_text.text = quizList[index].antonyms
                }
                edit_word_quiz.getText().clear();
            }


        })



    }
}