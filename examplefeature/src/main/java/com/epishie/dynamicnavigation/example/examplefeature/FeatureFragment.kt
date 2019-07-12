package com.epishie.dynamicnavigation.example.examplefeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.epishie.dynamicnavigation.example.examplefeature.databinding.FragmentFeatureBinding


class FeatureFragment : Fragment() {
    private lateinit var binding: FragmentFeatureBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeatureBinding.inflate(inflater, container, false)
        return binding.root
    }
}
