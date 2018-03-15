package com.hod.domain

import com.hod.domain.entity.Movie
import com.hod.domain.entity.MovieDetail
import com.hod.domain.entity.MovieList
import io.reactivex.Observable

class Movies(
        private val detail: DataProvider<MovieDetail>, private val list: DataProvider<MovieList>) {

    fun detail(id: Int): Observable<MovieDetail> = detail.fetch()

    fun list(id: Int): Observable<MovieList> = list.fetch()

    fun remove(id: Int): Movie = TODO("not implemented")
}
