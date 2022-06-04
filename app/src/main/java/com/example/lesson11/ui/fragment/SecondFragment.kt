package com.example.lesson11.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lesson11.base.BaseFragment
import com.example.lesson11.databinding.FragmentSecondBinding


class SecondFragment : BaseFragment<FragmentSecondBinding>() {
    override lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun setupListener() {
        binding.btn.setOnClickListener {
            findNavController().navigate(
                SecondFragmentDirections.actionSecondFragmentToMainFragment(
                    binding.editSecond.text.toString(), binding.editSecond.text.toString()
                )
            )
        }
    }
}