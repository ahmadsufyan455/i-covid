package com.fynzero.i_covid.ui.province

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fynzero.i_covid.model.Attr
import com.fynzero.i_covid.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataProvinceViewModel : ViewModel() {
    companion object {
        private val TAG = DataProvinceViewModel::class.java.simpleName
    }

    private val dataProvince = MutableLiveData<ArrayList<Attr>>()

    fun setData() {
        ApiService.endpoint.getDataProvince().enqueue(object : Callback<ArrayList<Attr>> {
            override fun onFailure(call: Call<ArrayList<Attr>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<Attr>>,
                response: Response<ArrayList<Attr>>
            ) {
                val result = response.body()
                dataProvince.postValue(result)
            }

        })
    }

    fun getData(): LiveData<ArrayList<Attr>> = dataProvince
}