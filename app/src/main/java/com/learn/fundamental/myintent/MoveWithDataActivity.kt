package com.learn.fundamental.myintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.learn.fundamental.R

class MoveWithDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val data = intent.getStringExtra("PASSING")
        val texts = findViewById<TextView>(R.id.tv_received)
        texts.text = data.toString()
    }
}