package com.hod.rxclean.view

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.hod.rxclean.R
import com.hod.rxclean.model.Movie
import com.hod.rxclean.presenter.ListPresenter
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.view.longClicks
import io.reactivex.Observable

class ListFragment : android.app.Fragment(), ListPresenter.View {

    private val presenter = ListPresenter()
    private val adapter = Adapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_list, container, false).findViews()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewAttached(this)
    }

    override fun onDestroyView() {
        presenter.onViewDetached(this)
        super.onDestroyView()
    }

    override fun displayList(movies: List<Movie>) {
        adapter.addItems(movies)
        adapter.notifyDataSetChanged()
    }

    override fun displayDetail(code: Int) {
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putInt("code", code)
        detailFragment.arguments = bundle

        fragmentManager.beginTransaction()
                .replace(R.id.container, detailFragment)
                .addToBackStack("detail")
                .commit()
    }

    override fun removeListItem(movie: Movie) {
        adapter.removeItem(movie)
    }

    override fun clicks(): Observable<Int> = adapter.clicks()

    override fun longClicks(): Observable<Int> = adapter.longClicks()

    override fun data(): Observable<Unit> = TODO()

    private fun View.findViews(): View {
        val recyclerView = this.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        return this
    }
}

class Adapter : RecyclerView.Adapter<Adapter.Vh>() {
    private val data = ArrayList<Movie>()
    private val clicks = ArrayList<Observable<Int>>()
    private val longClicks = ArrayList<Observable<Int>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            Vh(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))


    override fun onBindViewHolder(holder: Adapter.Vh, position: Int) {
        holder.title.text = data[position].title
        holder.image.loadImage(data[position].posterPath)
        clicks.add(holder.itemView.clicks().map { data[position].id })
        longClicks.add(holder.itemView.longClicks().map { data[position].id })
    }

    override fun getItemCount(): Int = data.size

    fun addItems(movies: List<Movie>) = data.addAll(movies)

    fun removeItem(movie: Movie) = data.remove(movie)

    fun clicks(): Observable<Int> = Observable.merge(clicks)

    fun longClicks(): Observable<Int> = Observable.merge(longClicks)

    fun bottomReached(): Observable<Unit> = TODO()

    class Vh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
    }

    private fun ImageView.loadImage(posterPath: String?) {
        Glide.with(this.context)
                .load("https://image.tmdb.org/t/p/w500$posterPath")
                .into(this)
    }
}
