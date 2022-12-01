package com.example.clearcals.paging

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.clearcals.MainActivity
import com.example.clearcals.Response
import com.example.clearcals.model.FoodData
import com.example.clearcals.model.Result
import com.example.clearcals.retrofit.Api
import retrofit2.Call
import retrofit2.Callback
import java.lang.Exception

class PagingSource(val foodApi:Api, var query :String):PagingSource<Int,Result>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,Result>{
        return try{
            val position=params.key ?:1
            Log.d("ADSasd",position.toString())

              var response= foodApi.getData(position,5,query,"aeeefa3393msh440179d43d76886p1ace70jsnffeef512a4bf","tasty.p.rapidapi.com")

             LoadResult.Page(
                data = response.results,
                prevKey = if(position<=1) null else position-20,
                nextKey = if(position>=response.count) null else position+20
            )
        } catch (e:Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int,Result>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}