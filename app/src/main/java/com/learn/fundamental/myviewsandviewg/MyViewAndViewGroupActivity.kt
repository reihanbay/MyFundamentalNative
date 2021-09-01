package com.learn.fundamental.myviewsandviewg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.learn.fundamental.R

class MyViewAndViewGroupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_view_and_view_group)

        supportActionBar?.title = "Google Pixel"
    }
}