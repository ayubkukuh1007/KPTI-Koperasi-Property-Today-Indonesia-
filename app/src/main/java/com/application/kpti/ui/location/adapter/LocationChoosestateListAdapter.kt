package com.application.kpti.ui.location.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.databinding.LocationItemChooseStateBinding
import com.application.kpti.databinding.LocationItemRecentlyBinding
import com.application.kpti.ui.location.model.ChooseState
import com.application.kpti.ui.location.model.Recently

/**
 Contact Adapter using Recycler View
 **/

class LocationChoosestateListAdapter(val context: Context, val location:List<ChooseState>, val onItemClickListener : OnItemClickListener): RecyclerView.Adapter<LocationChoosestateListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = LocationItemChooseStateBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return location.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder){
            with(location[position]){
                binding.choosestateLocation.text = location_name
                binding.constChoosestateLocation.setOnClickListener {
                    onItemClickListener.onItemChoosestateClick(location = location[position])
                }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemChoosestateClick(location: ChooseState)
    }

    inner class Holder(val binding: LocationItemChooseStateBinding):RecyclerView.ViewHolder(binding.root)

}