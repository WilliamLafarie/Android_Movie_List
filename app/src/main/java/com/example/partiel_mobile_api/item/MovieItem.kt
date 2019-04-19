package com.example.partiel_mobile_api.item

import android.view.View
import com.bumptech.glide.Glide
import com.example.partiel_mobile_api.R
import com.example.partiel_mobile_api.model.Movie
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.cell_movie.view.*

/*

    [Class MovieItem]

    View of each cell

*/

class MovieItem(val movie: Movie): AbstractItem<MovieItem, MovieItem.MovieViewHolder>() {

    override fun getType(): Int {

        //Return an unique ID for each cell
        return R.id.cell_title
    }

    // Method calls when we'll need a new cell (View)
    override fun getViewHolder(v: View): MovieViewHolder {

        return MovieViewHolder(v)
    }

    // Method calls to get the layout
    override fun getLayoutRes(): Int {

        return R.layout.cell_movie
    }

    // Correspond to the graphic cell's view
    class MovieViewHolder(itemView: View) : FastAdapter.ViewHolder<MovieItem>(itemView) {

        // Clean and recycle the cell
        override fun unbindView(item: MovieItem) {

            itemView.cell_title.text = null
        }

        // Update the cell's view
        override fun bindView(item: MovieItem, payloads: MutableList<Any>) {

            val movie = item.movie

            // Get each cell's information and print them

            itemView.cell_title.text = movie.title

            Glide
                .with(itemView.cell_picture)
                .load(movie.posterUrl)
                .into(itemView.cell_picture)
        }


        }
    }