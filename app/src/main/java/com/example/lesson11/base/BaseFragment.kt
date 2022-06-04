package com.example.lesson11.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    protected abstract val binding: VB
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        setupReguest()
        setupListener()
    }

    protected open fun setupViews() {}
    protected open fun setupReguest() {}
    protected open fun setupListener() {}
}
