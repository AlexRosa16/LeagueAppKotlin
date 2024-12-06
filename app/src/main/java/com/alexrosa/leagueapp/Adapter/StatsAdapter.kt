package com.alexrosa.leagueapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Activities.ItemsActivity
import com.alexrosa.leagueapp.Classes.Stat
import com.alexrosa.leagueapp.R
import com.bumptech.glide.Glide


class StatsAdapter(
    private val context: Context,
    private val stats: List<Stat>
) : RecyclerView.Adapter<StatsAdapter.StatViewHolder>() {

    class StatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewRol: ImageView = view.findViewById(R.id.imageViewCards)
        val textViewTituloRol: TextView = view.findViewById(R.id.textViewTituloCards)
        val textViewDescripcionRol: TextView = view.findViewById(R.id.textViewDescripcionCards)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_principal, parent, false)
        return StatViewHolder(view)
    }

    override fun onBindViewHolder(holder: StatViewHolder, position: Int) {
        val stat = stats[position]

        holder.textViewTituloRol.text = stat.Nombre
        holder.textViewDescripcionRol.text = stat.descripcion

        Glide.with(holder.itemView.context)
            .load(stat.imagen)
            .centerCrop()
            .into(holder.imageViewRol)

        holder.itemView.setOnClickListener {
            val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("lastStat", stat.Nombre)
            editor.apply()

            val intent = Intent(context, ItemsActivity::class.java)
            intent.putExtra("selectedStat", stat.Nombre)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = stats.size
}
