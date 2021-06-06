package com.example.englishwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.englishwords.roomdatabase.DbViewModel
import com.example.englishwords.roomdatabase.WordList
import com.example.englishwords.roomdatabase.Words
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DbViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startService(Intent(this, Notification::class.java))
        viewModel = ViewModelProvider(this)[DbViewModel::class.java]
        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        val firstStart = prefs.getBoolean("start", true)
        if (firstStart) {
            addDataToDatabase()
            val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putBoolean("start", false)
            editor.apply()
        }

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, WordsDetail::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            val intent = Intent(this@MainActivity, AddWord::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this@MainActivity, QuizType::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            val intent = Intent(this@MainActivity, Memorize::class.java)
            startActivity(intent)
        }

    }

    private fun addDataToDatabase() {
        viewModel.insertWordDetail(Words(0,"Widely","By a lot of people; in or to many places","Generally","Narrowly","The idea is now widely accepted.","Verb"))
        viewModel.insertWordDetail(Words(0,"Home","The house or flat that you live in, especially with your family","Central","Outside","Old people prefer to stay in their own homes.","Verb"))
        viewModel.insertWordDetail(Words(0,"Just","Only","Even as","Imprecise","There is just one method that might work.","Verb"))
        viewModel.insertWordDetail(Words(0,"Abroad"," In or to a foreign country","Away","At home","She worked abroad for a year.","Verb"))
        viewModel.insertWordDetail(Words(0,"Extremely","To a very high degree","Incompletely","Acutely","It is extremely important to follow the directions exactly.","Verb"))
        viewModel.insertWordDetail(Words(0,"Furthermore","​In addition to what has just been stated. Furthermore is used especially to add a point to an argument.","Moreover","Then","He said he had not discussed the matter with her. Furthermore, he had not even contacted her.","Verb"))
        viewModel.insertWordDetail(Words(0,"Mostly","Generally","Chiefly","Rarely","We're mostly out on Sundays.","Verb"))
        viewModel.insertWordDetail(Words(0,"Seriously","In a serious ways","Actively","Casually","They are seriously concerned about security.","Verb"))
        viewModel.insertWordDetail(Words(0,"Low"," In or into a low position, not far above the ground","Below","Big","The sun sank lower towards the horizon.","Verb"))
        viewModel.insertWordDetail(Words(0,"Since","From a time in the past until a later past time, or until now","After all","Future ","Since the party she had only spoken to him once.","Verb"))


        viewModel.insertWordDetail(Words(0,"Request"," The action of asking for something formally and politely; a thing that you formally ask for","Appeal","Answer","They made a request for further aid.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Require"," To need something; to depend on somebody/something","Lack","Dislike","Deciphering the code requires an expert.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Land","The surface of the earth that is not sea","Dock","Ascend","The new project will reclaim the land from the sea.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Hurry"," To move or act quickly because there is not much time","Dash","Slow","We need to hurry or we'll be late for school.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Research","A careful study of a subject, especially in order to discover new facts or information about it","Investigate","Ignore","They are raising money for cancer research.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Notice","To see or hear somebody/something; to become aware of somebody/something","Acknowledge","Disregard","I began to notice something strange.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Move"," To change position or make somebody/something change position in a way that can be seen, heard or felt","Advance","Cease","The bus was already moving when I jumped onto it.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Relax","To rest while you are doing something that you enjoy, especially after work or effort","Calm","Worry","You need a little time to relax and unwind.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Respond","To give a spoken or written answer to somebody/something","acknowledge","Leave","She never responded to my letter.","Adverb"))
        viewModel.insertWordDetail(Words(0,"Rub","To move your hand, a cloth, etc., backwards and forwards over a surface while pressing it","Apply","Reveal","She rubbed her chin thoughtfully.","Adverb"))

        viewModel.insertWordDetail(Words(0,"Individual","A person considered separately rather than as part of a group","LOne","Combined","The competition is open to both teams and individuals.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Patient","A person who is receiving medical treatment, especially in a hospital","Calm","Agitated","Hospitals are treating more patients than ever before.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Able"," Able to do something","Adept","Disinclined","I didn't feel able to disagree with him.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Light","The energy from the sun, a lamp, etc. that makes it possible to see things","Bright","Cloudy","Some light filters through the dense tree cover.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Medical","Connected with illness and injury and their treatment","Pharmaceutical","Injury","His medical records showed that he was unfit for work.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Personal","Your own; not belonging to or connected with anyone else","Intimate","Common","Her art is deeply personal.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Physical","Connected with a person’s body rather than their mind","Natural","Immaterial","He tends to avoid all physical contact.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Ordinary"," Not unusual or different in any way","Everyday","Unusual","This was no ordinary meeting.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Organized","Involving large numbers of people who work together to do something in a way that has been carefully planned","Formed","unorganized","He was part of an organized criminal gang.","Adjective"))
        viewModel.insertWordDetail(Words(0,"Outside"," Not in a room, building or container but on or to the outside of it","Farther","central","The house is painted green outside.","Adjective"))

        viewModel.insertWordDetail(Words(0,"Food for thought"," Something that provides a mental stimulus for thinking","-t","-","Their suggestions in the meeting gave us a lot of food for thought","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Scratch your head","To have difficulty understanding something","-","-"," the failure of the project left the team leaders scractching their heads about why this happened","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Be unable to hear yourself think","To say that there is a lot of noise","-","-","the baby was crying incessantly and I was literally","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Have a mind of your own","To be independent in making decisions","-","-","we tried to persuade him not to resign, but you know that he has a mind of his own, so he did not listen to any of us","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Bring someone to their senses","To cause someone to start thinking in a rational way","","","she started to sound irretional after weeks of working without a break. A copule of days of rest will bring her to her senses.","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Come up with","Produce an idea","-","-","Steve jobs came up with the idea that iTunes should sell a special digital boxed set of all Dylan's music","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Set off","Start a journey ","-","-","Let's decide what time we will set off for the airport tomorrow morning","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Sort out ","Deal with something or make arrangements","-","-","If the Prime Minister is unable to sort out the current instabillity, then the country will go to elections.","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Get away with","To do something bad and escape without any consequences","-","-","Many people believe that Dan Cooper, a criminal who hijacked a commercial plane in 1971, got away with this crime","Phrases and Idiom"))
        viewModel.insertWordDetail(Words(0,"Run into","Meet someone/something by change or unexpectedly","-","-","Running into your ex while looking like a complete disaster is some people's worst nightmare","Phrases and Idiom"))


        // list
        viewModel.insertWordDetailList(WordList(0,"Have a mind of your own","To be independent in making decisions","-","-","we tried to persuade him not to resign, but you know that he has a mind of his own, so he did not listen to any of us","Phrases and Idiom"))
        viewModel.insertWordDetailList(WordList(0,"Run into","Meet someone/something by change or unexpectedly","-","-","Running into your ex while looking like a complete disaster is some people's worst nightmare","Phrases and Idiom"))
        viewModel.insertWordDetailList(WordList(0,"Organized","Involving large numbers of people who work together to do something in a way that has been carefully planned","Formed","unorganized","He was part of an organized criminal gang.","Adjective"))
        viewModel.insertWordDetailList(WordList(0,"Rub","To move your hand, a cloth, etc., backwards and forwards over a surface while pressing it","Apply","Reveal","She rubbed her chin thoughtfully.","Adverb"))
        viewModel.insertWordDetailList(WordList(0,"Mostly","Generally","Chiefly","Rarely","We're mostly out on Sundays.","Verb"))
        viewModel.insertWordDetailList(WordList(0,"Abroad"," In or to a foreign country","Away","At home","She worked abroad for a year.","Verb"))
        viewModel.insertWordDetailList(WordList(0,"Able"," Able to do something","Adept","Disinclined","I didn't feel able to disagree with him.","Adjective"))
        viewModel.insertWordDetailList(WordList(0,"Require"," To need something; to depend on somebody/something","Lack","Dislike","Deciphering the code requires an expert.","Adverb"))
        viewModel.insertWordDetailList(WordList(0,"Land","The surface of the earth that is not sea","Dock","Ascend","The new project will reclaim the land from the sea.","Adverb"))
        viewModel.insertWordDetailList(WordList(0,"Set off","Start a journey ","-","-","Let's decide what time we will set off for the airport tomorrow morning","Phrases and Idiom"))

    }
}
