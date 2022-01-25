package com.application.kpti.Network

import com.application.kpti.Preferences.Userdata
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface KptiService {

    //form login
    @GET("login")
    suspend fun Login(): Response<Userdata>

    @GET("forgotPassword")
    suspend fun ForgotPassword(): Response<Userdata>

    //form register
    @GET("register")
    suspend fun Register(): Response<Userdata>

    //form home
    @GET("propery_sekitar")
    suspend fun location()

    @GET("property")
    suspend fun property()

    //detail property
    @GET("detail_property")
    suspend fun detailProperty()

}