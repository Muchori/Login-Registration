package com.joseph.muchori.login_registration.models


import com.google.gson.annotations.SerializedName

data class SignUpRequestItem(
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phone")
    val phone: String
)