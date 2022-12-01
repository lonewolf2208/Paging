package com.example.clearcals.paging

import android.icu.text.SimpleDateFormat
import android.media.Image
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.clearcals.R
import com.example.clearcals.model.Result
import org.w3c.dom.Text
import java.util.function.LongFunction

class FoodAdapter : PagingDataAdapter<Result,FoodAdapter.ViewHolder>(COMPARATOR) {
    companion object{
        private val COMPARATOR=object: DiffUtil.ItemCallback<Result>()
        {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
               return oldItem==newItem
            }

        }
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
                val food=itemView.findViewById<TextView>(R.id.FoodTitle)
            val image = itemView.findViewById<ImageView>(R.id.thumbnail)
            val createdDate=itemView.findViewById<TextView>(R.id.CreatedDate)
        }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if(item!=null)
        {

            holder.food.text=item.name.toString()
            holder.image.load(item.thumbnail_url)
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            val dateString = simpleDateFormat.format(item.created_at)
            holder.createdDate.text= String.format("%s", dateString)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.food_item,parent,false)
        return ViewHolder(view)
    }
}
