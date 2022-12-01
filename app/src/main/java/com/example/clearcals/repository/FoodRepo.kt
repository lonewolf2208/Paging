package com.example.clearcals.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.clearcals.retrofit.Api
import javax.inject.Inject

class FoodRepo @Inject constructor(val food : Api) {

    fun getData(query:String)= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {com.example.clearcals.paging.PagingSource(food,query)}
    ).liveData

}