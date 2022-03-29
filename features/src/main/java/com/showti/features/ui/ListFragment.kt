package com.showti.features.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavDeepLink
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.showti.core.binding.BindingFragment
import com.showti.core.models.DogModel
import com.showti.core.utils.debugLog
import com.showti.core.utils.toastMsg
import com.showti.features.R
import com.showti.features.adapter.CustomItemKeyProvider
import com.showti.features.adapter.DogAdapter
import com.showti.features.adapter.MyItemDetailsLookup
import com.showti.features.databinding.FragmentListBinding
import com.showti.features.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BindingFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val dogViewModels: DogViewModel by viewModels()

    private val adapter = DogAdapter {
        onClickItem(it)
    }
    private var tracker: SelectionTracker<Long>? = null

    private var dogList: List<DogModel> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding {
            dogViewModel = dogViewModels
        }.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dogViewModels.getAllDogs()

        observeData()

        binding.dogRecyclerView.adapter = adapter
        setUpTracker()

    }


    @SuppressLint("NotifyDataSetChanged")
    private fun observeData() {

        dogViewModels.dogResponse.observe(viewLifecycleOwner) { lists ->
            debugLog("data:${lists}")
            if (lists.isNotEmpty()) {
                dogList = lists
                adapter.dogList = lists
                adapter.notifyDataSetChanged()

            }
        }
    }

    private fun onClickItem(dogModel: DogModel) {

        val bundle = bundleOf("name" to dogModel.name)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment2,bundle)

    }

    override fun onPause() {
        super.onPause()
        setActionBarNormal()
    }

    private fun setActionBarNormal() {
        (activity as AppCompatActivity).supportActionBar?.title = resources.getString(R.string.app_name)
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
            ColorDrawable(resources.getColor(R.color.purple_500))
        )
        setHasOptionsMenu(false)
    }


    private fun setUpTracker() {
        tracker = SelectionTracker.Builder<Long>(
            "mySelection",
            binding.dogRecyclerView,
            CustomItemKeyProvider(binding.dogRecyclerView),
            MyItemDetailsLookup(binding.dogRecyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()
                    val nItems: Int? = tracker?.selection!!.size()
                    if (nItems != null && nItems > 0) {

                        val title = if(nItems == 1){
                            "$nItems item selected"
                        }else{
                            "$nItems items selected"
                        }
                        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(
                            ColorDrawable(Color.parseColor("#ef6c00"))
                        )
                        (activity as AppCompatActivity).supportActionBar?.title = title
                        setHasOptionsMenu(true)
                    } else {
                        setActionBarNormal()
                    }
                }
            })

        adapter.tracker = tracker

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete, menu)
        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.delete_item -> {
                tracker?.selection!!.map {
                    dogViewModels.deleteDog(dogList[it.toInt()].id!!)
                }
                tracker?.clearSelection()
                dogViewModels.getAllDogs()

            }
        }
        return super.onOptionsItemSelected(item)
    }

}