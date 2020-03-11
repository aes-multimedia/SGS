package com.multimedia.aes.sgs.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.multimedia.aes.sgs.R
import com.multimedia.aes.sgs.models.RetrofitResults
import com.multimedia.aes.sgs.retrofit.RetrofitBuilder
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initLogin()
    }

    private fun initLogin() {
        val etLoginName = findViewById<EditText>(R.id.etLoginName)
        val etLoginPass = findViewById<EditText>(R.id.etLoginPass)
        val btnLoginEnter = findViewById<Button>(R.id.btnLoginEnter)
        val msg = JSONObject()
        msg.put("login", etLoginName.text.toString())
        msg.put("pass", etLoginPass.text.toString())
        msg.put("tokken", "dHYAY9iaglg:APA91bFIKDmAEoAxOEm8z6PePVeEXr1DernGVTHBps1Ru5QFPG8W1F8oMhQQB2fbRQpwnNn6-IjJo0jzBAT11s2JAUjmt_yQzFxNcGejN1LM4Zcs_IstoMZI4d_0sK9Xhrit_qf94uIK-1cuKl-8Q8yuk-R9GgvSDl-sETvsjRV-rUUxglItUkSBa-38HVjE2yf8GBwkT_WsWf4DwbHLucVPA")
        msg.put("imei", "358138099199149")
        btnLoginEnter.setOnClickListener {
            val retrofitService = RetrofitBuilder().createNotAuthenticatedService()
            val jsonObject = retrofitService.login(msg)

            jsonObject.enqueue(
                object : Callback<RetrofitResults> {
                    override fun onResponse(
                        call: Call<RetrofitResults>,
                        response: Response<RetrofitResults>
                    ) {
                        response.body().toString()
                    }

                    override fun onFailure(call: Call<RetrofitResults>, t: Throwable) {
                        Log.e("prueba",t.message.toString())
                    }
                }
            )
        }
    }
}
