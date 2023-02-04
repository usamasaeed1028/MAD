package com.example.testing.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModal : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Search Screen"
    }
    val text: LiveData<String> = _text
}