package com.application.kpti.ui.home.Epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.application.kpti.R
import com.application.kpti.databinding.HomeItemPropertyPopulerHorizontalShimmerBinding



@EpoxyModelClass(layout = R.layout.home_item_property_populer_horizontal_shimmer)
abstract class ShimmerContentPPopulerModel : EpoxyModelWithHolder<ShimmerContentPPopulerModel.ShimmerPropertyPopulerHolder>() {

     class ShimmerPropertyPopulerHolder: EpoxyHolder() {
        lateinit var binding : HomeItemPropertyPopulerHorizontalShimmerBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemPropertyPopulerHorizontalShimmerBinding.bind(itemView)
        }
    }
}

