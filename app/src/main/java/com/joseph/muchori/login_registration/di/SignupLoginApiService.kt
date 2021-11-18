@file:Suppress("PackageNaming")
package com.joseph.muchori.login_registration.di

import com.joseph.muchori.login_registration.data.network.SignupLoginApi
import com.joseph.muchori.login_registration.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit

object SignupLoginApiService {

    fun signUpLoginApiCall(): SignupLoginApi? = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(NetworkModule.gsonConverter)
        .client(NetworkModule.client)
        .build()
        .create(SignupLoginApi::class.java)
}
