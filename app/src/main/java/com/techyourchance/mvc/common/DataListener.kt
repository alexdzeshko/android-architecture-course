package com.techyourchance.mvc.common

interface DataListener<T> {
    fun onSuccess(data: T)
    fun onError(t: Throwable)
}