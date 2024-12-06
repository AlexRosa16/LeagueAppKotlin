package com.alexrosa.leagueapp.Activities

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.R
import com.alexrosa.leagueapp.Adapter.RolesAdapter
import com.alexrosa.leagueapp.Classes.Rol
import com.bumptech.glide.Glide

class RolesActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concategorias)

        val fondoroles = findViewById<ImageView>(R.id.fondoPrincipal)

        Glide.with(this)
            .load(R.drawable.dianaluna)
            .into(fondoroles)


        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewRoles)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val roles = listOf(
            Rol(
                1,
                "Top",
                "Campeones resistentes o autosuficientes que dominan la línea superior, liderando peleas y presionando torres.",
                R.drawable.topprueba,
            ),
            Rol(
                2,
                "Jungla",
                "Moviéndose entre líneas, controlan objetivos clave, apoyan con emboscadas (ganks) y deciden el ritmo del juego.",
                R.drawable.jungla,
            ),
            Rol(
                3,
                "Mid",
                "Especialistas en daño explosivo o control de peleas, dominan el mapa y rotan para apoyar líneas aliadas.",
                R.drawable.mid,
            ),
            Rol(
                4,
                "AdCarry",
                "Infligen daño constante desde la distancia, son frágiles al inicio pero cruciales en el juego tardío.",
                R.drawable.adc,
            ),
            Rol(
                5,
                "Support",
                "Protegen al ADC, controlan la visión del mapa y ayudan al equipo con habilidades de utilidad o control.",
                R.drawable.support,
            )
        )

        val rolesAdapter = RolesAdapter(this, roles)
        recyclerView.adapter = rolesAdapter

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply()
    }
}



