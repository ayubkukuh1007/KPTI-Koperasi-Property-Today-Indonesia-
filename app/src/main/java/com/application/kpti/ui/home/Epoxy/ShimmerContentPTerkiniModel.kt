package com.application.kpti.ui.home.Epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.application.kpti.R
import com.application.kpti.databinding.HomeItemPropertyPopulerHorizontalShimmerBinding
import com.application.kpti.databinding.HomeItemPropertyTerkiniVerticalShimmerBinding


@EpoxyModelClass(layout = R.layout.home_item_property_terkini_vertical_shimmer)
abstract class ShimmerContentPTerkiniModel : EpoxyModelWithHolder<ShimmerContentPTerkiniModel.ShimmerPropertyTerkiniHolder>() {

     class ShimmerPropertyTerkiniHolder: EpoxyHolder() {
        lateinit var binding : HomeItemPropertyTerkiniVerticalShimmerBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemPropertyTerkiniVerticalShimmerBinding.bind(itemView)
        }
    }
}

