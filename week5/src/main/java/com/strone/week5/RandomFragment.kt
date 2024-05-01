package com.strone.week5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.strone.week5.databinding.FragmentRandomBinding

class RandomFragment : Fragment() {
    private lateinit var binding: FragmentRandomBinding
    private val count : Int by lazy {
        arguments?.getInt("count") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRandomBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val random = (0..count).random()
        binding.tvRandomCaption.text = "Random between 0 and $count"
        binding.tvRandom.text = random.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(count: Int) =
            RandomFragment().apply {
                arguments = Bundle().apply {
                    putInt("count", count)
                }
            }
    }
}