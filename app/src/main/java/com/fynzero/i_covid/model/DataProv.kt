package com.fynzero.i_covid.model

data class DataProv(
    var Provinsi: String? = null,
    var Kasus_Posi: Int = 0,
    var Kasus_Semb: Int = 0,
    var Kasus_Meni: Int = 0
)