package com.joseph.muchori.login_registration.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.joseph.muchori.login_registration.R
import com.joseph.muchori.login_registration.di.SignupLoginApiService
import com.joseph.muchori.login_registration.models.SignInRequest
import com.joseph.muchori.login_registration.models.SignInResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInFragment : Fragment(), View.OnClickListener {

    private lateinit var emailInput: TextInputEditText
    private lateinit var passwordInput: TextInputEditText
    private lateinit var buttonSignIn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView = inflater.inflate(R.layout.fragment_sign_in, container, false)

        emailInput = mView.findViewById(R.id.textInput_email) as TextInputEditText
        passwordInput = mView.findViewById(R.id.passwordInputText) as TextInputEditText
        buttonSignIn = mView.findViewById(R.id.button_login) as Button

        buttonSignIn.setOnClickListener(this)

        return mView
    }

    override fun onClick(view: View?) {
        when (view?.id){
            R.id.button_login -> {
                if (validation()){
                    val json = JSONObject()
                    json.put("email", emailInput.text.toString())
                    json.put("password", passwordInput.text.toString())
                }

                SignupLoginApiService.signUpLoginApiCall()?.userLogin(
                    SignInRequest(
                    emailInput.text.toString(),
                    passwordInput.text.toString(),
                )
                )?.enqueue(object : Callback<SignInResponse> {
                    override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                        Log.d("Response::::", response.body().toString())
//                        val loginResponse : SignInResponse = response.body()!!
                        findNavController().navigate(R.id.action_signInFragment_to_profileActivity)
                        /*if (response.body()!!.status){
                            activity?.finish()
                            val intent = Intent (activity, ProfileActivity::class.java)
                            intent.putExtra("email",response.body()!!.data.email)
                            activity?.startActivity(intent)

                        }else{
                            Toast.makeText(activity?.applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                        }*/
                    }
                    override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                    }
                })
            }
        }
    }
    private fun validation(): Boolean {
        var value = true
        val eMail = emailInput.text.toString().trim()
        val passWord = passwordInput.text.toString().trim()
        if (eMail.isEmpty()) {
            emailInput.error = "Email required"
            emailInput.requestFocus()
            value = false
        }
        if (passWord.isEmpty()) {
            passwordInput.error = "Password required"
            passwordInput.requestFocus()
            value = false
        }
        return value;
    }
}