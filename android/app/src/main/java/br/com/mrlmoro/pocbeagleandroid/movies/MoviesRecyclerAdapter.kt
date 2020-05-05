package br.com.mrlmoro.pocbeagleandroid.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.mrlmoro.pocbeagleandroid.R
import br.com.mrlmoro.pocbeagleandroid.widget.loadUrl
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesRecyclerAdapter(
    private val scaleType: ImageView.ScaleType
) : RecyclerView.Adapter<MoviesRecyclerAdapter.ViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    var clickListener: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.itemView.iv_banner.scaleType = scaleType
        holder.itemView.iv_banner.loadUrl(movie.bannerUrl)
        holder.itemView.tv_title.text = movie.title
        holder.itemView.card.setOnClickListener {
            clickListener?.invoke(movie)
        }
    }

    fun notify(movies: List<Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}