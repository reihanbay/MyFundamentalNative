package com.learn.fundamental.mytesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.learn.fundamental.R
import com.learn.fundamental.databinding.ActivityMyUnitTestingBinding

class MyUnitTestingActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityMyUnitTestingBinding
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyUnitTestingBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mainViewModel = MainViewModel(CuboidModel())

        binding.btnSave.setOnClickListener(this)
        binding.btnCalculateSurfaceArea.setOnClickListener(this)
        binding.btnCalculateCircumference.setOnClickListener(this)
        binding.btnCalculateVolume.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val length = binding.edtLength.text.toString().trim()
        val width = binding.edtWidth.text.toString().trim()
        val height = binding.edtHeight.text.toString().trim()

        when {
            length.isEmpty() -> binding.edtLength.error = "Field ini tidak boleh kosong"
            width.isEmpty() -> binding.edtWidth.error = "Field ini tidak boleh kosong"
            height.isEmpty() -> binding.edtHeight.error = "Field ini tidak boleh kosong"
            else ->{
                val l = length.toDouble()
                val w = width.toDouble()
                val h = height.toDouble()

                when (v?.id) {
                    R.id.btn_save -> {
                        mainViewModel.save(l,w,h)
                        visible()
                    }
                    R.id.btn_calculate_circumference -> {
                        binding.tvResult.text = mainViewModel.getCircumference().toString()
                        gone()
                    }
                    R.id.btn_calculate_surface_area -> {
                        binding.tvResult.text = mainViewModel.getSurfaceArea().toString()
                        gone()
                    }
                    R.id.btn_calculate_volume -> {
                        binding.tvResult.text = mainViewModel.getVolume().toString()
                        gone()
                    }
                }
            }
        }
    }
    private fun visible() {
        binding.btnCalculateVolume.visibility = View.VISIBLE
        binding.btnCalculateCircumference.visibility = View.VISIBLE
        binding.btnCalculateSurfaceArea.visibility = View.VISIBLE
        binding.btnSave.visibility = View.GONE
    }
    private fun gone() {
        binding.btnCalculateVolume.visibility = View.GONE
        binding.btnCalculateCircumference.visibility = View.GONE
        binding.btnCalculateSurfaceArea.visibility = View.GONE
        binding.btnSave.visibility = View.VISIBLE
    }
}