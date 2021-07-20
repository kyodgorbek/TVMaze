package com.example.tvmaze.adapter

import TvMazeResponse
import androidx.recyclerview.widget.DiffUtil

class TvDiffUtils( private val oldList: List<TvMazeResponse>,
private val newList: List<TvMazeResponse>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

}