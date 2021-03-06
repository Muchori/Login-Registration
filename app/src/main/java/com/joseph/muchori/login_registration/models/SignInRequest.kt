@file:Suppress("PackageNaming")
package com.joseph.muchori.login_registration.models

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
