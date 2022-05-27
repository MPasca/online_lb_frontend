package android.example.myapplication.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WebService {
    private var webApiService: WebApiService? = null
    val instance: WebApiService?
        get() {
            if (webApiService == null) {
                val API_URL = "http://192.168.154.96:8080/"
                val retrofit = Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(provideOkHttp())
                    .build()
                webApiService = retrofit.create(WebApiService::class.java)
            }
            return webApiService
        }

    private fun provideOkHttp(): OkHttpClient {
        val httpBuilder = OkHttpClient.Builder()
        httpBuilder.connectTimeout(30, TimeUnit.SECONDS)
        return httpBuilder.build()
    }
}