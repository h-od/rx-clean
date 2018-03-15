package com.hod.data

import com.hod.domain.DataProvider
import com.hod.domain.entity.MovieDetail
import io.reactivex.Observable

class MovieDetailProvider: DataProvider<MovieDetail> {
    override fun put(data: MovieDetail) {
        TODO("not implemented")
    }

    override fun fetch(): Observable<MovieDetail> {
        TODO("not implemented")
    }

    override fun delete(data: MovieDetail) {
        TODO("not implemented")
    }
}
