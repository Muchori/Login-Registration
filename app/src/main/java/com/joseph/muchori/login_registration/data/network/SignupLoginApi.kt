@file:Suppress("PackageNaming")


package com.joseph.muchori.login_registration.data.network

import com.joseph.muchori.login_registration.models.SignInRequest
import com.joseph.muchori.login_registration.models.SignInResponse
import com.joseph.muchori.login_registration.models.SignUpRequest
import com.joseph.muchori.login_registration.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupLoginApi {

    @POST("register")
    fun userRegister(
        @Body signUpRequest: SignUpRequest
    ): Call<SignUpResponse>

    @POST("login")
    fun userLogin(
        @Body signInRequest: SignInRequest
    ): Call<SignInResponse>
}
