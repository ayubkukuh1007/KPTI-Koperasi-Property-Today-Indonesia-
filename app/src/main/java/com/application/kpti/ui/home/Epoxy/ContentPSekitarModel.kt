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
import com.application.kpti.databinding.HomeItemPropertySekitarVerticalBinding
import com.application.kpti.databinding.HomeItemTitlePropertyPopulerBinding
import com.bumptech.glide.Glide


@EpoxyModelClass(layout = R.layout.home_item_property_sekitar_vertical)
abstract class ContentPSekitarModel : EpoxyModelWithHolder<ContentPSekitarModel.ItemPropertySekitarHolder>() {

    @field:EpoxyAttribute
    open var ids: Long? = null

    @field:EpoxyAttribute
    open var distancePoint: String? = null

    @field:EpoxyAttribute
    open var imgProperty: String? = null

    @field:EpoxyAttribute
    open var propertyName: String? = null

    @field:EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var itemClickListener: View.OnClickListener? = null

    // Bind our data to view
    override fun bind(holder: ItemPropertySekitarHolder) {
        holder.binding.apply {
            namaProperty.text = propertyName
            decDistance.text = distancePoint
            Glide.with(populerImageSekitar)
                .load(imgProperty)
                .placeholder(R.drawable.logo_c)
                .fitCenter().centerCrop()
                .into(populerImageSekitar)
            root.setOnClickListener(itemClickListener)
        }
    }

    override fun unbind(holder: ItemPropertySekitarHolder) {
        holder.binding.root.setOnClickListener(null)
    }

     class ItemPropertySekitarHolder: EpoxyHolder() {
        lateinit var binding : HomeItemPropertySekitarVerticalBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemPropertySekitarVerticalBinding.bind(itemView)
        }
    }
}

