package com.showti.temphilt.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import com.showti.temphilt.R
import com.showti.temphilt.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding:FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHostFragment = childFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavFragment.setupWithNavController(navController)

        binding.bottomNavFragment.setOnItemReselectedListener {
            Log.d("MainFragment.onRe","reselected")
        }

    }

}