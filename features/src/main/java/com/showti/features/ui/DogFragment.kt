package com.showti.features.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.showti.core.binding.BindingFragment
import com.showti.core.models.DogModel
import com.showti.core.utils.NetworkResult
import com.showti.core.utils.debugLog
import com.showti.core.utils.loadImage
import com.showti.core.utils.toastMsg
import com.showti.features.R
import com.showti.features.databinding.FragmentDogBinding
import com.showti.features.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DogFragment : BindingFragment<FragmentDogBinding>(R.layout.fragment_dog) {

    private val dogViewModels:DogViewModel by viewModels()

    var dogModel:DogModel = DogModel()

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

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()

        binding.imgReplay.setOnClickListener {
            binding.toggleBtn.isChecked = false
            fetchResponse()
        }

        binding.toggleBtn.addOnCheckedChangeListener { button, isChecked ->

            button.setOnClickListener {
                if(isChecked){
                    dogViewModels.insertDog(dogModel)
                    button.text = resources.getString(R.string.btn_added)
                }else{
                    dogViewModels.deleteDog(dogViewModels.insertId.value!!.toInt())
                    button.text = resources.getString(R.string.btn_add)
                }
            }


        }

    }

    override fun onPause() {
        super.onPause()
        binding.toggleBtn.isChecked = false
    }

    private fun fetchData(){
        dogViewModels.response.observe(viewLifecycleOwner) { it ->
           when (it) {
               is NetworkResult.Success -> {
                   binding.loading.visibility = View.GONE
                   it.data.let {
                        dogModel.apply {
                            name = it?.message?.split("/")?.get(4).toString()
                            url = it?.message.toString()
                        }
                       binding.dogName.text = dogModel.name.uppercase()
                       debugLog("data:${it?.message?.split("/")?.get(4)}")
                       binding.dogImage.loadImage(dogModel.url)
                   }
               }
               is NetworkResult.Error -> {
                   toastMsg("Error :${it.message}")
                   debugLog("Error: ${it.message}")
               }

               is NetworkResult.Loading -> {
                   binding.loading.visibility = View.VISIBLE
                   debugLog("Loading")
               }
           }
       }
   }

   private fun fetchResponse(){
       dogViewModels.getResponse()
       binding.loading.visibility = View.VISIBLE
   }

}