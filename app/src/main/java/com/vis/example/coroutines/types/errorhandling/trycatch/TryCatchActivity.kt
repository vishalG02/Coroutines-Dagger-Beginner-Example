package com.vis.example.coroutines.types.errorhandling.trycatch

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.vis.example.coroutines.R
import com.vis.example.coroutines.data.model.ApiUser
import com.vis.example.coroutines.di.UserApplication
import com.vis.example.coroutines.adapter.ApiUserAdapter
import com.vis.example.coroutines.utils.Status
import com.vis.example.coroutines.utils.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_recycler_view.*
import javax.inject.Inject

class TryCatchActivity : AppCompatActivity() {
    @Inject
    lateinit var userViewModelFactory: UserViewModelFactory
    private lateinit var viewModel: TryCatchViewModel
    private lateinit var adapter: ApiUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        (application as UserApplication).getAppComponent()!!.inject(this)
        viewModel = ViewModelProvider(this, userViewModelFactory).get(
            TryCatchViewModel::class.java)

        setupUI()

        setupObserver()
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter =
            ApiUserAdapter(
                arrayListOf()
            )
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getUsers().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { users -> renderList(users) }
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    //Handle Error
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(users: List<ApiUser>) {
        adapter.addData(users)
        adapter.notifyDataSetChanged()
    }


}
