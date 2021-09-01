package com.learn.fundamental.myfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.learn.fundamental.R
import com.learn.fundamental.databinding.FragmentOptionDialogBinding

class OptionDialogFragment : DialogFragment() {

    private lateinit var binding : FragmentOptionDialogBinding

    private var optionDialogListener : OnOptionDialogListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOptionDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnChoose.setOnClickListener{
            val checkedRadioButtonId = binding.rgOptions.checkedRadioButtonId
            if(checkedRadioButtonId != -1) {
                var coach : String? = null
                when(checkedRadioButtonId) {
                    R.id.rb_saf -> coach = binding.rbSaf.text.toString().trim()
                    R.id.rb_mou -> coach = binding.rbMou.text.toString().trim()
                    R.id.rb_lvg -> coach = binding.rbLvg.text.toString().trim()
                    R.id.rb_moyes -> coach = binding.rbMoyes.text.toString().trim()
                }
                optionDialogListener?.onOptionChosen(coach)
                dialog?.dismiss()
            }
        }
        binding.btnClose.setOnClickListener {
            dialog?.cancel()
        }
    }
    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment
        if (fragment is DetailCategoryFragment) {
            this.optionDialogListener = fragment.optionDialogListener
        }
    }

    override fun onDetach() {
        super.onDetach()
        this.optionDialogListener = null
    }

}