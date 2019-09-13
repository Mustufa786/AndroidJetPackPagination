package com.codixlab.pagintutorial

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {


    @GET("users")
    fun getUsers(@Query("page") page: Int): Call<UserResponse>
}