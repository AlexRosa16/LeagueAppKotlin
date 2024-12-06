package com.alexrosa.leagueapp.Adapter
import com.alexrosa.leagueapp.Classes.Cards
import com.alexrosa.leagueapp.R
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Activities.FavoritosActivity
import com.alexrosa.leagueapp.Activities.RolesActivity
import com.alexrosa.leagueapp.Activities.StatsActivity
import com.bumptech.glide.Glide

class PrincipalAdapter(
    private val context: Context,
    private val cards: List<Cards>) : RecyclerView.Adapter<PrincipalAdapter.CardsViewHolder>() {

    class CardsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCard: ImageView = view.findViewById(R.id.imageViewCards)
        val textViewTituloCard: TextView = view.findViewById(R.id.textViewTituloCards)
        val textViewDescripcionCard: TextView = view.findViewById(R.id.textViewDescripcionCards)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_principal, parent, false)
        return CardsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        val card = cards[position]

        holder.textViewTituloCard.text = card.titulo
        holder.textViewDescripcionCard.text = card.descripcion


        Glide.with(holder.itemView.context)
            .load(card.imagen)
            .centerCrop()
            .into(holder.imageViewCard)


        holder.itemView.setOnClickListener {
            val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("lastCard", card.titulo)
            editor.apply()

            if(position == 0){
                val intent = Intent(context,RolesActivity::class.java)
                context.startActivity(intent)
            }

            if(position == 1){
                val intent = Intent(context,StatsActivity::class.java)
                context.startActivity(intent)
            }

            if(position == 2){
                val intent = Intent(context,FavoritosActivity::class.java)
                context.startActivity(intent)
            }


        }
    }


    override fun getItemCount(): Int = cards.size
}
