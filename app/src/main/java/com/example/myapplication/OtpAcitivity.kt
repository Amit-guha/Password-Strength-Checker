package com.example.myapplication

import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//https://github.com/aabhasr1/OtpView


class OtpAcitivity : AppCompatActivity() {
    private lateinit var otpTextView: OtpTextView
    private lateinit var btn_error: Button
    private lateinit var btn_success:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp_acitivity)

        otpTextView=findViewById(R.id.otp_view)
        btn_error=findViewById(R.id.btn_error)
        btn_success=findViewById(R.id.btn_successs)

        btn_error.setOnClickListener {
            otpTextView.showError()
        }

        btn_success.setOnClickListener {
            otpTextView.showSuccess()
        }

        otpTextView.otpListener = object : OTPListener {
            override fun onInteractionListener() {
                // fired when user types something in the Otpbox
                otpTextView.requestFocusOTP()
                otpTextView.getOTP()
               // otpTextView.showSuccess()
                Toast.makeText(this@OtpAcitivity,otpTextView.otp,Toast.LENGTH_SHORT).show()
            }

            override fun onOTPComplete(otp: String) {
                // fired when user has entered the OTP fully.
               // otpTextView.showSuccess()
                Toast.makeText(this@OtpAcitivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        }
    }
}