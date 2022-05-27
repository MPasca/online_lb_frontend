package android.example.myapplication.ui

import android.example.myapplication.Model.Reader
import android.example.myapplication.R
import android.example.myapplication.databinding.FragmentProfileBinding
import android.example.myapplication.service.FetchReaderInfo
import android.example.myapplication.service.UpdateReaderInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OldProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    lateinit var editFirstName : EditText
    lateinit var editLastName : EditText
    lateinit var editEmail : EditText
    lateinit var editTelephone : EditText
    lateinit var editAddress : EditText

    lateinit var firstnameTextView : TextView
    lateinit var lastnameTextView : TextView
    lateinit var emailTextView : TextView
    lateinit var telephoneTextView : TextView
    lateinit var addressTextView : TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        editFirstName = root.findViewById<EditText>(R.id.edit_firstname)
        editLastName = root.findViewById<EditText>(R.id.edit_lastname)
        editEmail = root.findViewById<EditText>(R.id.edit_email)
        editTelephone = root.findViewById<EditText>(R.id.edit_telephone)
        editAddress = root.findViewById<EditText>(R.id.edit_address)


        firstnameTextView = root.findViewById<TextView>(R.id.txtval_firstname)
        lastnameTextView = root.findViewById<TextView>(R.id.txtval_lastname)
        emailTextView = root.findViewById<TextView>(R.id.txtval_email)
        telephoneTextView = root.findViewById<TextView>(R.id.txtval_telephone)
        addressTextView = root.findViewById<TextView>(R.id.txtval_address)

        val editButton = root.findViewById<Button>(R.id.btn_edit_profile)
        val btnUpdate = root.findViewById<Button>(R.id.btn_update)

        fetchInfo()

        editButton.setOnClickListener{
            it.visibility = View.GONE
            btnUpdate.visibility = View.VISIBLE
            extractInfo(root)
        }

        btnUpdate.setOnClickListener{
            it.visibility = View.GONE
            editButton.visibility = View.VISIBLE
            updateInfo()
        }

        return root
    }

    /**
     * creates a connection to the backend to fetch the info
     * and prints it throughthe text view fields
     */
    private fun fetchInfo(){
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://172.27.138.102:8080/reader/1")
            .build()
            .create(FetchReaderInfo::class.java)

        val data = retrofitBuilder.getReaderInfo(1L)

        data.enqueue(object : Callback<Reader?> {
            override fun onResponse(
                call: Call<Reader?>,
                response: Response<Reader?>
            ) {
                val responseBody = response.body()!!

                firstnameTextView.text = responseBody.firstName
                lastnameTextView.text = responseBody.lastName
                emailTextView.text = responseBody.email
                telephoneTextView.text = responseBody.telephone
                addressTextView.text = responseBody.address
            }
            override fun onFailure(call: Call<Reader?>, t: Throwable) {
                throw t
            }
        })

    }

    /**
     * hides the text views and makes text edit fields visible
     */
    private fun extractInfo(view: View) {
        firstnameTextView.visibility = View.GONE
        lastnameTextView.visibility = View.GONE
        emailTextView.visibility = View.GONE
        telephoneTextView.visibility = View.GONE
        addressTextView.visibility = View.GONE

        editFirstName.visibility = View.VISIBLE
        editLastName.visibility = View.VISIBLE
        editEmail.visibility = View.VISIBLE
        editTelephone.visibility = View.VISIBLE
        editAddress.visibility = View.VISIBLE

    }

    /**
     * creates a new reader instance with the data updated through the text edits
     * sends it to the backend to update the current reader
     * returns it and sends it to the text views
     */
    private fun updateInfo(){
        val updateReader = Reader(1,
            firstName = editFirstName.text.toString(),
            lastName = editLastName.text.toString(),
            address = editAddress.text.toString(),
            telephone = editTelephone.text.toString(),
            email = editEmail.text.toString(),
            password = ""
        )

        updateReader.firstName = editFirstName.text.toString()
        updateReader.lastName = editLastName.text.toString()
        updateReader.email = editEmail.text.toString()
        updateReader.telephone = editTelephone.text.toString()
        updateReader.address = editAddress.text.toString()
        updateReader.password = ""

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://172.27.138.102:8080/reader/1")
            .build()
            .create(UpdateReaderInfo::class.java)

        val data = retrofitBuilder.updateReaderInfo(1L, updateReader)

        data.enqueue(object : Callback<Reader?> {
            override fun onResponse(
                call: Call<Reader?>,
                response: Response<Reader?>
            ) {
                val updatedReader = response.body()!!

                firstnameTextView.text = updatedReader.firstName
                lastnameTextView.text = updatedReader.lastName
                emailTextView.text = updatedReader.email
                telephoneTextView.text = updatedReader.telephone
                addressTextView.text = updatedReader.address
            }
            override fun onFailure(call: Call<Reader?>, t: Throwable) {
                throw t
            }
        })

        firstnameTextView.visibility = View.VISIBLE
        lastnameTextView.visibility = View.VISIBLE
        emailTextView.visibility = View.VISIBLE
        telephoneTextView.visibility = View.VISIBLE
        addressTextView.visibility = View.VISIBLE

        editFirstName.visibility = View.GONE
        editLastName.visibility = View.GONE
        editEmail.visibility = View.GONE
        editTelephone.visibility = View.GONE
        editAddress.visibility = View.GONE

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

