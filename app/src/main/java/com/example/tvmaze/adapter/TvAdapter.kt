package com.example.tvmaze.adapter

import TvMazeResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tvmaze.R
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.tv_item.view.*

class TvAdapter : RecyclerView.Adapter<TvAdapter.ViewHolder>() {

     val  tvMazeList = mutableListOf<TvMazeResponse>()


    override fun getItemCount(): Int =
        tvMazeList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.tv_item, parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tvMazeList[position])
    }


    fun updateData(tvMazeList: List<TvMazeResponse>) {
        val diffcallback = TvDiffUtils(this.tvMazeList, tvMazeList)
        val diffResult = DiffUtil.calculateDiff(diffcallback)
        this.tvMazeList.clear()
        this.tvMazeList.addAll(tvMazeList)
        diffResult.dispatchUpdatesTo(this)

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(result: TvMazeResponse) {
            with(itemView) {
                Picasso.get().load(result.image.medium).into(imageView)
                tvName.text = result.name
            }
        }
    }

}
