package com.hod.rxclean

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

abstract class Presenter<in V : Presenter.View> {

    private lateinit var viewSubscriptions: CompositeDisposable

    @CallSuper
    protected open fun onViewAttached(view: V) {
        this.viewSubscriptions = CompositeDisposable()
    }

    @CallSuper
    open fun onViewDetached(view: V) {
        this.viewSubscriptions.clear()
    }

    private fun clearOnDetached(disposable: Disposable) {
        this.viewSubscriptions.add(disposable)
    }

    protected fun <T> Observable<T>.subscribeUntilDetached(): Disposable =
            subscribe().apply { clearOnDetached(this) }

    protected fun <T> Observable<T>.subscribeUntilDetached(onNext: (T) -> Unit): Disposable =
            subscribe(onNext).apply { clearOnDetached(this) }

    protected fun <T> Observable<T>.subscribeUntilDetached(onNext: (T) -> Unit, onError: (Throwable) -> Unit): Disposable =
            subscribe(onNext, onError).apply { clearOnDetached(this) }

    protected fun <T> Observable<T>.subscribeUntilDetached(onNext: (T) -> Unit, onError: (Throwable) -> Unit, onComplete: () -> Unit): Disposable =
            subscribe(onNext, onError, onComplete).apply { clearOnDetached(this) }

    interface View
}
