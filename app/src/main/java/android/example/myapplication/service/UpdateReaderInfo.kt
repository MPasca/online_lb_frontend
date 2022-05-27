package android.example.myapplication.service

import android.example.myapplication.Model.Reader
import retrofit2.Call
import retrofit2.http.POST

/**
 * the interface for the post instruction that updates the information about the reader
 */
interface UpdateReaderInfo {
    /**
     * @param readerId : the id of the reader that's updated
     * @param updateInfo : a reader instance with the info that needs to be updated
     */
    @POST("/readers/{id}")
    fun updateReaderInfo(readerId: Long?, updateInfo: Reader?): Call<Reader>
}