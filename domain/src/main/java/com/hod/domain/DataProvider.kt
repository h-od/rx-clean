package com.hod.domain

import io.reactivex.Observable

interface DataProvider<T> {
    fun put(data: T)
    fun fetch(): Observable<T>
    fun delete(data: T)
}