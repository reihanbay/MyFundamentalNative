package com.learn.fundamental.myfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.learn.fundamental.R
import com.learn.fundamental.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_detail_category) {
            val mDetailCategoryFragment = DetailCategoryFragment()

            //menggunakan Bundle argument
            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "LifeStyle")
            val desc = "Kategory ini akan berisi produk produk lifestyle"

            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = desc

            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mDetailCategoryFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

}