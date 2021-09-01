package com.learn.fundamental.myservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.learn.fundamental.R
import com.learn.fundamental.databinding.ActivityMyServiceBinding

class MyServiceActivity : AppCompatActivity() {
    private var binding : ActivityMyServiceBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyServiceBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)
        binding?.btnStartService?.setOnClickListener {
            val mStartServiceIntent = Intent(this, MyService::class.java)
            startService(mStartServiceIntent)
        }

        binding?.btnStartJobIntentService?.setOnClickListener {

        }

        binding?.btnStartBoundService?.setOnClickListener {

        }

        binding?.btnStopBoundService?.setOnClickListener {

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}