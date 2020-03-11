package com.multimedia.aes.sgs.interfaces

interface CallbackInterface<T> {
    fun onComplete(result: Any)
    fun onException(e: Exception?)
}