package com.berezhnoyyuri9999.cocktaildb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.cocktaildb.R
import com.berezhnoyyuri9999.cocktaildb.data.model.DataCocktails
import com.squareup.picasso.Picasso

class CocktailAdapter : RecyclerView.Adapter<CocktailAdapter.ViewHolder>() {

    private val listCocktail: MutableList<DataCocktails> = ArrayList()

    fun setData(newList: List<DataCocktails>) {
        listCocktail.clear()
        listCocktail.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_cocktail, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listCocktail[position]
        Picasso.get().load(listCocktail[position].image).into(holder.image)

        holder.group.text = list.group
        holder.title.text = list.title
    }

    override fun getItemCount() = listCocktail.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var group: TextView
        var image: ImageView
        var title: TextView

        init {
            group = itemView.findViewById(R.id.tvGroupCocktail)
            image = itemView.findViewById(R.id.ivImageCocktail)
            title = itemView.findViewById(R.id.tvTitleCocktail)
        }

    }

}