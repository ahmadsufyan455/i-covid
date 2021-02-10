package com.fynzero.i_covid.ui.province

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.Attr
import kotlinx.android.synthetic.main.activity_data_province.*

class DataProvinceActivity : AppCompatActivity() {

    private lateinit var dataProvinceViewModel: DataProvinceViewModel
    private val dataProv = ArrayList<Attr>()
    private val provAdapter = DataProvAdapter(dataProv)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_province)

        // setup recycler view
        rv_province.layoutManager = LinearLayoutManager(this)
        rv_province.setHasFixedSize(true)
        provAdapter.notifyDataSetChanged()
        rv_province.adapter = provAdapter

        dataProvinceViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(DataProvinceViewModel::class.java)

        dataProvinceViewModel.setData()
        dataProvinceViewModel.getData().observe(this, Observer { data ->
            if (data != null) {
                provAdapter.setData(data)
                progressBar.visibility = View.GONE
            }
        })

        btn_back.setOnClickListener { finish() }
    }
}