package com.techyourchance.mvc.common


abstract class UseCase<ListenerType> {
    protected val listeners = ArrayList<ListenerType>()

    fun registerListener(listener: ListenerType) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: ListenerType) {
        listeners.remove(listener);
    }
}