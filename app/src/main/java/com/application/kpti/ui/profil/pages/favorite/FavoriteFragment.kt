package com.application.kpti.ui.profil.pages.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.R
import com.application.kpti.databinding.FragmentFavoriteBinding
import com.application.kpti.databinding.FragmentInfoBinding
import com.application.kpti.ui.profil.adapter.FavoriteListAdapter
import com.application.kpti.ui.profil.adapter.InfoListAdapter
import com.application.kpti.ui.profil.model.ProfilInfoItem
import com.application.kpti.ui.profil.pages.favorite.model.ListFavoriteItem
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var favoriteListAdapter: FavoriteListAdapter

    val jsonData = "[\n" +
            "  {\n" +
            "    \"favorite_property\": \"Grand Vila Aston\",\n" +
            "    \"img_property\": \"https://kpti.co.id/uploads/market/small/1618560780.jpg\",\n" +
            "    \"price\": \"200.000.000\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"favorite_property\": \"Grand Vila Aston\",\n" +
            "    \"img_property\": \"https://kpti.co.id/uploads/market/small/1618560780.jpg\",\n" +
            "    \"price\": \"200.000.000\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"favorite_property\": \"Grand Vila Aston\",\n" +
            "    \"img_property\": \"https://kpti.co.id/uploads/market/small/1618560780.jpg\",\n" +
            "    \"price\": \"200.000.000\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"favorite_property\": \"Grand Vila Aston\",\n" +
            "    \"img_property\": \"https://kpti.co.id/uploads/market/small/1618560780.jpg\",\n" +
            "    \"price\": \"200.000.000\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"favorite_property\": \"Grand Vila Aston\",\n" +
            "    \"img_property\": \"https://kpti.co.id/uploads/market/small/1618560780.jpg\",\n" +
            "    \"price\": \"200.000.000\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"favorite_property\": \"Grand Vila Aston\",\n" +
            "    \"img_property\": \"https://kpti.co.id/uploads/market/small/1618560780.jpg\",\n" +
            "    \"price\": \"200.000.000\"\n" +
            "  }\n" +
            "]"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        val view = binding.root
        val moshi: Moshi = Moshi.Builder().build()
        val type: Type = Types.newParameterizedType(MutableList::class.java, ListFavoriteItem::class.java)
        val adapter: JsonAdapter<List<ListFavoriteItem>> = moshi.adapter(type)
        val favorites: List<ListFavoriteItem>? = adapter.fromJson(jsonData)
        favoriteListAdapter = FavoriteListAdapter(context=requireContext(),favorites = favorites!!)
        binding.rvfavorites.adapter = favoriteListAdapter
        binding.rvfavorites.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL, false)
        return view
    }

}