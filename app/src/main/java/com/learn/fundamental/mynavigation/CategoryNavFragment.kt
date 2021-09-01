package com.learn.fundamental.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.learn.fundamental.R
import com.learn.fundamental.databinding.FragmentCategoryNavBinding

class CategoryNavFragment : Fragment() {

    private var binding : FragmentCategoryNavBinding? = null

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_STOCK = "extra_stock"

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryNavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnCategoryLifestyle?.setOnClickListener{
            val toDetailCategoryNavFragment = CategoryNavFragmentDirections.actionCategoryNavFragmentToDetailCategoryNavFragment()
            toDetailCategoryNavFragment.name = "Lifestyle"
            toDetailCategoryNavFragment.stock = 7
            view.findNavController()
                .navigate(toDetailCategoryNavFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null

    }



}