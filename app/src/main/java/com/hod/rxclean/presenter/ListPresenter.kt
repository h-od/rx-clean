package com.hod.rxclean.presenter

import com.hod.domain.Movies
import com.hod.rxclean.Presenter
import com.hod.rxclean.model.Movie
import com.hod.rxclean.model.toModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListPresenter : Presenter<ListPresenter.View>() {

    //    @Inject
    lateinit var movies: Movies
//    val movies by lazy { Movies() }

    public override fun onViewAttached(view: View) {
        super.onViewAttached(view)

        view.data()
                .flatMap { movies.list(1) }
                .map { it.results.toModel() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeUntilDetached(view::displayList)

        view.longClicks()
                .map { movies.remove(it).toModel() }
                .subscribeUntilDetached(view::removeListItem)

        view.clicks()
                .subscribeUntilDetached(view::displayDetail)
    }

    interface View : Presenter.View {
        fun clicks(): Observable<Int>
        fun longClicks(): Observable<Int>
        fun data(): Observable<Unit>

        fun displayList(movies: List<Movie>)
        fun displayDetail(code: Int)
        fun removeListItem(movie: Movie)
    }
}
