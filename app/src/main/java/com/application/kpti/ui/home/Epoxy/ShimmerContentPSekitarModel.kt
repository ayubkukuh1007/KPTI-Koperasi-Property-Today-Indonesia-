package com.application.kpti.ui.home.Epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.application.kpti.R
import com.application.kpti.databinding.HomeItemPropertyPopulerHorizontalShimmerBinding
import com.application.kpti.databinding.HomeItemPropertySekitarVerticalShimmerBinding


@EpoxyModelClass(layout = R.layout.home_item_property_sekitar_vertical_shimmer)
abstract class ShimmerContentPSekitarModel : EpoxyModelWithHolder<ShimmerContentPSekitarModel.ShimmerPropertySekitarHolder>() {

     class ShimmerPropertySekitarHolder: EpoxyHolder() {
        lateinit var binding : HomeItemPropertySekitarVerticalShimmerBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemPropertySekitarVerticalShimmerBinding.bind(itemView)
        }
    }
}

