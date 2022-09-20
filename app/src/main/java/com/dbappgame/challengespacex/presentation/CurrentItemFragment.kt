package com.dbappgame.challengespacex.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.dbappgame.challengespacex.R
import com.dbappgame.challengespacex.databinding.FragmentCurrentItemBinding
import com.dbappgame.challengespacex.domain.model.Launch
import com.dbappgame.challengespacex.utils.loadImage

class CurrentItemFragment : Fragment() {

    private var _binding: FragmentCurrentItemBinding? = null
    private val binding get() = _binding!!
    private var currentLaunch: Launch? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCurrentItemBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        currentLaunch = if (Build.VERSION.SDK_INT >= 33) requireArguments()
            .getParcelable("LAUNCH", Launch::class.java)
        else {
            @Suppress("DEPRECATION") requireArguments().getParcelable("LAUNCH")
        }
        setView()
    }

    private fun setView() {

        currentLaunch?.let { launch ->
            val images = launch.links.flickrImages

            binding.imageBack.loadImage(
                context = requireContext(),
                url = if(images.isNotEmpty()) images.first() else "",
                drawable = ContextCompat.getDrawable(requireContext(),R.drawable.def)
            )

            binding.imageSmall.loadImage(
                context = requireContext(),
                url = launch.links.missionPatch,
                drawable = ContextCompat.getDrawable(requireContext(),R.drawable.def_rocket)
            )


            binding.tvMissionName.text = launch.missionName
            binding.tvRocket.text = "Rocket ${launch.rocket?.rocketName ?: "Not found"}"
            binding.tvDate.text = launch.launchDateLocal ?: "No Date"
            binding.tvDetail.text = launch.details ?: "No Detail"
        }
    }


    companion object {
        fun newInstance(launch: Launch) =
            CurrentItemFragment().apply { arguments = bundleOf(Pair("LAUNCH", launch)) }
    }

}