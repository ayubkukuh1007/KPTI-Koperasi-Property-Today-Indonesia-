package com.application.kpti.ui.profil.pages.info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.kpti.databinding.FragmentInfoBinding
import com.application.kpti.ui.location.model.Recently
import com.application.kpti.ui.profil.adapter.InfoListAdapter
import com.application.kpti.ui.profil.model.ProfilInfoItem
import com.google.gson.Gson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type


class InfoFragment : Fragment(),InfoListAdapter.OnItemClickListener {

    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var infoListAdapter: InfoListAdapter

    val jsonData = "[\n" +
            "  {\n" +
            "    \"date\": \"Senin, 18 Januari 2022\",\n" +
            "    \"decription\": \"Kiat Berbisnis Property di Era Pandemi\",\n" +
            "    \"img_info\": \"https://kpti.co.id/uploads/market/1617161484.jpeg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\": \"Senin, 18 Januari 2022\",\n" +
            "    \"decription\": \"Kiat Berbisnis Property di Era Pandemi\",\n" +
            "    \"img_info\": \"https://kpti.co.id/uploads/market/1617161484.jpeg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\": \"Senin, 18 Januari 2022\",\n" +
            "    \"decription\": \"Kiat Berbisnis Property di Era Pandemi\",\n" +
            "    \"img_info\": \"https://kpti.co.id/uploads/market/1617161484.jpeg\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"date\": \"Senin, 18 Januari 2022\",\n" +
            "    \"decription\": \"Kiat Berbisnis Property di Era Pandemi\",\n" +
            "    \"img_info\": \"https://kpti.co.id/uploads/market/1617161484.jpeg\"\n" +
            "  }\n" +
            "]"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        val moshi: Moshi = Moshi.Builder().build()
        val type: Type = Types.newParameterizedType(MutableList::class.java, ProfilInfoItem::class.java)
        val adapter: JsonAdapter<List<ProfilInfoItem>> = moshi.adapter(type)
        val infos: List<ProfilInfoItem>? = adapter.fromJson(jsonData)
        infoListAdapter = InfoListAdapter(context=requireContext(),infos = infos!!,onItemClickListener = this)
        binding.rvProfileInfo.adapter = infoListAdapter
        binding.rvProfileInfo.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL, false)


        return view
    }

    override fun onItemInfoClick(location: Recently) {

    }
}