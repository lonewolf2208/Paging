package com.example.clearcals.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.clearcals.repository.FoodRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor( foodrepo:FoodRepo):ViewModel(){
    private val currentQuery=MutableLiveData<String>("")
    fun searchdata(query:String)
    {
        currentQuery.value=query
    }
    val data=currentQuery.switchMap {
        foodrepo.getData(it).cachedIn(viewModelScope)
    }
}