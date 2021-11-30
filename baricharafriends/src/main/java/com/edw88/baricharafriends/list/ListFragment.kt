package com.edw88.baricharafriends.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.edw88.baricharafriends.R
import com.edw88.baricharafriends.databinding.FragmentListBinding
import com.edw88.baricharafriends.main.MainActivity
import com.edw88.baricharafriends.model.Sitios
import com.edw88.baricharafriends.model.SitiosItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var listPoi: ArrayList<SitiosItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listPoi = loadMockJson()
        poiAdapter = PoiAdapter(listPoi, onItemClicked = { this.onPoiClicked(it) })
        listBinding.poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiClicked(sitios: SitiosItem) {
       // findNavController().navigate(ListFragmentDirections.actionListFragmentToSettingsFragment())
       findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(sitio = sitios))

    }

    private fun loadMockJson(): ArrayList<SitiosItem> {
        val poiString: String = context?.assets?.open("poi.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Sitios::class.java)
        return poiList
    }
}