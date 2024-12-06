package com.alexrosa.leagueapp.Activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Classes.Campeon
import com.alexrosa.leagueapp.Adapter.CampeonAdapter
import com.alexrosa.leagueapp.R
import com.bumptech.glide.Glide

class FavoritosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        val fondofavoritos = findViewById<ImageView>(R.id.fondoFavoritos)

        Glide.with(this)
            .load(R.drawable.dianaluna)
            .into(fondofavoritos)

        recyclerView = findViewById(R.id.recyclerViewFavoritos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        sharedPreferences = getSharedPreferences("FAVORITOS", Context.MODE_PRIVATE)

        val campeonesFavoritos = obtenerCampeonesFavoritos()

        val adapter = CampeonAdapter(campeonesFavoritos, { campeon ->
            if (isFavorito(campeon)) {
                removeFavorito(campeon)
            } else {
                addFavorito(campeon)
            }
            actualizarVistaFavoritos()
        }, this)

        recyclerView.adapter = adapter
    }

    private fun obtenerCampeonesFavoritos(): List<Campeon> {
        val campeones = listOf(
            Campeon("Darius", "El maestro de Noxus", "Hacha giratoria, Hemorragia, Decapitación, Noxian Guillotine", "https://www.mobafire.com/images/champion/square/darius.png",false),
            Campeon("Shen", "El ninja protector", "Protección espiritual, Hoja fatal, Atajo, Fortaleza del espíritu", "https://www.mobafire.com/images/champion/square/shen.png",false),
            Campeon("Renekton", "El carnívoro", "Corte voraz, Embate, Ira de Renekton, Dominación", "https://www.mobafire.com/images/champion/square/renekton.png",false),
            Campeon("Aatrox", "El verdugo de los cielos", "Corte de sangre, Lanza de Aatrox, El fin del mundo, Descenso de la sangre", "https://www.mobafire.com/images/champion/square/aatrox.png",false),
            Campeon("Jax", "El maestro de armas", "Golpe de la espada, Salto, Venganza, Despertar", "https://www.mobafire.com/images/champion/square/jax.png",false),
            Campeon("Lee Sin", "El monje ciego", "Sonic Wave, Tempestad, Carga resonante, Golpe doble", "https://www.mobafire.com/images/champion/square/lee-sin.png",false),
            Campeon("Kha'Zix", "El depredador", "Salto, Resurrección, Sabores, Carga letal", "https://www.mobafire.com/images/champion/square/khazix.png",false),
            Campeon("Nidalee", "La cazadora", "Jabalina, Salto, Azote, Caza", "https://www.mobafire.com/images/champion/square/nidalee.png",false),
            Campeon("Warwick", "El cazador, el lobo", "Golpe sangriento, Sed de sangre, Caza imparable, Llamado del lobo", "https://www.mobafire.com/images/champion/square/warwick.png",false),
            Campeon("Graves", "El vaquero", "Disparo a quemarropa, Persecución, Escudo, Asalto", "https://www.mobafire.com/images/champion/square/graves.png",false),
            Campeon("Ahri", "El zorro de nueve colas", "Orb de Deception, Charm, Espíritu volador, Fuerza embriagadora", "https://www.mobafire.com/images/champion/square/ahri.png",false),
            Campeon("Zed", "El maestro de las sombras", "Shuriken, Marca de la muerte, Sombras vivientes, Muerte imparable", "https://www.mobafire.com/images/champion/square/zed.png",false),
            Campeon("Orianna", "La mecanomante", "Esfera de comando, Comando de choque, Comando de zona, Ruptura de órbita", "https://www.mobafire.com/images/champion/square/orianna.png",false),
            Campeon("Syndra", "La reina de las esferas", "Esfera, Explosión de esferas, Fuerza de la oscuridad, Potencia máxima", "https://www.mobafire.com/images/champion/square/syndra.png",false),
            Campeon("Lux", "La dama luminosa", "Luz cegadora, Bola de luz, Barrera de luz, Llama solar", "https://www.mobafire.com/images/champion/square/lux.png",false),
            Campeon("Jinx", "La reina del caos", "Disparo rápido, Super cohete, Pasión explosiva, Cañón de riel", "https://www.mobafire.com/images/champion/square/jinx.png",false),
            Campeon("Kai'Sa", "La hija del vacío", "Lluvia de misiles, Pasaje del vacío, Carga de vacío, Vínculo mortal", "https://www.mobafire.com/images/champion/square/kaisa.png",false),
            Campeon("Miss Fortune", "La dama de las armas", "Disparo doble, Ráfaga de bala, Lluvia de balas, Balas encantadas", "https://www.mobafire.com/images/champion/square/miss-fortune.png",false),
            Campeon("Ezreal", "El explorador prodigioso", "Disparo místico, Fuego de arcángel, Sobrecarga, Puño de arcángel", "https://www.mobafire.com/images/champion/square/ezreal.png",false),
            Campeon("Ashe", "La reina de los francotiradores", "Tiro de hielo, Flecha de cristal, Tormenta de flechas, Flecha congelada", "https://www.mobafire.com/images/champion/square/ashe.png",false),
            Campeon("Leona", "La amanecer radiante", "Escudo solar, Llama solar, Eclipse, Luz radiante", "https://www.mobafire.com/images/champion/square/leona.png",false),
            Campeon("Janna", "La furia del viento", "Ventolera, Onda de viento, Murmullo, Tormenta de arena", "https://www.mobafire.com/images/champion/square/janna.png",false),
            Campeon("Nami", "La marea", "Aguas profundas, Curación marina, Ola mística, Resplandor del océano", "https://www.mobafire.com/images/champion/square/nami.png",false),
            Campeon("Thresh", "El carcelero", "Linterna, Ira de la oscuridad, Golpe mortal, Aniquilación de almas", "https://www.mobafire.com/images/champion/square/thresh.png",false),
            Campeon("Alistar", "El minotauro", "Carga, Puño doble, Matanza, Estampida", "https://www.mobafire.com/images/champion/square/alistar.png",false)
        )

        return campeones.filter { isFavorito(it) }
    }

    private fun isFavorito(campeon: Campeon): Boolean {
        return sharedPreferences.getBoolean(campeon.nombre, false)
    }

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

    private fun actualizarVistaFavoritos() {
        val campeonesFavoritosActualizados = obtenerCampeonesFavoritos()
        (recyclerView.adapter as CampeonAdapter).apply {
            this.campeones = campeonesFavoritosActualizados
        }
    }
}
