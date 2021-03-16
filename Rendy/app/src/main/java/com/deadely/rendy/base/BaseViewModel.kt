package com.deadely.rendy.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseViewModel : ViewModel() {
    protected val channel = Channel<Event>()
    val events: Flow<Event> = channel.receiveAsFlow()
}

open class Event
