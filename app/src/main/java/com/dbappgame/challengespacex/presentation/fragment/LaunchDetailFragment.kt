package com.dbappgame.challengespacex.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dbappgame.challengespacex.databinding.FragmentLaunchDetailBinding
import com.dbappgame.challengespacex.presentation.viewmodel.LaunchViewModel
import com.dbappgame.challengespacex.presentation.adapter.LaunchViewPagerAdapter
import com.dbappgame.challengespacex.utils.ZoomOutPageTransformer


class LaunchDetailFragment: Fragment() {

    private var _binding: FragmentLaunchDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<LaunchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaunchDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.launches.value?.let {
            val adapter = LaunchViewPagerAdapter(it,requireActivity())


            binding.pager.adapter =  adapter
            binding.pager.setCurrentItem(viewModel.currentPosition,false)
            binding.pager.setPageTransformer(ZoomOutPageTransformer())
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}