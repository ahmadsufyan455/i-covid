package com.fynzero.i_covid.ui.cases

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fynzero.i_covid.R
import com.fynzero.i_covid.ui.province.DataProvinceActivity
import kotlinx.android.synthetic.main.fragment_case.*

class CaseFragment : Fragment() {

    private lateinit var caseViewModel: CaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_case, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        caseViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(CaseViewModel::class.java)

        caseViewModel.getData().observe(viewLifecycleOwner, Observer { dataIndonesia ->
            txt_positif.text = dataIndonesia.positif
            txt_sembuh.text = dataIndonesia.sembuh
            txt_meninggal.text = dataIndonesia.meninggal
        })

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.country,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                // nothing
            }

            override fun onItemSelected(parent: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                if (pos == 0) {
                    caseViewModel.setData()
                }
            }
        }

        lihat_semua.setOnClickListener {
            startActivity(Intent(activity, DataProvinceActivity::class.java))
        }
    }
}