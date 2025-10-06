package com.example.dogapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapp.databinding.DogItemBinding
import com.example.dogapp.model.DogBreed

class DogListAdapter(private val dogList: List<DogBreed>):  RecyclerView.Adapter<DogListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = DogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val dog = dogList[position]
        holder.onHolder(dog)
    }

    override fun getItemCount(): Int = dogList.size

    class ViewHolder(private val binding: DogItemBinding): RecyclerView.ViewHolder(binding.root){
        fun onHolder(dog: DogBreed){
            binding.dog = dog

        }
    }

}