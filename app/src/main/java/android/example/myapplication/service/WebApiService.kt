package android.example.myapplication.service

import android.example.myapplication.Model.Book
import android.example.myapplication.Model.Borrowing
import android.example.myapplication.Model.Reader
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface WebApiService {
    @GET("/books")
    fun getBooks(): Call<List<Book>>

    @GET("/borrowings/{id}")
    fun getBorrowings(readerId: Long?): Call<List<Borrowing?>?>?

    @GET("/readers/{id}")
    fun getReaderInfo(readerId: Long?): Call<Reader>

    @POST("/readers/{id}")
    fun updateReaderInfo(@Path("id") id: Long, reader: Reader): Call<Reader>
}