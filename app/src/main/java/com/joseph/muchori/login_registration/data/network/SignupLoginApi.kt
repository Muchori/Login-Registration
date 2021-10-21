package com.joseph.muchori.login_registration.data.network

import com.joseph.muchori.login_registration.models.SignInRequest
import com.joseph.muchori.login_registration.models.SignUpRequest
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SignupLoginApi {


    @FormUrlEncoded
    @POST("/register")
    fun userRegister(

    ):Call<SignUpRequest>

    @FormUrlEncoded
    @POST("/login")
    fun userLogin(

    ):Call<SignInRequest>
}