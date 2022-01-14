package com.application.kpti.ui.home.Epoxy


import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.application.kpti.R
import com.application.kpti.databinding.HomeItemTitlePropertyTerkiniBinding



@EpoxyModelClass(layout = R.layout.home_item_title_property_terkini)
abstract class HeaderPTekiniModel : EpoxyModelWithHolder<HeaderPTekiniModel.HeaderTitleHolder>() {

     class HeaderTitleHolder: EpoxyHolder() {
        lateinit var binding : HomeItemTitlePropertyTerkiniBinding
        private set

        override fun bindView(itemView: View) {
            binding = HomeItemTitlePropertyTerkiniBinding.bind(itemView)
        }
    }
}

