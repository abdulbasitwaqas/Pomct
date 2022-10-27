package com.pomct.pomct

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.pomct.pomct.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.firstOtp.addTextChangedListener(GenericTextWatcher(binding.firstOtp, binding.secondOtp))
        binding.secondOtp.addTextChangedListener(GenericTextWatcher(binding.secondOtp, binding.thirdOtp))
        binding.thirdOtp.addTextChangedListener(GenericTextWatcher(binding.thirdOtp, binding.forthOtp))
        binding.forthOtp.addTextChangedListener(GenericTextWatcher(binding.forthOtp, null))

        binding.firstOtp.setOnKeyListener(GenericKeyEvent(binding.firstOtp, null))
        binding.secondOtp.setOnKeyListener(GenericKeyEvent(binding.secondOtp, binding.firstOtp))
        binding.thirdOtp.setOnKeyListener(GenericKeyEvent(binding.thirdOtp, binding.secondOtp))
        binding.forthOtp.setOnKeyListener(GenericKeyEvent(binding.forthOtp,binding.thirdOtp))
        binding.verifyIv.setOnClickListener(View.OnClickListener {
            val Intent =Intent(this@OtpActivity, NewpasswordActivity::class.java)
            startActivity(Intent)
        })
   /*     if (binding.resendTv.text.equals("Resend code")){
            binding.resendTv.setOnClickListener {
                object : CountDownTimer(30000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        binding.resendTv.text = "Resend code in " + millisUntilFinished / 1000
                        // logic to set the EditText could go here
                    }

                    override fun onFinish() {
                        binding.resendTv.setText("Resend code")
                    }
                }.start()
            }

        } else {*/
            object : CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    binding.resendTv.text = "Resend code in " + millisUntilFinished / 1000
                    // logic to set the EditText could go here
                }

                override fun onFinish() {
                    binding.resendTv.setText("Resend code")
                    binding.resendTv.setOnClickListener {
                        object : CountDownTimer(30000, 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                binding.resendTv.text = "Resend code in " + millisUntilFinished / 1000
                                // logic to set the EditText could go here
                            }

                            override fun onFinish() {
                                binding.resendTv.setText("Somthing went wrong, please try again.")
                            }
                        }.start()
                    }
                }
            }.start()
//        }
    }
    class GenericKeyEvent internal constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener{
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if(event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.first_otp && currentView.text.isEmpty()) {
                //If current is empty then previous EditText's number will also be deleted
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }


    }

    class GenericTextWatcher internal constructor(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) { // TODO Auto-generated method stub
            val text = editable.toString()
            when (currentView.id) {
                R.id.first_otp -> if (text.length == 1) nextView!!.requestFocus()
                R.id.second_otp -> if (text.length == 1) nextView!!.requestFocus()
                R.id.third_otp -> if (text.length == 1) nextView!!.requestFocus()

                //You can use EditText4 same as above to hide the keyboard
            }
        }

        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) {
        }

        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) {
        }

    }
}