package com.application.kpti.ui.location.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.databinding.LocationItemRecentlyBinding
import com.application.kpti.ui.location.model.Recently

/**
 Contact Adapter using Recycler View
 **/

class LocationRecentlyListAdapter(val context: Context, val location:List<Recently>, val onItemClickListener : OnItemClickListener): RecyclerView.Adapter<LocationRecentlyListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = LocationItemRecentlyBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return location.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder){
            with(location[position]){
                binding.recentlyLocation.text = location_name
                binding.constRecentlyLocation.setOnClickListener {
                    onItemClickListener.onItemRecentlyClick(location = location[position])
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemRecentlyClick(location: Recently)
    }

    inner class Holder(val binding: LocationItemRecentlyBinding):RecyclerView.ViewHolder(binding.root)

}