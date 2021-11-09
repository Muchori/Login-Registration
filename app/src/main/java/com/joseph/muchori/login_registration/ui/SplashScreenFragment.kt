package com.joseph.muchori.login_registration.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.joseph.muchori.login_registration.R
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import kotlinx.android.synthetic.main.fragment_splash_screen.view.*
import kotlinx.android.synthetic.main.fragment_splash_screen.view.button_login

class SplashScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val mView = inflater.inflate(R.layout.fragment_splash_screen, container, false)

        mView.navigate_signup.setOnClickListener {
            findNavController().navigate(R.id.action_splashScreenFragment_to_signUpFragment)
        }

        mView.button_login.setOnClickListener {
            val action = SplashScreenFragmentDirections.actionSplashScreenFragmentToSignInFragment()
            findNavController().navigate(action)
        }

        return mView
    }
}
