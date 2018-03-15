package com.hod.rxclean.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hod.rxclean.presenter.DetailPresenter
import io.reactivex.Observable

class DetailFragment: android.app.Fragment(), DetailPresenter.View {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun next(): Observable<Unit> {
        TODO("emmit when swipe from right to left")
    }

    override fun previous(): Observable<Unit> {
        TODO("emmit when swipe from left to right")
    }
}
