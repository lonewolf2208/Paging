package com.example.clearcals.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.clearcals.viewmodel.FoodViewModel
import com.example.clearcals.R
import com.example.clearcals.paging.FoodAdapter
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var recyclerview:RecyclerView
    lateinit var adapter: FoodAdapter
    lateinit var viewmodel: FoodViewModel
    companion object
    {
        var word=""
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerview=findViewById(R.id.recylerview)
        adapter= FoodAdapter()
        var progressBar=findViewById<ProgressBar>(R.id.progressBar)
        viewmodel= ViewModelProvider(this)[FoodViewModel::class.java]
        recyclerview.layoutManager = StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
        recyclerview.adapter=adapter
        findViewById<SearchView>(R.id.searchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
               viewmodel.searchdata(p0.toString())
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                viewmodel.searchdata(p0.toString())
                progressBar.visibility= View.VISIBLE
                return false
            }
        })
        viewmodel.data.observe(this, Observer {
//            Toast.makeText(this,, Toast.LENGTH_SHORT).show(
                if (it != null) {
                        progressBar.visibility=View.GONE
                    }

            adapter.notifyDataSetChanged()
            adapter.submitData(lifecycle,it)
        })
    }
}