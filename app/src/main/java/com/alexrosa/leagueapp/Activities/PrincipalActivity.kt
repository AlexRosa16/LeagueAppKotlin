package com.alexrosa.leagueapp.Activities

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alexrosa.leagueapp.R
import android.content.SharedPreferences
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Adapter.PrincipalAdapter
import com.alexrosa.leagueapp.Classes.Cards
import com.bumptech.glide.Glide

class PrincipalActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val fondoprincipal = findViewById<ImageView>(R.id.fondoPrincipal)

        Glide.with(this)
            .load(R.drawable.dianaluna)
            .into(fondoprincipal)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPrincipal)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cards = listOf(
            Cards(
                1,
                "Roles",
                "Los roles se refieren a las posiciones que un jugador asume dentro de una partida. Cada rol está asociado con diferentes carriles en el mapa y estilos de juego específicos.",
                R.drawable.roles,
            ),
            Cards(
                2,
                "Items",
                "Los ítems son herramientas fundamentales que potencian a los campeones, mejoran sus habilidades y les permiten cumplir con sus roles de manera más eficiente.",
                R.drawable.items,
            ),
            Cards(
                3,
                "Favoritos",
                "Una seccion donde puedes ver tanto tus roles, campeones y items favoritos",
                R.drawable.pyke,
            )
        )

        recyclerView.adapter = PrincipalAdapter(this, cards)

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val lastCard = sharedPreferences.getString("lastCard", null)

        if (lastCard != null) {
            Toast.makeText(this, "Última Card leída: $lastCard", Toast.LENGTH_SHORT).show()
        }

    }
}
