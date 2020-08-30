package com.example.yelpcamp.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.yelpcamp.R
import com.example.yelpcamp.models.model
import kotlinx.android.synthetic.main.activity_list_item.view.*

class CampsAdapter(val campList: List<model>) :RecyclerView.Adapter<CampsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return campList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = campList[position]
        holder.bind(currentItem)
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.image_view
        val name: TextView = itemView.name_text
        val description = itemView.description_text

        fun bind(exampleItem: model){
            name.setText(exampleItem.name)
            description.setText(exampleItem.description)

//          Glide default setting
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(exampleItem.image)
                .into(imageView)
        }


    }
}