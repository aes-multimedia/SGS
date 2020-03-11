package com.multimedia.aes.sgs.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONObject


class RetrofitResults{
    @SerializedName("estado")
    @Expose
    private val estado: Int? = null
    @SerializedName("usuario")
    @Expose
    private val usuario: Usuario? = null
}