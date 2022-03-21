package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer

/*
Created By
Amit Kumar Guha
Software Engineer,TVL
21-03-22

 */

class MainActivity : AppCompatActivity() {
    private lateinit var Et_PasswordInput : EditText
    private lateinit var tv_passwordStrength : TextView
    private lateinit var strength_level_indicator : View

    private var color: Int = R.color.weak

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Et_PasswordInput=findViewById(R.id.Et_PasswordInput)
        tv_passwordStrength=findViewById(R.id.tv_passwordStrength)
        strength_level_indicator=findViewById(R.id.strength_level_indicator)

        val passwordStrengthCalculator = PasswordStrengthCalculator()
        Et_PasswordInput.addTextChangedListener(passwordStrengthCalculator)

        // Observers
        passwordStrengthCalculator.strengthLevel.observe(this, Observer {strengthLevel ->
            displayStrengthLevel(strengthLevel)
        })
        passwordStrengthCalculator.strengthColor.observe(this, Observer {strengthColor ->
            color = strengthColor
        })
    }

    private fun displayStrengthLevel(strengthLevel: StrengthLevel) {

        tv_passwordStrength.text = strengthLevel.name
        tv_passwordStrength.setTextColor(ContextCompat.getColor(this, color))
        strength_level_indicator.setBackgroundColor(ContextCompat.getColor(this, color))

    }
}