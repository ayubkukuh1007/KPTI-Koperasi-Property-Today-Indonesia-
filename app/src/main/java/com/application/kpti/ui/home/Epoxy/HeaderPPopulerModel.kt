package com.application.kpti.ui.home.Epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.application.kpti.R
import com.application.kpti.databinding.HomeItemTitlePropertyPopulerBinding


@EpoxyModelClass(layout = R.layout.home_item_title_property_populer)
abstract class HeaderPPopulerModel : EpoxyModelWithHolder<HeaderPPopulerModel.HeaderTitleHolder>() {

     class HeaderTitleHolder: EpoxyHolder() {
        lateinit var binding : HomeItemTitlePropertyPopulerBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemTitlePropertyPopulerBinding.bind(itemView)
        }
    }
}

