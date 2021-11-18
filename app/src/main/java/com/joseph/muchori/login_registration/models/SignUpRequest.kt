@file:Suppress("PackageNaming")
package com.joseph.muchori.login_registration.models

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("phone")
    val phoneNumber: String,
    @SerializedName("password")
    val password: String

)
