package com.fynzero.i_covid.ui.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fynzero.i_covid.model.NewsModel
import com.fynzero.i_covid.network.NewsApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HoaxViewModel : ViewModel() {
    companion object {
        private val TAG = HoaxViewModel::class.java.simpleName
    }

    private val hoaxList = MutableLiveData<ArrayList<NewsModel>>()

    fun setHoax() {
        NewsApiService.endpoint.getHoax().enqueue(object : Callback<ArrayList<NewsModel>> {
            override fun onFailure(call: Call<ArrayList<NewsModel>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<NewsModel>>,
                response: Response<ArrayList<NewsModel>>
            ) {
                val result = response.body()
                hoaxList.postValue(result)
            }

        })
    }

    fun getHoax(): LiveData<ArrayList<NewsModel>> {
        return hoaxList
    }
}