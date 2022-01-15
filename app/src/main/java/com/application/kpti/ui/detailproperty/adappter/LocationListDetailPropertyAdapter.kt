package com.application.kpti.ui.detailproperty.adappter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.R
import com.application.kpti.databinding.DetailItemPropertyHorizontalBinding
import com.application.kpti.databinding.LocationItemRecentlyBinding
import com.application.kpti.ui.detailproperty.model.Data
import com.application.kpti.ui.detailproperty.model.ListDataProperty
import com.application.kpti.ui.location.model.Recently
import com.bumptech.glide.Glide

/**
 Contact Adapter using Recycler View
 **/

class LocationListDetailPropertyAdapter(val context: Context, val dataDetailProperties:List<Data>, val onItemClickListener : OnItemClickListener): RecyclerView.Adapter<LocationListDetailPropertyAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DetailItemPropertyHorizontalBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return dataDetailProperties.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder){
            with(dataDetailProperties[position]){
                Glide.with(binding.detailImgProperty)
                    .load(property_image)
                    .placeholder(R.drawable.logo_c)
                    .fitCenter().centerCrop()
                    .into(binding.detailImgProperty)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemDetailPropertyClick(listdataproperty : Data)
    }

    inner class Holder(val binding: DetailItemPropertyHorizontalBinding):RecyclerView.ViewHolder(binding.root)

}