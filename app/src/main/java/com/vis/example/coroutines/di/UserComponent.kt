package com.vis.example.coroutines.di

import com.vis.example.coroutines.di.module.DatabaseModule
import com.vis.example.coroutines.di.module.NetworkModule
import com.vis.example.coroutines.types.errorhandling.exceptionhandler.ExceptionHandlerActivity
import com.vis.example.coroutines.types.errorhandling.supervisor.IgnoreErrorAndContinueActivity
import com.vis.example.coroutines.types.errorhandling.trycatch.TryCatchActivity
import com.vis.example.coroutines.types.retrofit.parallel.ParallelNetworkCallsActivity
import com.vis.example.coroutines.types.retrofit.series.SeriesNetworkCallsActivity
import com.vis.example.coroutines.types.retrofit.single.SingleNetworkCallActivity
import com.vis.example.coroutines.types.room.RoomDBActivity
import com.vis.example.coroutines.types.task.onetask.LongRunningTaskActivity
import com.vis.example.coroutines.types.task.twotasks.TwoLongRunningTasksActivity
import com.vis.example.coroutines.types.timeout.TimeoutActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, NetworkModule::class])
interface UserComponent {

    fun inject(singleNetworkCallActivity: SingleNetworkCallActivity)
    fun inject(seriesNetworkCallsActivity: SeriesNetworkCallsActivity)
    fun inject(parallelNetworkCallsActivity: ParallelNetworkCallsActivity)
    fun inject(exceptionHandlerActivity: ExceptionHandlerActivity)
    fun inject(ignoreErrorAndContinueActivity: IgnoreErrorAndContinueActivity)
    fun inject(tryCatchActivity: TryCatchActivity)
    fun inject(roomDBActivity: RoomDBActivity)
    fun inject(longRunningTaskActivity: LongRunningTaskActivity)
    fun inject(twoLongRunningTasksActivity: TwoLongRunningTasksActivity)
    fun inject(timeoutActivity: TimeoutActivity)


}