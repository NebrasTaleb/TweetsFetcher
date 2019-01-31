package com.example.nebrasvm.tttapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ListAdapter : RecyclerView.Adapter<ListAdapter.ItemHolder>() {

    private var itemsList : List<ListItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var itemView : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item , parent , false)
        return ItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var currentItem : ListItem = itemsList.get(position)
        holder.text.setText(currentItem.getText())
        holder.imageView.setImageResource((currentItem.getImage()))

    }

    fun setItems(items : List<ListItem>){
        this.itemsList = items
        notifyDataSetChanged()
    }

    class ItemHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
         var text : TextView
         var imageView: ImageView

        init {
            text = itemView.findViewById(R.id.item_text)
            imageView = itemView.findViewById(R.id.item_image)
        }
    }
}