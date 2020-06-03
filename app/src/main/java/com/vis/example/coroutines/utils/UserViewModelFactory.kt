package com.vis.example.coroutines.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vis.example.coroutines.types.errorhandling.exceptionhandler.ExceptionHandlerViewModel
import com.vis.example.coroutines.types.errorhandling.supervisor.IgnoreErrorAndContinueViewModel
import com.vis.example.coroutines.types.errorhandling.trycatch.TryCatchViewModel
import com.vis.example.coroutines.types.retrofit.parallel.ParallelNetworkCallsViewModel
import com.vis.example.coroutines.types.retrofit.series.SeriesNetworkCallsViewModel
import com.vis.example.coroutines.types.retrofit.single.SingleNetworkCallViewModel
import com.vis.example.coroutines.types.room.RoomDBViewModel
import com.vis.example.coroutines.types.task.onetask.LongRunningTaskViewModel
import com.vis.example.coroutines.types.task.twotasks.TwoLongRunningTasksViewModel

class UserViewModelFactory(private val userRepository: UserRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(userRepository) as T
        }
         if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
           return SeriesNetworkCallsViewModel(userRepository) as T
       }
       if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
           return ParallelNetworkCallsViewModel(userRepository) as T
       }
       if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
           return RoomDBViewModel(userRepository) as T
       }

       if (modelClass.isAssignableFrom(TryCatchViewModel::class.java)) {
           return TryCatchViewModel(userRepository) as T
       }
       if (modelClass.isAssignableFrom(ExceptionHandlerViewModel::class.java)) {
           return ExceptionHandlerViewModel(userRepository) as T
       }
       if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
           return LongRunningTaskViewModel(userRepository) as T
       }
       if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
           return TwoLongRunningTasksViewModel(userRepository) as T
       }
       if (modelClass.isAssignableFrom(IgnoreErrorAndContinueViewModel::class.java)) {
           return IgnoreErrorAndContinueViewModel(userRepository) as T
       }
        throw IllegalArgumentException("Unknown class name")
    }
}