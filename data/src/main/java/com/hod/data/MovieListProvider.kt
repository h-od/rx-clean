package com.hod.data

import com.hod.domain.DataProvider
import com.hod.domain.entity.MovieList
import io.reactivex.Observable

class MovieListProvider: DataProvider<MovieList> {
    override fun put(data: MovieList) {
        TODO("not implemented")
    }

    override fun fetch(): Observable<MovieList> {
        TODO("not implemented")
    }

    override fun delete(data: MovieList) {
        TODO("not implemented")
    }
}
