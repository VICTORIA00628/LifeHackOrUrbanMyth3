package com.ntambwe.lifehackorurbanmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ntambwe.lifehackorubanmyth.R


/**
 * Welcome Screen - Entry point of the app
 */
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Welcome screen loaded")

        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener {
            Log.d(TAG, "Start button clicked")
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }
    }
}