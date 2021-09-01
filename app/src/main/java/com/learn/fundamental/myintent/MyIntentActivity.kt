package com.learn.fundamental.myintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.learn.fundamental.R

class MyIntentActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var moveActivity : MaterialButton
    lateinit var moveActivityWithData : MaterialButton
    lateinit var dialNum : MaterialButton
    lateinit var pickPict : MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_intent)

        moveActivity = findViewById(R.id.btn_move_activity)
        moveActivity.text = getString(R.string.move_activity)
        moveActivity.setOnClickListener(this)

        moveActivityWithData = findViewById(R.id.btn_move_activity_with_data)
        moveActivityWithData.text = getString(R.string.move_with_data)
        moveActivityWithData.setOnClickListener(this)

        dialNum = findViewById(R.id.btn_dial_number)
        dialNum.text = getString(R.string.dial_number)
        dialNum.setOnClickListener(this)

        pickPict = findViewById(R.id.btn_pict)
        pickPict.text = getString(R.string.result_activity)
        pickPict.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_move_activity -> {
                startActivity(Intent(this, MoveActivity::class.java))
            }
            R.id.btn_move_activity_with_data -> {
                val intent = Intent(this, MoveWithDataActivity::class.java)
                intent.putExtra("PASSING", "Halo han")
                startActivity(intent)
            }
            R.id.btn_dial_number -> {
                val phone = "081229377348"
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                startActivity(intent)
            }

            R.id.btn_pict -> {
                val intent = Intent(this, GetPictActivity::class.java)
                startActivity(intent)
            }
        }
    }
}