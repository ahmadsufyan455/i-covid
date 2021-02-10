package com.fynzero.i_covid.network

import com.fynzero.i_covid.model.Hospital
import com.fynzero.i_covid.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET

interface NewsEndPoint {
    @GET("api/id/covid19/news")
    fun getNews(): Call<ArrayList<NewsModel>>

    @GET("api/id/covid19/hoaxes")
    fun getHoax(): Call<ArrayList<NewsModel>>

    @GET("api/id/covid19/hospitals")
    fun getHospital(): Call<ArrayList<Hospital>>
}