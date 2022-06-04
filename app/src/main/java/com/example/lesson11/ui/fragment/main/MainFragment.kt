package com.example.lesson11.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.lesson11.R
import com.example.lesson11.base.BaseFragment
import com.example.lesson11.databinding.FragmentMainBinding
import com.example.lesson11.model.Model
import com.example.lesson11.ui.adaptrers.RecyclerAdapter
import com.example.lesson11.ui.click.ItemClick


class MainFragment : BaseFragment<FragmentMainBinding>() {

    override lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = RecyclerAdapter()
    private val args: MainFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        return binding.root
    }

    private fun getDataFromSecondFragment() {
        viewModel.list.add(Model(args.name, args.name))
    }

    override fun setupListener() {
        itemClickListener()
    }

    private fun itemClickListener() {
        adapter.onItemClickListener(object : ItemClick {
            override fun onItemClickListener(model: Model) {
                findNavController().navigate(R.id.secondFragment)
            }
        })
    }

    override fun setupViews() {
        binding.recycler.adapter = adapter
    }

    override fun setupReguest() {
        viewModel.createData()
        viewModel.liveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
        getDataFromSecondFragment()
    }
}