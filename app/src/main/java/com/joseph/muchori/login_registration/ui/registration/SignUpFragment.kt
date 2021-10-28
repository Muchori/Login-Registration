package com.joseph.muchori.login_registration.ui.registration

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
import com.joseph.muchori.login_registration.models.SignUpRequest
import com.joseph.muchori.login_registration.models.SignUpResponse
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpFragment : Fragment(),  View.OnClickListener {

    private lateinit var firstName: TextInputEditText
    private lateinit var lastName: TextInputEditText
    private lateinit var email: TextInputEditText
    private lateinit var phoneNumber: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var navigateSignup: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val mView =  inflater.inflate(R.layout.fragment_sign_up, container, false)

        firstName = mView.findViewById(R.id.first_nameInput) as TextInputEditText
        lastName = mView.findViewById(R.id.last_name_textInput) as TextInputEditText
        email = mView.findViewById(R.id.email_textInput) as TextInputEditText
        phoneNumber = mView.findViewById(R.id.phoneNumber_textInput) as TextInputEditText
        password = mView.findViewById(R.id.password_textInput) as TextInputEditText
        navigateSignup = mView.findViewById(R.id.button_signup) as Button

        navigateSignup.setOnClickListener(this)

        return mView
    }
    override fun onClick(view: View?) {
        when (view?.id){
            R.id.button_signup -> {
                if (validation()){
                    val json = JSONObject()
                    json.put("email", email.text.toString())
                    json.put("first_name", firstName.text.toString())
                    json.put("last_name", lastName.text.toString())
                    json.put("phone_number", phoneNumber.text.toString())
                    json.put("password", password.text.toString())
                }

                SignupLoginApiService.signUpLoginApiCall()?.userRegister(SignUpRequest(
                    email.text.toString(),
                    firstName.text.toString(),
                    lastName.text.toString(),
                    phoneNumber.text.toString(),
                    password.text.toString(),
                ))?.enqueue(object : Callback<SignUpResponse>{
                    override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
                        Log.d("Response::::", response.body().toString())
                        val loginResponse :  SignUpResponse = response.body()!!
                        findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
                        /**if (loginResponse.status){
                            val intent = Intent (activity, ProfileActivity::class.java)
                            activity?.startActivity(intent)
                            activity?.finish()
                        }else{
                            Toast.makeText(activity?.applicationContext, response.body()!!.message, Toast.LENGTH_LONG).show()
                        }*/
                    }

                    override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                        TODO("Not yet implemented")
                    }

                })
            }
        }
    }
    private fun validation(): Boolean {
            var value = true

            val eMail = email_textInput.text.toString().trim()
            val firstName = first_nameInput.text.toString().trim()
            val lastName = last_name_textInput.text.toString().trim()
            val phoneNumber = phoneNumber_textInput.text.toString().trim()
            val passWord = password_textInput.text.toString().trim()

            if (eMail.isEmpty()) {
                email_textInput.error = "Email required"
                email_textInput.requestFocus()
                value = false
            }
            if (passWord.isEmpty()) {
                password_textInput.error = "Password required"
                password_textInput.requestFocus()
                value = false
            }
            if (firstName.isEmpty()) {
                first_nameInput.error = "Firstname required"
                first_nameInput.requestFocus()
                value = false
            }
            if (lastName.isEmpty()) {
                last_name_textInput.error = "Lastname required"
                last_name_textInput.requestFocus()
                value = false
            }
            if (phoneNumber.isEmpty()) {
                phoneNumber_textInput.error = "Phone number required"
                phoneNumber_textInput.requestFocus()
                value = false
            }
            return value;
        }
}