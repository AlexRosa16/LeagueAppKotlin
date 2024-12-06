package com.alexrosa.leagueapp.Adapter

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Classes.Campeon
import com.bumptech.glide.Glide
import com.alexrosa.leagueapp.R

class CampeonAdapter(
    var campeones: List<Campeon>,
    private val onButtonClicked: (Campeon) -> Unit,
    private val context: Context
) : RecyclerView.Adapter<CampeonAdapter.CampeonViewHolder>() {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("FAVORITOS", Context.MODE_PRIVATE)

    class CampeonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.imageViewCardsCampeon)
        val botonmegusta: Button = itemView.findViewById(R.id.imageViewMegustaCardsCampeon)
        val titulo: TextView = itemView.findViewById(R.id.textViewTituloCardsCampeon)
        val descripcion: TextView = itemView.findViewById(R.id.textViewDescripcionCardsCampeon)
        val habilidades: TextView = itemView.findViewById(R.id.textViewHabilidadesCampeon)
        val botonwiki: Button = itemView.findViewById(R.id.ntButtonLoginCampeon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampeonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_campeon, parent, false)
        return CampeonViewHolder(view)
    }

    override fun onBindViewHolder(holder: CampeonViewHolder, position: Int) {
        val campeon = campeones[position]

        holder.titulo.text = campeon.nombre
        holder.descripcion.text = campeon.descripcion
        holder.habilidades.text = campeon.habilidades

        Glide.with(holder.itemView.context)
            .load(campeon.imagen)
            .into(holder.imagen)

        if (isFavorito(campeon)) {
            holder.botonmegusta.setBackgroundResource(R.drawable.ic_favorite_on)
        } else {
            holder.botonmegusta.setBackgroundResource(R.drawable.ic_favorite_off)
        }

        holder.botonmegusta.setOnClickListener {
            if (isFavorito(campeon)) {
                removeFavorito(campeon)
                holder.botonmegusta.setBackgroundResource(R.drawable.ic_favorite_off)
            } else {
                addFavorito(campeon)
                holder.botonmegusta.setBackgroundResource(R.drawable.ic_favorite_on)
            }
            notifyItemChanged(position)
        }

        holder.itemView.setOnClickListener {
            onButtonClicked(campeon)
        }

        holder.botonwiki.setOnClickListener {
            val wikipediaUrl = "https://leagueoflegends.fandom.com/wiki/${campeon.nombre.replace(" ", "_")}/LoL"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaUrl))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = campeones.size

    private fun addFavorito(campeon: Campeon) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(campeon.nombre, true)
        editor.apply()
    }

    private fun removeFavorito(campeon: Campeon) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(campeon.nombre, false)
        editor.apply()
    }

    private fun isFavorito(campeon: Campeon): Boolean {
        return sharedPreferences.getBoolean(campeon.nombre, false)
    }
}
