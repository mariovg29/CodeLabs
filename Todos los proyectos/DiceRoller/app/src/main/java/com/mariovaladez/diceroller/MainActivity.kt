package com.mariovaladez.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(20)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        // Update the screen with the dice roll
        val resultText: TextView = findViewById(R.id.textView)
        resultText.text = diceRoll.toString()
        val resultText2: TextView = findViewById(R.id.textView2)
        resultText2.text = diceRoll2.toString()

    }
}

class Dice(private val numSides: Int) {
    enum class Color {
        BLUE, RED, BLACK, WHITE
    }

    fun color(): Color {
        return Color.values().random()
    }

    fun roll(): Int {
        return (1..numSides).random()
    }
}