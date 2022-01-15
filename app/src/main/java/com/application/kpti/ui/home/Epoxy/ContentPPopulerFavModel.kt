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
import com.application.kpti.databinding.HomeItemTitlePropertyPopulerBinding
import com.bumptech.glide.Glide


@EpoxyModelClass(layout = R.layout.home_item_property_populer_horizontal_favorite)
abstract class ContentPPopulerFavModel : EpoxyModelWithHolder<ContentPPopulerFavModel.ItemPropertyPopulerHolder>() {

    @field:EpoxyAttribute
    open var ids: Long? = null

    @field:EpoxyAttribute
    open var img_property: String? = null

    @field:EpoxyAttribute
    open var property_name: String? = null

    @field:EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var itemClickListener: View.OnClickListener? = null

    // Bind our data to view
    override fun bind(holder: ItemPropertyPopulerHolder) {
        holder.binding.apply {
            populerNamaProperty.text = property_name
            Glide.with(populerImageProperty)
                .load(img_property)
                .placeholder(R.drawable.logo_c)
                .fitCenter().centerCrop()
                .into(populerImageProperty)
            root.setOnClickListener(itemClickListener)
        }
    }

    override fun unbind(holder: ItemPropertyPopulerHolder) {
        holder.binding.root.setOnClickListener(null)
    }

     class ItemPropertyPopulerHolder: EpoxyHolder() {
        lateinit var binding : HomeItemPropertyPopulerHorizontalBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemPropertyPopulerHorizontalBinding.bind(itemView)
        }
    }
}

