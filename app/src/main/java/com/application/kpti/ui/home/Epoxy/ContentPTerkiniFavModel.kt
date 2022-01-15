package com.application.kpti.ui.home.Epoxy

import android.content.Context
import android.view.View
import android.view.ViewParent
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.application.kpti.R
import com.application.kpti.databinding.HomeItemPropertyPopulerHorizontalBinding
import com.application.kpti.databinding.HomeItemPropertyTerkiniVerticalBinding
import com.application.kpti.databinding.HomeItemTitlePropertyPopulerBinding
import com.bumptech.glide.Glide


@EpoxyModelClass(layout = R.layout.home_item_property_terkini_vertical_favorite)
abstract class ContentPTerkiniFavModel : EpoxyModelWithHolder<ContentPTerkiniFavModel.ItemPropertyTerkiniHolder>() {

    @field:EpoxyAttribute
    open var ids : Long? = null

    @field:EpoxyAttribute
    open var imgproperty: String? = null

    @field:EpoxyAttribute
    open var propertyname: String? = null

    @field:EpoxyAttribute
    open var location: String? = null

    @field:EpoxyAttribute
    open var price: String? = null

    @field:EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var itemClickListener: View.OnClickListener? = null

    // Bind our data to view
    override fun bind(holder: ItemPropertyTerkiniHolder) {
        holder.binding.apply {
            propertyTerkiniNama.text = propertyname
            propertyTerkiniHarga.text = price
            propertyTerkiniLocation.text = location
            Glide.with(propertyTerkiniImage)
                .load(imgproperty)
                .placeholder(R.drawable.logo_c)
                .fitCenter().centerCrop()
                .into(propertyTerkiniImage)
            root.setOnClickListener(itemClickListener)
        }
    }

    override fun unbind(holder: ItemPropertyTerkiniHolder) {
        holder.binding.root.setOnClickListener(null)
    }

     class ItemPropertyTerkiniHolder: EpoxyHolder() {
        lateinit var binding : HomeItemPropertyTerkiniVerticalBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemPropertyTerkiniVerticalBinding.bind(itemView)
        }
    }
}

