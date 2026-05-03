package com.ntambwe.lifehackorurbanmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ntambwe.lifehackorubanmyth.R

/**
 * Flashcard Question Screen
 */
class QuestionActivity : AppCompatActivity() {

    private val TAG = "QuestionActivity"
    private var questionList = listOf<Flashcard>()
    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionList = DataSource.getQuestions()
        Log.d(TAG, "Loaded ${questionList.size} questions")

        displayQuestion()

        findViewById<Button>(R.id.btnHack).setOnClickListener {
            if (!answered) checkAnswer(true)
        }

        findViewById<Button>(R.id.btnMyth).setOnClickListener {
            if (!answered) checkAnswer(false)
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            currentIndex++
            if (currentIndex < questionList.size) {
                displayQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", questionList.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun displayQuestion() {
        answered = false
        findViewById<Button>(R.id.btnNext).visibility = View.GONE
        findViewById<TextView>(R.id.tvFeedback).visibility = View.GONE
        findViewById<Button>(R.id.btnHack).isEnabled = true
        findViewById<Button>(R.id.btnMyth).isEnabled = true
        val current = questionList[currentIndex]
        findViewById<TextView>(R.id.tvQuestion).text = current.statement
        findViewById<TextView>(R.id.tvProgress).text = "Question ${currentIndex + 1} of ${questionList.size}"
        Log.d(TAG, "Question ${currentIndex + 1}")
    }

    private fun checkAnswer(userAnswerIsHack: Boolean) {
        answered = true
        val current = questionList[currentIndex]
        val isCorrect = userAnswerIsHack == current.isHack
        val feedback = findViewById<TextView>(R.id.tvFeedback)
        if (isCorrect) {
            score++
            feedback.text = "Correct! That's a real time-saver!"
        } else {
            feedback.text = "Wrong! That's just an urban myth."
        }
        Log.d(TAG, "Answer: ${if (isCorrect) "Correct" else "Wrong"} Score: $score")
        feedback.visibility = View.VISIBLE
        findViewById<Button>(R.id.btnNext).visibility = View.VISIBLE
        findViewById<Button>(R.id.btnHack).isEnabled = false
        findViewById<Button>(R.id.btnMyth).isEnabled = false
    }
}