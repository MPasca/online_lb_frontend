package android.example.myapplication.ui

import android.example.myapplication.Model.Book
import android.example.myapplication.R
import android.example.myapplication.databinding.FragmentBooksBinding
import android.example.myapplication.service.FetchBooks
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    /**
     * main method that's needed to instantiate the view
     * @return root - the view
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        fetchBookList(root)

        return root
    }

    /**
     * the method needed to fetch the book list
     * @param root - the current view
     *
     * it creates the connection to the backend using retrofit.builder
     * gets the information and adds it to the bookList
     */
    private fun fetchBookList(root : View){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://172.27.138.102:8080/books/")
            .build()
            .create(FetchBooks::class.java)

        val bookList = retrofitBuilder.getBooks()

        bookList.enqueue(object : Callback<List<Book>>{
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val responseBody = response.body()!!

                val listView = root.findViewById<ListView>(R.id.book_list_view)
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                throw t
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}