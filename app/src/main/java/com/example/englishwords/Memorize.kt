package com.example.englishwords

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.englishwords.roomdatabase.DbViewModel
import kotlinx.android.synthetic.main.activity_memorize.*

class Memorize : AppCompatActivity() {
    private lateinit var viewModel: DbViewModel
    private var word: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorize)
        viewModel = ViewModelProvider(this)[DbViewModel::class.java]
        val check: Int = viewModel.checkEmptyList()
        if (check == 0) {
            Toast.makeText(this, "Your List is empty!", Toast.LENGTH_LONG).show()
            val intent = Intent(this@Memorize, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        viewModel.all_word_detail_list.observe(this, { allWords ->
            word = allWords.random().word
            memorize_text.text = word

            memorize_button.setOnClickListener {
                for (i in allWords) {
                    if (word == i.word) {
                        viewModel.deleteWordDetailList(i)
                        val intent = Intent(this@Memorize, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        })

        remind_button.setOnClickListener {
            val intent = Intent(this@Memorize, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}