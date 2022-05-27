package android.example.myapplication.ui

import android.example.myapplication.R
import android.example.myapplication.databinding.FragmentProfileBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {

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

    /**
     * main method that's needed to instantiate the view
     * @return root - the view
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val editButton = root.findViewById<Button>(R.id.btn_edit_profile)
        val btnUpdate = root.findViewById<Button>(R.id.btn_update)

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
     * instantiates both the text edit and the text view fields
     * hides the text view and make the text edits visible so that the user can update the info
     */
    private fun extractInfo(view: View) {
        editFirstName = view.findViewById<EditText>(R.id.edit_firstname)
        editLastName = view.findViewById<EditText>(R.id.edit_lastname)
        editEmail = view.findViewById<EditText>(R.id.edit_email)
        editTelephone = view.findViewById<EditText>(R.id.edit_telephone)
        editAddress = view.findViewById<EditText>(R.id.edit_address)


        firstnameTextView = view.findViewById<TextView>(R.id.txtval_firstname)
        lastnameTextView = view.findViewById<TextView>(R.id.txtval_lastname)
        emailTextView = view.findViewById<TextView>(R.id.txtval_email)
        telephoneTextView = view.findViewById<TextView>(R.id.txtval_telephone)
        addressTextView = view.findViewById<TextView>(R.id.txtval_address)

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
     * gets the data from the text edit fields and updates the text view fields with it
     */
    private fun updateInfo(){
        if(!editFirstName.text.equals("")){
            firstnameTextView.text = editFirstName.text
        }
        if(!editLastName.text.equals("")){
            lastnameTextView.text = editLastName.text
        }
        if(!editEmail.text.equals("")){
            emailTextView.text = editEmail.text
        }
        if(!editTelephone.text.equals("")){
            telephoneTextView.text = editTelephone.text
        }
        if(!editAddress.text.equals("")){
            addressTextView.text = editAddress.text
        }

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