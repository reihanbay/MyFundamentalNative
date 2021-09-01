package com.learn.fundamental.mynavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.learn.fundamental.R
import com.learn.fundamental.databinding.FragmentHomeNavBinding


class HomeNavFragment : Fragment() {

    private var binding : FragmentHomeNavBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeNavBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.btnCategory?.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeNavFragment_to_categoryNavFragment))
        binding?.btnProfile?.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeNavFragment_to_profileActivity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}