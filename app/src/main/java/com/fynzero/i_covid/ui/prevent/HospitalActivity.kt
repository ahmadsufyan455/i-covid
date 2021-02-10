package com.fynzero.i_covid.ui.prevent

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.Hospital
import kotlinx.android.synthetic.main.activity_hospital.*

class HospitalActivity : AppCompatActivity() {

    private lateinit var hospitalViewModel: HospitalViewModel
    private val listHospital = ArrayList<Hospital>()
    private val hospitalAdapter = HospitalAdapter(listHospital)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        rv_hospital.layoutManager = LinearLayoutManager(this)
        rv_hospital.setHasFixedSize(true)
        hospitalAdapter.notifyDataSetChanged()
        rv_hospital.adapter = hospitalAdapter

        hospitalViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(HospitalViewModel::class.java)

        hospitalViewModel.setHospital()
        hospitalViewModel.getHospital().observe(this, Observer { hospitals ->
            if (hospitals != null) {
                hospitalAdapter.setData(hospitals)
                progressBar.visibility = View.GONE
            }
        })

        btn_back.setOnClickListener { finish() }
    }
}