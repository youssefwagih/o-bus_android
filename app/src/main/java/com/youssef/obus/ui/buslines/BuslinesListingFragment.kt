package com.youssef.obus.ui.buslines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.youssef.obus.R
import com.youssef.obus.ui.busline_map.BuslineMapFragment
import kotlinx.android.synthetic.main.fragment_listing_bus_lines.*

class BuslinesListingFragment : Fragment() {

    companion object {
        fun newInstance() = BuslineMapFragment()
    }

    private lateinit var mapViewModel: BuslineMapViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listing_bus_lines, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapViewModel = ViewModelProviders.of(this).get(BuslineMapViewModel::class.java)

        mapViewModel.getBuslines().observe(this, Observer { s ->
            passenger_list.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
            passenger_list.adapter =
                BuslinesAdapter(context, s!!) {
                    val action = BuslinesListingFragmentDirections.ActionMainFragmentToBuslineMapFragment2(it)
                    findNavController().navigate(action)
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
        })

    }

}
