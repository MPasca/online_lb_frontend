package android.example.myapplication.ui

import android.example.myapplication.R
import android.example.myapplication.databinding.FragmentLoginBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    lateinit var loginEmail : EditText
    lateinit var loginPassword : EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnLogin = root.findViewById<Button>(R.id.btn_signup)
        btnLogin.setOnClickListener{
            checkCredentials(root)
        }

        return root
    }

    /**
     * checks that the current written credentials exist in the database (or in this case, they are hardcoded)
     */
    private fun checkCredentials(view : View){
        val dummyEmail = "jane.doe@email.com"
        val dummyPassword = "password"

        loginEmail = view.findViewById(R.id.signup_email_txt)
        loginPassword = view.findViewById(R.id.signup_password_txt)

        if(loginEmail.text.equals(dummyEmail)){
            if(loginPassword.text.equals(dummyPassword)){
                    // cool
            }
            // not cool
        }
        // not cooler
    }
}