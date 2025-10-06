package com.example.dogapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dogapp.R
import com.example.dogapp.databinding.FragmentDogListBinding
import com.example.dogapp.model.DogsApi
import com.example.dogapp.viewmodel.DogsApiService
import kotlinx.coroutines.launch

class DogListFragment : Fragment() {
    private lateinit var binding: FragmentDogListBinding
    private val dogService =  DogsApiService
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDogListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcvDogs.layoutManager = GridLayoutManager(requireContext(), 2)

        lifecycleScope.launch {
            try {
                val dogs = dogService.getAll()
                Log.e("EEEEEEE", dogs.toString())
                dogs.forEach { dog ->
                    dog.imageUrl = dogService.getImage(dog.getImgId).getUrl
                }
                Log.e("BBBBBB", dogs.toString())

                binding.rcvDogs.adapter = DogListAdapter(dogs)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}