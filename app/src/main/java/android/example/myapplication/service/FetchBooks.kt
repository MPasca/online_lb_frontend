package android.example.myapplication.service

import android.example.myapplication.Model.Book
import retrofit2.Call
import retrofit2.http.GET

interface FetchBooks {
    /**
     * get instruction that fetches all of the books in the DB
     */
    @GET("/books")
    fun getBooks(): Call<List<Book>>
}