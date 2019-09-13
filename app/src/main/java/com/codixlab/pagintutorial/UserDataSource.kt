package com.codixlab.pagintutorial

import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDataSource : PageKeyedDataSource<Int, Data>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Data>
    ) {


        val service = RetrofitClient.builService(APIService::class.java)
        val call = service.getUsers(1)

        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.data
                    val key = if (params.requestedLoadSize > 1) params.requestedLoadSize - 1 else 0
                    responseItems?.let {
                        callback.onResult(responseItems, null, key)
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Data>) {

        val service = RetrofitClient.builService(APIService::class.java)
        val call = service.getUsers(params.key + 1)

        call.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()!!
                    val responseItems = apiResponse.data
                    responseItems?.let {
                        callback.onResult(responseItems, params.key + 1)
                    }
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
            }
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Data>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}