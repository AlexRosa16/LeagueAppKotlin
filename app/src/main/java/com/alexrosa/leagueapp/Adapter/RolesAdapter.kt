package com.alexrosa.leagueapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Activities.CampeonesActivity
import com.alexrosa.leagueapp.Classes.Rol
import com.bumptech.glide.Glide
import com.alexrosa.leagueapp.R

class RolesAdapter(
    private val context: Context,
    private val roles: List<Rol>
) : RecyclerView.Adapter<RolesAdapter.RolViewHolder>() {

    class RolViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewRol: ImageView = view.findViewById(R.id.imageViewCards)
        val textViewTituloRol: TextView = view.findViewById(R.id.textViewTituloCards)
        val textViewDescripcionRol: TextView = view.findViewById(R.id.textViewDescripcionCards)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RolViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_principal, parent, false)
        return RolViewHolder(view)
    }

    override fun onBindViewHolder(holder: RolViewHolder, position: Int) {
        val rol = roles[position]

        holder.textViewTituloRol.text = rol.Nombre
        holder.textViewDescripcionRol.text = rol.descripcion

        Glide.with(holder.itemView.context)
            .load(rol.imagen)
            .centerCrop()
            .into(holder.imageViewRol)

        holder.itemView.setOnClickListener {
            val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("lastRol", rol.Nombre)
            editor.apply()

            val intent = Intent(context, CampeonesActivity::class.java)
            intent.putExtra("selectedRol", rol.Nombre)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = roles.size
}
