package com.youssef.obus.ui.buslines

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.youssef.obus.R
import kotlinx.android.synthetic.main.fragment_listing_bus_lines.*

class BuslinesListingFragment : Fragment() {

    companion object {
        fun newInstance() = BuslinesListingFragment()
    }

    private lateinit var viewModel: BuslinesListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_listing_bus_lines, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BuslinesListingViewModel::class.java)

        viewModel.getBuslines().observe(this, Observer { s ->
            passenger_list.layoutManager = LinearLayoutManager(context)
            passenger_list.adapter =
                BuslinesAdapter(context, s!!) { Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show() }
        })

    }

}
