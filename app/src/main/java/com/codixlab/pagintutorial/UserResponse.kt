package com.codixlab.pagintutorial

import com.google.gson.annotations.SerializedName

class UserResponse {
    @field:SerializedName("data")
    val data: List<Data>? = null
    @field:SerializedName("page")
    val page: Int = 0
    @field:SerializedName("per_page")
    val perPage: Int = 0
    @field:SerializedName("total")
    val total: Int = 0
    @field:SerializedName("total_pages")
    val totalPages: Int = 0



}


