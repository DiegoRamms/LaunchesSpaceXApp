package com.dbappgame.challengespacex.presentation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.dbappgame.challengespacex.domain.model.Launch

class LaunchViewPagerAdapter(private val launches : List<Launch>,fm: FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount() = launches.size

    override fun createFragment(position: Int): Fragment {
        return CurrentItemFragment.newInstance(launches[position])
    }

}