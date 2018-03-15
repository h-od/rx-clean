package com.hod.device

import com.hod.domain.DataProvider
import com.hod.domain.entity.Analytic
import io.reactivex.Observable

class Analytics: DataProvider<Analytic> {
    override fun put(t: Analytic) {
        TODO("not implemented")
    }

    override fun fetch(): Observable<Analytic> {
        TODO("not implemented")
    }

    override fun delete(t: Analytic) {
        TODO("not implemented")
    }
}
