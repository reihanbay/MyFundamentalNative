package com.learn.fundamental.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Toast
import com.learn.fundamental.R
import com.learn.fundamental.databinding.ActivityMyCustomViewBinding

class MyCustomViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMyCustomViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyCustomViewBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setMyButtonEnable()

        binding.myEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        binding.myBtn.setOnClickListener { Toast.makeText(this@MyCustomViewActivity, binding.myEditText.text, Toast.LENGTH_SHORT).show() }
    }


    private fun setMyButtonEnable() {
        val result = binding.myEditText.text
        binding.myBtn.isEnabled = !result.isNullOrEmpty()
    }
}