package com.fynzero.i_covid.ui.province

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.Attr
import kotlinx.android.synthetic.main.data_item.view.*

class DataProvAdapter(private val listProv: ArrayList<Attr>) :
    RecyclerView.Adapter<DataProvAdapter.ViewHolder>() {

    fun setData(list: ArrayList<Attr>) {
        listProv.clear()
        listProv.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        ))
    }

    override fun getItemCount(): Int = listProv.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listProv[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(dataProv: Attr) {
            with(itemView) {
                txt_prov.text = dataProv.attributes.Provinsi
                txt_positif.text = dataProv.attributes.Kasus_Posi.toString()
                txt_sembuh.text = dataProv.attributes.Kasus_Semb.toString()
                txt_meninggal.text = dataProv.attributes.Kasus_Meni.toString()
            }
        }
    }
}