package com.codixlab.pagintutorial

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class UserViewModel : ViewModel() {


    var userPagedList: LiveData<PagedList<Data>>
    var liveDataSource: LiveData<UserDataSource>


    init {
        val dataSourceFactory = UserDataSourceFactory()
        liveDataSource = dataSourceFactory.userLiveDataSource

        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(4)
            .build()

        userPagedList = LivePagedListBuilder(dataSourceFactory, config).build()

    }
}