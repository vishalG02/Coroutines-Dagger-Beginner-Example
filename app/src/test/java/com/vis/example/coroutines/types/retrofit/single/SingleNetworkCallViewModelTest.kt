package com.vis.example.coroutines.types.retrofit.single

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.vis.example.coroutines.data.api.ApiHelper
import com.vis.example.coroutines.data.local.DatabaseHelper
import com.vis.example.coroutines.data.model.ApiUser
import com.vis.example.coroutines.utils.Resource
import com.vis.example.coroutines.utils.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SingleNetworkCallViewModelTest {

}