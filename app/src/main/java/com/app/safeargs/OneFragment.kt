package com.app.safeargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class OneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        val safeArgs: OneFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepFragment

        return when(flowStepNumber){
            2 -> inflater.inflate(R.layout.fragment_two, container, false)
            else -> inflater.inflate(R.layout.fragment_one, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btn_1).setOnClickListener {
            findNavController().navigate(R.id.next_action)
        }
    }
}