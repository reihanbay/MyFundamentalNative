package com.learn.fundamental.mybackgroundthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.lifecycle.lifecycleScope
import com.learn.fundamental.R
import com.learn.fundamental.databinding.ActivityMyBackgroundThreadBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class MyBackgroundThreadActivity : AppCompatActivity() {
    private var _binding: ActivityMyBackgroundThreadBinding? = null
    private val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMyBackgroundThreadBinding.inflate(LayoutInflater.from(this))
        setContentView(binding?.root)
        val executor = Executors.newSingleThreadExecutor()
        val handler = Handler(Looper.getMainLooper())

        binding?.btnStart?.setOnClickListener {
            lifecycleScope.launch(Dispatchers.Default) {
                for (i in 0..10) {
                    delay(500)
                    val percentage = i * 10
                    withContext(Dispatchers.Main) {
                        if (percentage == 100) {
                            binding?.tvStatus?.text = getString(R.string.task_completed)

                        } else {
                            binding?.tvStatus?.text =
                                String.format(getString(R.string.compressing), percentage)
                        }
                    }
                }
            }
//            executor.execute {
//                try {
//                    for (i in 0..10) {
//                        Thread.sleep(500)
//                        val percentage = i * 10
//                        handler.post{
//                            if (percentage == 100) {
//                                binding?.tvStatus?.text = getString(R.string.task_completed)
//
//                            } else {
//                                binding?.tvStatus?.text =
//                                    String.format(getString(R.string.compressing), percentage)
//                            }
//                        }
//                    }
//                } catch (e: InterruptedException) {
//                    e.printStackTrace()
//                }
//            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}