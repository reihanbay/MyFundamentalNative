package com.learn.fundamental

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.button.MaterialButton
import com.learn.fundamental.customview.MyCustomViewActivity
import com.learn.fundamental.databinding.ActivityMainBinding
import com.learn.fundamental.mybackgroundthread.MyBackgroundThreadActivity
import com.learn.fundamental.myfragment.MyFragmentActivity
import com.learn.fundamental.myintent.MyIntentActivity
import com.learn.fundamental.mylistview.MyListViewActivity
import com.learn.fundamental.mynavigation.MyNavigationActivity
import com.learn.fundamental.myrecyclerview.RecyclerViewActivity
import com.learn.fundamental.mytesting.MyUnitTestingActivity
import com.learn.fundamental.myviewsandviewg.MyViewAndViewGroupActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var binding : ActivityMainBinding? = null
    private val bind get() = binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(bind?.root)

        bind?.btnIntent?.btn?.setOnClickListener(this)
        bind?.btnIntent?.btn?.text = "Intent"
        bind?.btnViewStyle?.btn?.setOnClickListener(this)
        bind?.btnViewStyle?.btn?.text = "ViewAndViewGroup"
        bind?.btnRecycler?.btn?.setOnClickListener(this)
        bind?.btnRecycler?.btn?.text = "RecyclerView"
        bind?.btnFragment?.btn?.setOnClickListener(this)
        bind?.btnFragment?.btn?.text = "Fragment"
        bind?.btnListView?.btn?.setOnClickListener(this)
        bind?.btnListView?.btn?.text = "List View"
        bind?.btnTesting?.btn?.setOnClickListener(this)
        bind?.btnTesting?.btn?.text = "Testing"
        bind?.btnCustomview?.btn?.setOnClickListener(this)
        bind?.btnCustomview?.btn?.text = "Custom View"
        bind?.btnNavigationComponent?.btn?.setOnClickListener(this)
        bind?.btnNavigationComponent?.btn?.text = "Navigation Component"
        bind?.btnBackgroundThread?.btn?.setOnClickListener(this)
        bind?.btnBackgroundThread?.btn?.text = "BackgroundThread"
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_view_style -> startActivity(Intent(this@MainActivity, MyViewAndViewGroupActivity::class.java))
            R.id.btn_intent -> startActivity(Intent(this@MainActivity, MyIntentActivity::class.java))
            R.id.btn_recycler -> startActivity(Intent(this@MainActivity, RecyclerViewActivity::class.java))
            R.id.btn_fragment -> startActivity(Intent(this@MainActivity, MyFragmentActivity::class.java))
            R.id.btn_list_view -> startActivity(Intent(this@MainActivity, MyListViewActivity::class.java))
            R.id.btn_testing -> startActivity(Intent(this@MainActivity, MyUnitTestingActivity::class.java))
            R.id.btn_customview -> startActivity(Intent(this@MainActivity, MyCustomViewActivity::class.java))
            R.id.btn_background_thread -> startActivity(Intent(this@MainActivity, MyBackgroundThreadActivity::class.java))
        }
    }
}