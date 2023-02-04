package com.example.testing.ui.search

import android.media.tv.AdResponse
import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.MyAdapter
import com.example.testing.MyDataItem
import com.example.testing.databinding.FragmentAddrecordBinding
import com.example.testing.databinding.FragmentSearchBinding
import com.example.testing.ui.addRecord.AddRecordViewModal
import javax.security.auth.callback.Callback

class SearchFragment: Fragment() {

    lateinit var myAdapter: MyAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.fragment_search)

        recyclerview_users.setHasFixedSize(true)
        LinearLayoutManager = LinearLayoutManager (context:this)
        recyclerview_users.LayoutManager = LinearLayoutManager

        getMyData();
    }

    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
            .addConvertorFactory(GsonConvertorFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/posts")
            .build()
            .create(AppInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse (call: Call<list<MyDataItem>?>, response: Response<List<MyDataItem>?>){

                val responseBody = response.Body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_users.adapters = myAdapter
            }

        })

    }
}