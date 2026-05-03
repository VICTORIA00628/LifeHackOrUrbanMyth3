package com.ntambwe.lifehackorurbanmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ntambwe.lifehackorubanmyth.R

/**
 * Score Screen - Displays final score and personalised feedback
 */
class ScoreActivity : AppCompatActivity() {

    private val TAG = "ScoreActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 10)

        Log.d(TAG, "Score: $score/$total")

        findViewById<TextView>(R.id.tvScore).text = "Your Score: $score / $total"

        val feedback = when {
            score >= 8 -> "Master Hacker! You know your stuff!"
            score >= 5 -> "Not bad! Keep learning those hacks!"
            else -> "Stay Safe Online! You need more practice!"
        }
        findViewById<TextView>(R.id.tvFeedback).text = feedback
        Log.d(TAG, "Feedback: $feedback")

        findViewById<Button>(R.id.btnReview).setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }

        findViewById<Button>(R.id.btnPlayAgain).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}