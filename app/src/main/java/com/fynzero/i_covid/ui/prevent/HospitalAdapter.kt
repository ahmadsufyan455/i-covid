package com.fynzero.i_covid.ui.prevent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.Hospital
import kotlinx.android.synthetic.main.hospital_item.view.*

class HospitalAdapter(private val listHospital: ArrayList<Hospital>) :
    RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    fun setData(list: ArrayList<Hospital>) {
        listHospital.clear()
        listHospital.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.hospital_item, parent, false)
        ))
    }

    override fun getItemCount(): Int = listHospital.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listHospital[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(hospital: Hospital) {
            with(itemView) {
                txt_name.text = hospital.name
                txt_address.text = hospital.address
                txt_region.text = hospital.region
                txt_phone.text = hospital.phone
                txt_province.text = hospital.province
            }
        }
    }
}