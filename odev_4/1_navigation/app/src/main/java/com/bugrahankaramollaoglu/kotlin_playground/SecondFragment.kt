package com.bugrahankaramollaoglu.kotlin_playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bugrahankaramollaoglu.kotlin_playground.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private var myAge = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let{
            myAge = SecondFragmentArgs.fromBundle(it).age
            println(myAge)
        }

        binding.secondButton.setOnClickListener {

            val action = SecondFragmentDirections.actionSecondFragmentToFirstFragment()
            it.findNavController().navigate(action)

        }

    }

}

