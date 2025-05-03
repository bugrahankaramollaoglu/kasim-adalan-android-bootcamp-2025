package com.bugrahankaramollaoglu.kotlin_playground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.bugrahankaramollaoglu.kotlin_playground.databinding.FragmentFirstBinding
import androidx.navigation.findNavController


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstButton.setOnClickListener {

            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(age = 24)
            it.findNavController().navigate(action)

        }
    }
}