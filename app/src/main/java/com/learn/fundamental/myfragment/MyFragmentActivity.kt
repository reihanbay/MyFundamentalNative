package com.learn.fundamental.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.learn.fundamental.R
import com.learn.fundamental.databinding.ActivityMyFragmentBinding

class MyFragmentActivity : AppCompatActivity() {
    private var binding : ActivityMyFragmentBinding? = null
    private val bind get() = binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyFragmentBinding.inflate(LayoutInflater.from(this))
        setContentView(bind?.root)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if(fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment Name: " + HomeFragment::class.java.simpleName)
            mFragmentManager
                .beginTransaction()
                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }
    }
}