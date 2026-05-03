package com.ntambwe.lifehackorurbanmyth

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ntambwe.lifehackorubanmyth.R

/**
 * Review Screen - Shows all questions and correct answers
 */
class ReviewActivity : AppCompatActivity() {

    private val TAG = "ReviewActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        Log.d(TAG, "Review screen loaded")

        val questions = DataSource.getQuestions()
        val reviewText = StringBuilder()

        for ((index, question) in questions.withIndex()) {
            reviewText.append("${index + 1}. ${question.statement}\n")
            reviewText.append("   ${question.explanation}\n\n")
        }

        findViewById<TextView>(R.id.tvReview).text = reviewText.toString()

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            Log.d(TAG, "Back button clicked")
            finish()
        }
    }
}