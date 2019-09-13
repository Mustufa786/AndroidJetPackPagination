package com.codixlab.pagintutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = UserAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this)
            .get(UserViewModel::class.java)


        model.userPagedList.observe(this, Observer {

            adapter.submitList(it)
        })

        recyclerView.adapter = adapter


    }
}
