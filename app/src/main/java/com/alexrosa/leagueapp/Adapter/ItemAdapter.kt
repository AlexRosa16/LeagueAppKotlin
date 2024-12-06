package com.alexrosa.leagueapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Classes.Item
import com.bumptech.glide.Glide
import com.alexrosa.leagueapp.R

class ItemAdapter(
    private val items: List<Item>,
    private val onButtonClicked: (Item) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imageViewCardsItem)
        val nombre: TextView = itemView.findViewById(R.id.textViewTituloCardsItem)
        val tipo: TextView = itemView.findViewById(R.id.textViewTipoItem)
        val stats: TextView = itemView.findViewById(R.id.textViewStatsItem)
        val boton: Button = itemView.findViewById(R.id.ntButtonLoginItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_items, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.nombre.text = item.nombre
        holder.tipo.text = item.tipoitem
        holder.stats.text = item.stats

        Glide.with(holder.itemView.context)
            .load(item.imagen)
            .into(holder.imagen)

        holder.boton.setOnClickListener {
            onButtonClicked(item)
        }
    }

    override fun getItemCount(): Int = items.size
}

