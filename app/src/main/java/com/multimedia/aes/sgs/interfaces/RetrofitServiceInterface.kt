package com.multimedia.aes.sgs.interfaces

import com.multimedia.aes.sgs.models.RetrofitResults
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
interface RetrofitServiceInterface{


    @Headers("Content-Type: application/json")
    @POST("usuario/login")
    fun login(@Body jsonObject: JSONObject): Call<RetrofitResults>

    @Headers("Content-Type: application/json")
    @POST("mantenimientos/android")
    fun iniciarParte(): Call<JSONObject>
}