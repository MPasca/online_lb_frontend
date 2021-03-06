package android.example.myapplication

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

        val btnLogin = root.findViewById<Button>(R.id.btn_login)
        btnLogin.setOnClickListener{
            checkCredentials(root)
        }

        return root
    }

    private fun checkCredentials(view : View){
        val dummyEmail = "jane.doe@email.com"
        val dummyPassword = "password"

        loginEmail = view.findViewById(R.id.login_email_txt)
        loginPassword = view.findViewById(R.id.login_password_txt)

        if(loginEmail.text.equals(dummyEmail)){
            if(loginPassword.text.equals(dummyPassword)){
                    // cool
            }
            // not cool
        }
        // not cooler
    }
}