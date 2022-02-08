package com.application.kpti.ui.profil.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.application.kpti.ui.profil.pages.favorite.FavoriteFragment
import com.application.kpti.ui.profil.pages.setting.SettingsFragment
import com.application.kpti.ui.profil.pages.info.InfoFragment

class AdapterProfileViewpager2(fa : Fragment) : FragmentStateAdapter(fa)  {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position) {
            0-> return InfoFragment()
            1-> return FavoriteFragment()
            else-> return SettingsFragment()
        }
    }
}