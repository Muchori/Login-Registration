@file:Suppress("PackageNaming")
package com.joseph.muchori.login_registration.models

class SignInResponse(
    val status: Boolean,
    val message: String,
    val data: User
)
