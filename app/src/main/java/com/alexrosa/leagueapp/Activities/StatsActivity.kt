package com.alexrosa.leagueapp.Activities

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Adapter.StatsAdapter
import com.alexrosa.leagueapp.R
import com.alexrosa.leagueapp.Classes.Stat
import com.bumptech.glide.Glide

class StatsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_concategorias)

        val fondostats = findViewById<ImageView>(R.id.fondoPrincipal)
        Glide.with(this)
            .load(R.drawable.dianaluna)
            .into(fondostats)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRoles)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val stats = listOf(
            Stat(
                1,
                "AttackDamage",
                "Representa el daño físico que un campeón inflige con sus ataques básicos y habilidades basadas en daño físico.",
                R.drawable.ad
            ),
            Stat(
                2,
                "AbilityPower",
                "Representa el poder de habilidad que aumenta el daño de las habilidades basadas en magia de un campeón.",
                R.drawable.ability
            ),
            Stat(
                3,
                "Health",
                "Es la cantidad de vida total de un campeón; si llega a cero, el campeón muere.",
                R.drawable.vida
            ),
            Stat(
                4,
                "MagicResist",
                "Reduce el daño de las habilidades basadas en magia que recibe un campeón.",
                R.drawable.glacial
            ),
            Stat(
                5,
                "Armor",
                "Reduce el daño físico que recibe un campeón de los ataques básicos y habilidades físicas.",
                R.drawable.font
            )
        )

        val rolesAdapter = StatsAdapter(this, stats)
        recyclerView.adapter = rolesAdapter

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply()
    }
}


