package com.showti.features.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.showti.core.binding.BindingFragment
import com.showti.core.models.DogModel
import com.showti.core.utils.debugLog
import com.showti.features.R
import com.showti.features.databinding.FragmentDetailBinding
import com.showti.features.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment:BindingFragment<FragmentDetailBinding>(R.layout.fragment_detail) {

    private val dogVM:DogViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            dogViewModel = dogVM
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        debugLog("name :${arguments?.getString("name")}")
        binding.txtName.text = arguments?.getString("name")
    }
}