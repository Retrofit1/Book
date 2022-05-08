package com.example.novel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class BookViewModel: ViewModel() {
    val bookLiveData=MutableLiveData<List<Book>>()
    fun getBookList()
    {
        viewModelScope.launch (Dispatchers.IO){
            val response=NovelNetWork.getBookList()
            bookLiveData.postValue(response.data)
        }
    }
}