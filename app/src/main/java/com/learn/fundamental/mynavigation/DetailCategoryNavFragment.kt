package com.learn.fundamental.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.learn.fundamental.R
import com.learn.fundamental.databinding.FragmentDetailCategoryNavBinding

class DetailCategoryNavFragment : Fragment() {

    private var binding : FragmentDetailCategoryNavBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailCategoryNavBinding.inflate(inflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataName = DetailCategoryNavFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDesc = DetailCategoryNavFragmentArgs.fromBundle(arguments as Bundle).stock


        binding?.tvCategoryName?.text = dataName
        binding?.tvCategoryDescription?.text = "Stock: $dataDesc"
        binding?.btnProfile?.setOnClickListener {
            findNavController().navigate(R.id.action_detailCategoryNavFragment_to_homeNavFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}