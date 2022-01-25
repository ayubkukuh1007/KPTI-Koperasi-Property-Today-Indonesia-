package com.application.kpti.ui.profil.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.R
import com.application.kpti.databinding.LocationItemRecentlyBinding
import com.application.kpti.databinding.ProfileInfoItemBinding
import com.application.kpti.ui.location.model.Recently
import com.application.kpti.ui.profil.model.ProfilInfoItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 Contact Adapter using Recycler View
 **/

class InfoListAdapter(val context: Context, val infos:List<ProfilInfoItem>, val onItemClickListener : OnItemClickListener): RecyclerView.Adapter<InfoListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ProfileInfoItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return infos.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder){
            with(infos[position]){
                binding.infoDate.text = date
                binding.infoDec.text = decription
                Glide.with(binding.infoImgPropery)
                    .load(img_info)
                    .apply(RequestOptions.bitmapTransform( RoundedCorners(5)))
                    .placeholder(R.drawable.info_property)
                    .fitCenter().centerCrop()
                    .into(binding.infoImgPropery)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemInfoClick(location: Recently)
    }

    inner class Holder(val binding: ProfileInfoItemBinding):RecyclerView.ViewHolder(binding.root)

}