package com.learn.fundamental.myfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.fundamental.R
import com.learn.fundamental.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_category) {
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = fragmentManager
            mFragmentManager?.beginTransaction()?.apply {
                replace(R.id.frame_container, mCategoryFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

}