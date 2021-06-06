package com.example.englishwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_quiz_type.*

class QuizType : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_type)

        button5.setOnClickListener {
            val intent = Intent(this@QuizType, Quiz::class.java).putExtra("type","Verb")
            startActivity(intent)
        }
        button6.setOnClickListener {
            val intent = Intent(this@QuizType, Quiz::class.java).putExtra("type","Adverb")
            startActivity(intent)
        }
        button7.setOnClickListener {
            val intent = Intent(this@QuizType, Quiz::class.java).putExtra("type","Adjective")
            startActivity(intent)
        }
        button8.setOnClickListener {
            val intent = Intent(this@QuizType, Quiz::class.java).putExtra("type","Phrases and Idiom")
            startActivity(intent)
        }

    }
}