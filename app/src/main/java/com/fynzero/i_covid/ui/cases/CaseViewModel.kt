package com.fynzero.i_covid.ui.cases

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fynzero.i_covid.model.DataIndonesia
import com.fynzero.i_covid.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CaseViewModel : ViewModel() {
    companion object {
        private val TAG = CaseViewModel::class.java.simpleName
    }

    private val dataIndonesia = MutableLiveData<DataIndonesia>()

    fun setData() {
        ApiService.endpoint.getDataIndonesia().enqueue(object : Callback<ArrayList<DataIndonesia>> {
            override fun onFailure(call: Call<ArrayList<DataIndonesia>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<DataIndonesia>>,
                response: Response<ArrayList<DataIndonesia>>
            ) {
                val result = response.body()
                dataIndonesia.postValue(result?.get(0))
            }

        })
    }

    fun getData(): LiveData<DataIndonesia> {
        return dataIndonesia
    }
}