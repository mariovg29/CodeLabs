package com.mariovaladez.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mariovaladez.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }

    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        if(cost == null || cost == 0.0){
            displayTip(0.0)

            return
        }
        val tipPercentage = when(binding.rgTipOptions.checkedRadioButtonId){
            R.id.rb_option_Twenty_percent->.20
            R.id.rb_option_eighteen_percent->.18
            else ->.15
        }
        var tip= cost * tipPercentage

        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
            displayTip(tip)
        }

    }
    private fun displayTip(tip : Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}