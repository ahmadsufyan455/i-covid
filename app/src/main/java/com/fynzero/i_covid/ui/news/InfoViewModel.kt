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

class InfoViewModel : ViewModel() {
    companion object {
        private val TAG = InfoViewModel::class.java.simpleName
    }

    private val infoList = MutableLiveData<ArrayList<NewsModel>>()

    fun setInfo() {
        NewsApiService.endpoint.getNews().enqueue(object : Callback<ArrayList<NewsModel>> {
            override fun onFailure(call: Call<ArrayList<NewsModel>>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }

            override fun onResponse(
                call: Call<ArrayList<NewsModel>>,
                response: Response<ArrayList<NewsModel>>
            ) {
                val result = response.body()
                infoList.postValue(result)
            }

        })
    }

    fun getInfo(): LiveData<ArrayList<NewsModel>> {
        return infoList
    }
}