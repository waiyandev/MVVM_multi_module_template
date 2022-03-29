package com.showti.features.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.showti.core.models.DogModel
import com.showti.core.utils.loadImage
import com.showti.features.R

class DogAdapter constructor(private val onClick: (DogModel)->Unit)  : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {


    var tracker: SelectionTracker<Long>? = null

    var dogList:List<DogModel> = arrayListOf()

    init {
        setHasStableIds(true)
    }

    inner class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val txtName:AppCompatTextView = itemView.findViewById(R.id.item_name)
        private val imgUrl:AppCompatImageView = itemView.findViewById(R.id.item_img)

        private var dogModel:DogModel? = null
        init {
            itemView.setOnClickListener {
                dogModel?.let(onClick)
            }
        }

        fun bind(value: DogModel, isActivated: Boolean = false) {
            dogModel = value
            txtName.text = value.name
            imgUrl.loadImage(value.url)
            itemView.isActivated = isActivated
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): Long? = itemId
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dogs,parent,false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {

        val dogModel = dogList[position]
        tracker?.let {
            holder.bind(dogModel, it.isSelected(position.toLong()))
        }
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getItemCount(): Int = dogList.size
}