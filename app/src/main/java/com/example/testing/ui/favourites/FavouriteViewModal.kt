package com.example.testing.ui.favourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testing.R
import com.example.testing.model.datamodel.FavouriteRecord
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouriteViewModal : ViewModel() {
//    private val _text = MutableLiveData<String>().apply {
//        value = "Favourite Screen"
//    }
//    val text: LiveData<String> = _text
private var favRecordList: MutableLiveData<List<FavouriteRecord>> = MutableLiveData()

    fun getAllFavRecords(): LiveData<List<FavouriteRecord>>{
        viewModelScope.launch(Dispatchers.IO ){
            val records = arrayListOf<FavouriteRecord>()
            for(i in 1..5){

                    records.add(
                        FavouriteRecord(
                            R.drawable.user,
                            "CS191064",
                            "SQA Engineer" , i%3==0 ))

                favRecordList.postValue(records)
            }
        }
        return favRecordList;
    }
}