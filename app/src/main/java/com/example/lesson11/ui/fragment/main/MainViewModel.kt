package com.example.lesson11.ui.fragment.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson11.model.Model

class MainViewModel : ViewModel() {

    val liveData = MutableLiveData<ArrayList<Model>>()
    val list = ArrayList<Model>()

    fun createData() {
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        list.add(Model("von", "von"))
        liveData.value = list
    }
}