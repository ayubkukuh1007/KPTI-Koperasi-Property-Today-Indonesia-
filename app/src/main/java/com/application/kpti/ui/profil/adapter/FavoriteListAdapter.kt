package com.application.kpti.ui.profil.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.R
import com.application.kpti.databinding.LocationItemRecentlyBinding
import com.application.kpti.databinding.ProfileFavoriteItemBinding
import com.application.kpti.databinding.ProfileInfoItemBinding
import com.application.kpti.ui.location.model.Recently
import com.application.kpti.ui.profil.model.ProfilInfoItem
import com.application.kpti.ui.profil.pages.favorite.model.ListFavoriteItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 Contact Adapter using Recycler View
 **/

class FavoriteListAdapter(val context: Context, val favorites:List<ListFavoriteItem>): RecyclerView.Adapter<FavoriteListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ProfileFavoriteItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        with(holder){
            with(favorites[position]){
                binding.propertyName.text = favorite_property
                binding.price.text = "Rp. $price"
                Glide.with(binding.imgProperty)
                    .load(img_property)
                    .apply(RequestOptions.bitmapTransform( RoundedCorners(5)))
                    .placeholder(R.drawable.info_property)
                    .fitCenter().centerCrop()
                    .into(binding.imgProperty)
            }
        }
    }

    inner class Holder(val binding: ProfileFavoriteItemBinding):RecyclerView.ViewHolder(binding.root)

}