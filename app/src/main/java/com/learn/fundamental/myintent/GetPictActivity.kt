package com.learn.fundamental.myintent

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.learn.fundamental.databinding.ActivityGetPictBinding

class GetPictActivity : AppCompatActivity() {
    private var binding : ActivityGetPictBinding? = null
    private val bind get() = binding

    companion object {
        const val result = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetPictBinding.inflate(LayoutInflater.from(this))
        setContentView(bind?.root)
        bind?.btnGet?.setOnClickListener {
            val pick = Intent(Intent.ACTION_PICK)
            pick.type = "image/*"
            startActivityForResult(
                Intent.createChooser(
                    pick,
                    "Select Picture"
                ), result)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == result) {
            val pict = data?.data
            Glide.with(this).load(pict).into(bind!!.ivPhoto)
            Toast.makeText(this, "Tadaa", Toast.LENGTH_SHORT).show()
        }
    }
}