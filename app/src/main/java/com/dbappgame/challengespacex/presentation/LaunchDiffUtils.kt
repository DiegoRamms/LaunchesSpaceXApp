package com.dbappgame.challengespacex.presentation

import androidx.recyclerview.widget.DiffUtil
import com.dbappgame.challengespacex.domain.model.Launch

object LaunchDiffUtils: DiffUtil.ItemCallback<Launch>(){
    override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
        return  oldItem == newItem
    }

}