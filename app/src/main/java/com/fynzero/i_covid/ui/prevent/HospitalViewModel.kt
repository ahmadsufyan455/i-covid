package com.fynzero.i_covid.ui.prevent

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fynzero.i_covid.model.Hospital
import com.fynzero.i_covid.network.NewsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalViewModel : ViewModel() {
    companion object {
        private val TAG = HospitalViewModel::class.java.simpleName
    }

    private val listHospital = MutableLiveData<ArrayList<Hospital>>()

    fun setHospital() {
        NewsApiService.endpoint.getHospital().enqueue(object : Callback<ArrayList<Hospital>> {
            override fun onFailure(call: Call<ArrayList<Hospital>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<Hospital>>,
                response: Response<ArrayList<Hospital>>
            ) {
                val result = response.body()
                listHospital.postValue(result)
            }

        })
    }

    fun getHospital(): LiveData<ArrayList<Hospital>> = listHospital
}