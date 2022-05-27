package android.example.myapplication.service

import android.example.myapplication.Model.Reader
import retrofit2.Call
import retrofit2.http.GET

interface FetchReaderInfo {
    /**
     * get instruction that fetches the reader info
     * @param readerId : the id of the reader that needs to be fetched
     */
    @GET("/readers/{id}")
    fun getReaderInfo(readerId: Long?): Call<Reader>
}