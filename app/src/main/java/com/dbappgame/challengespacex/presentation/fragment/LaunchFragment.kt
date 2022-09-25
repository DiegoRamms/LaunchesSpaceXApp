package com.dbappgame.challengespacex.presentation.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dbappgame.challengespacex.R
import com.dbappgame.challengespacex.databinding.FragmentLaunchBinding
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.presentation.adapter.LaunchAdapter
import com.dbappgame.challengespacex.presentation.viewmodel.LaunchViewModel
import com.dbappgame.challengespacex.utils.loadImage
import com.dbappgame.challengespacex.utils.show

class LaunchFragment : Fragment() {

    private var _binding: FragmentLaunchBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<LaunchViewModel>()
    private val launchAdapter by lazy { LaunchAdapter(::onClickLaunchItem) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLaunchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeAdapter()
        initializeObservers()


    }

    private fun initializeAdapter() {
        binding.rvLaunches.adapter = launchAdapter

        binding.rvLaunches.layoutManager =
            if (isLandscape()) GridLayoutManager(requireContext(), 2)
            else LinearLayoutManager(requireContext())
    }

    private fun initializeObservers() {
        viewModel.launches.observe(viewLifecycleOwner) {
            launchAdapter.submitList(it)
            if (isLandscape()) {
                val launch = (viewModel.launchSelected ?: it.first())
                setViewSelected(launch)
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner) {
            binding.progressLoading?.show(it)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun onClickLaunchItem(launch: Launch, position: Int) {
        viewModel.selectLaunch(launch, position)
        if (isLandscape()) setViewSelected(launch)
        else findNavController().navigate(R.id.action_launchFragment_to_launchDetailFragment)
    }


    private fun setViewSelected(launch: Launch) {
        if (isLandscape()) {
            binding.tvMission?.text = launch.missionName
            binding.date?.text = launch.launchDateLocal
            binding.site?.text = "Site: ${launch.launchSite?.siteName ?: "No Site"}"
            binding.description?.text = launch.details ?: "No Detail"
            val img =  if (launch.links.flickrImages.isNotEmpty()){
                launch.links.flickrImages.first()
            }else "https://www.enjpg.com/img/2020/Spacex.png"

            binding.imgBig?.loadImage(
                context = requireContext(),
                url = img
            )

            binding.imageSmall?.loadImage(
                context = requireContext(),
                url = launch.links.missionPatchSmall,
                drawable = ContextCompat.getDrawable(requireContext(),R.drawable.def_rocket)
            )





        }
    }

    private fun isLandscape() =
        resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE


}