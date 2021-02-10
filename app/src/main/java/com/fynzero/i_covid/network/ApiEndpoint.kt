package com.fynzero.i_covid.network

import com.fynzero.i_covid.model.Attr
import com.fynzero.i_covid.model.DataIndonesia
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("indonesia")
    fun getDataIndonesia(): Call<ArrayList<DataIndonesia>>

    @GET("indonesia/provinsi")
    fun getDataProvince(): Call<ArrayList<Attr>>
}