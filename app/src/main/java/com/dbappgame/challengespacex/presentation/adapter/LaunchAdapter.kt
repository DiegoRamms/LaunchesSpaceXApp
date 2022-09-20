package com.dbappgame.challengespacex.presentation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dbappgame.challengespacex.R
import com.dbappgame.challengespacex.databinding.ItemLaunchBinding
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.utils.loadImage


class LaunchAdapter(private val listener: ((Launch,Int) -> Unit)) :
    ListAdapter<Launch, LaunchAdapter.LaunchViewHolder>(LaunchDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LaunchViewHolder(
            ItemLaunchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), parent.context
        )
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = getItem(position)
        holder.onBind(launch)
    }

    inner class LaunchViewHolder(private val binding: ItemLaunchBinding,private val context: Context) :
        ViewHolder(binding.root) {

        fun onBind(launch: Launch) {
            launch.missionName?.let { binding.tvLaunchName.text = it }
            binding.cardView.setOnClickListener {
                listener(launch, adapterPosition)
            }
            launch.rocket?.rocketName?.let { binding.tvRocket.text = "Rocket: $it" }
            launch.launchYear?.let { binding.tvYear.text = "Launched in $it" }

            binding.imageView.loadImage(
                context = context ,
                url = launch.links.missionPatchSmall,
                drawable = ContextCompat.getDrawable(context,R.drawable.def_rocket)
            )
        }

    }

}





