package com.hod.domain

interface DataProvider<T> {
    fun put(data: T)
    fun fetch(): T
    fun delete(data: T)
}