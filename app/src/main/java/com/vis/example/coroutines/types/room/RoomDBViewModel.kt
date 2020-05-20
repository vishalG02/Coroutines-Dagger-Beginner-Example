package com.vis.example.coroutines.types.room

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vis.example.coroutines.data.local.entity.User
import com.vis.example.coroutines.utils.Resource
import com.vis.example.coroutines.utils.UserRepository
import kotlinx.coroutines.launch

class RoomDBViewModel(    private val userRepository: UserRepository
) :
    ViewModel() {

    private val users = MutableLiveData<Resource<List<User>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromDb = userRepository.getUsersFromDb()
                if (usersFromDb.isEmpty()) {
                    val usersFromApi = userRepository.getUsers()
                    val usersToInsertInDB = mutableListOf<User>()

                    for (apiUser in usersFromApi) {
                        val user = User(
                            apiUser.id,
                            apiUser.name,
                            apiUser.email,
                            apiUser.avatar
                        )
                        usersToInsertInDB.add(user)
                    }

                    userRepository.insertAll(usersToInsertInDB)

                    users.postValue(Resource.success(usersToInsertInDB))

                } else {
                    users.postValue(Resource.success(usersFromDb))
                }


            } catch (e: Exception) {
                users.postValue(Resource.error("Internet Connection not Available", null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }

}