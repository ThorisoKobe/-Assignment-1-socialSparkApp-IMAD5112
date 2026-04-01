package com.example.socialsparkapp

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Connect XML layout to Kotlin
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.timeInput)
        val result = findViewById<TextView>(R.id.resultText)
        val suggestBtn = findViewById<Button>(R.id.btnSuggest)
        val resetBtn = findViewById<Button>(R.id.btnReset)

        suggestBtn.setOnClickListener {

            val userInput = input.text.toString().trim().lowercase()
            Log.d("USER_INPUT", "User entered: $userInput")

            val suggestion = when (userInput) {

                "morning" ->
                    "Send a 'Good morning' text to a family member ☀️"

                "mid-morning" ->
                    "Reach out to a colleague with a quick 'Thank you' 🙌"

                "afternoon" ->
                    "Share a funny meme or link with a friend 😂"

                "afternoon snack", "snack time" ->
                    "Send a quick 'thinking of you' message 💛"

                "dinner" ->
                    "Call a friend or relative for 5 minutes 📞"

                "night", "after dinner" ->
                    "Leave a thoughtful comment on a friend's post 🌙"

                else -> {
                    Log.e("INPUT_ERROR", "Invalid input")
                    "⚠️ Invalid input! Try: Morning, Afternoon, Dinner, Night."
                }
            }

            result.text = suggestion
        }

        resetBtn.setOnClickListener {
            input.text.clear()
            result.text = "Suggestion appears here"
            Log.d("RESET", "User reset the app")
        }
    }
}