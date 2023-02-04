package com.example.testing.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingViewModal : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Settings Screen"
    }
    val text: LiveData<String> = _text
}