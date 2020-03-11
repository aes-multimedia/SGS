package com.multimedia.aes.sgs.retrofit

import android.annotation.SuppressLint
import com.multimedia.aes.sgs.constants.Constants
import com.multimedia.aes.sgs.interfaces.RetrofitServiceInterface
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*

class RetrofitBuilder {

    fun createAuthenticatedService(): RetrofitServiceInterface {

        val build = Retrofit.Builder()
            .client(createHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.API_URL)
            .build()

        return build.create(RetrofitServiceInterface::class.java)
    }

    fun createNotAuthenticatedService(): RetrofitServiceInterface {

        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.API_URL)
            .build()

        return build.create(RetrofitServiceInterface::class.java)
    }


    fun createUnsafeOkHttpClient(): OkHttpClient {
        try {
            val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }
            })

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())

            val sslSocketFactory = sslContext.getSocketFactory()

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier(object : HostnameVerifier {
                override fun verify(hostname: String, session: SSLSession): Boolean {
                    return true
                }
            })

            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }

    private fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ApiAuthenticator())
            .build()
    }

    private class ApiAuthenticator() : Interceptor {

        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request()
            val authRequest = request.newBuilder()
                .addHeader("Content-Type", "application/json; charset=UTF-8")
                .addHeader("apikey", "7f7f75-4c3d45-71e38e-8b9b71-36bfb5")
                .addHeader("id", "131")
                .addHeader("fk_parte", "46785")
                .build()
            return chain.proceed(authRequest)
        }
    }
}