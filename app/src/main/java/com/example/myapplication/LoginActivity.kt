package com.example.myapplication

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButtonToggleGroup

class LoginActivity : AppCompatActivity() {
    private lateinit var toggleGroup: MaterialButtonToggleGroup
    private lateinit var btn_Email: Button
    private lateinit var btn_Phone: Button
    private lateinit var et_email: EditText
    private lateinit var tv_email: TextView
    private lateinit var et_Password: EditText
    private var passwordNotvisible: Int = 1
    private lateinit var imgView: ImageView

    //MaterialComponents.DayNight.NoActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Statusebar()

        toggleGroup = findViewById(R.id.toggle_group)
        btn_Email = findViewById(R.id.btn_email)
        btn_Phone = findViewById(R.id.btn_phoneNo)
        et_email = findViewById(R.id.et_email)
        tv_email = findViewById(R.id.tv_NameofEmail)
        imgView = findViewById(R.id.img_Password)
        et_Password = findViewById(R.id.Et_password)


        toggleGroup.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (checkedId == R.id.btn_phoneNo && isChecked) {
                btn_Phone.setTextColor(ContextCompat.getColor(this, R.color.backbutton_color))
                btn_Email.setTextColor(ContextCompat.getColor(this, R.color.graydark))
                collectData()
            }



            if (checkedId == R.id.btn_email && isChecked) {
                btn_Email.setTextColor(ContextCompat.getColor(this, R.color.backbutton_color))
                btn_Phone.setTextColor(ContextCompat.getColor(this, R.color.graydark))
                collectData2()
            }
        }
    }

    //For Satus bar color
    private fun Statusebar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = resources.getColor(R.color.black, this.theme)

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = resources.getColor(R.color.black)
        }
    }

    private fun collectData2() {
        tv_email.setText("Email")
        et_email.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        et_email.hint = "amitguho95@gmail.com"
        et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(
            R.drawable.ic_baseline_email,
            0,
            0,
            0
        )
    }

    private fun collectData() {
        tv_email.setText("Phone Number")
        et_email.hint = "01734229096"
        et_email.inputType = InputType.TYPE_CLASS_PHONE
        et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(
            R.drawable.ic_baseline_local_phone,
            0,
            0,
            0
        )
    }

    fun ShowHidePassWord(view: View) {
        if (view.id == R.id.img_Password) {
            if (et_Password.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                imgView.setImageResource(R.drawable.ic_baseline_remove_red_eye)
                et_Password.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                imgView.setImageResource(R.drawable.ic_baseline_visibility_off)
                et_Password.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }


}