package com.dbappgame.challengespacex.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.presentation.fragment.CurrentItemFragment

class LaunchViewPagerAdapter(private val launches : List<Launch>,fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount() = launches.size

    override fun createFragment(position: Int): Fragment {
        return CurrentItemFragment.newInstance(launches[position])
    }

}