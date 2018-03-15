package com.hod.rxclean.presenter

import com.hod.rxclean.Presenter
import io.reactivex.Observable

class DetailPresenter: Presenter<DetailPresenter.View>() {

    override fun onViewAttached(view: View) {
        super.onViewAttached(view)



        view.next().subscribeUntilDetached { productCode ->  }
    }

    interface View: Presenter.View {
        fun next(): Observable<Unit>
        fun previous(): Observable<Unit>
    }
}
