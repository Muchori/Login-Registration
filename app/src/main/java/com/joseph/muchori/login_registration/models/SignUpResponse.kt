@file:Suppress("PackageNaming")
package com.joseph.muchori.login_registration.models

class SignUpResponse(
    val status: Boolean,
    val message: String,
    val data: User
)
