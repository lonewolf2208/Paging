package com.example.clearcals.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.clearcals.model.Result
import com.example.clearcals.retrofit.Api
import java.lang.Exception

class PagingSource(val foodApi:Api, var query :String):PagingSource<Int,Result>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,Result>{
        return try{
            val position=params.key ?:1
            Log.d("ADSasd",position.toString())

              var response= foodApi.getData(position,5,query,"065bc65c47msh70e4ee6f58b9232p1e53efjsnd242f738bc2e","tasty.p.rapidapi.com")

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