package com.youssef.obus.ui.buslines

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.youssef.obus.R
import com.youssef.obus.data.models.Busline
import kotlinx.android.synthetic.main.list_item_busline.view.*

class BuslinesAdapter(val context: Context?, val passengersList: List<Busline>, val c: (Busline) -> Unit) :
    RecyclerView.Adapter<BuslinesAdapter.PassengersViewHolder>() {



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PassengersViewHolder {
        return PassengersViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_busline, p0, false))
    }

    override fun getItemCount(): Int {
        return passengersList.size
    }

    override fun onBindViewHolder(passengersViewHolder: PassengersViewHolder, position: Int) {
        passengersViewHolder.itemView.name_textview.text = passengersList.get(position).name
        passengersViewHolder.itemView.setOnClickListener{ c.invoke(passengersList[position])}
    }

    class PassengersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}
