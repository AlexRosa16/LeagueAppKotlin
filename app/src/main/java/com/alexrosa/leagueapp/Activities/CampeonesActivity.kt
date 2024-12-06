package com.alexrosa.leagueapp.Activities

import android.annotation.SuppressLint
import com.alexrosa.leagueapp.Adapter.CampeonAdapter
import com.alexrosa.leagueapp.R
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Classes.Campeon
import com.bumptech.glide.Glide
    

class CampeonesActivity : AppCompatActivity() {
    @SuppressLint("MutatingSharedPrefs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campeon)

        val fondoCampones = findViewById<ImageView>(R.id.fondoPrincipal)

        Glide.with(this)
            .load(R.drawable.dianaluna)
            .into(fondoCampones)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCampeones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val selectedRol = intent.getStringExtra("selectedRol")

        val campeones = listOf(
            Campeon("Darius", "El maestro de Noxus", "Habilidad 1: Hacha giratoria\nHabilidad 2: Hemorragia\nHabilidad 3: Decapitación\nHabilidad 4: Noxian Guillotine", "https://www.mobafire.com/images/champion/square/darius.png",false),
            Campeon("Shen", "El ninja protector", "Habilidad 1: Protección espiritual\nHabilidad 2: Hoja fatal\nHabilidad 3: Atajo\nHabilidad 4: Fortaleza del espíritu", "https://www.mobafire.com/images/champion/square/shen.png",false),
            Campeon("Renekton", "El carnívoro", "Habilidad 1: Corte voraz\nHabilidad 2: Embate\nHabilidad 3: Ira de Renekton\nHabilidad 4: Dominación", "https://www.mobafire.com/images/champion/square/renekton.png",false),
            Campeon("Aatrox", "El verdugo de los cielos", "Habilidad 1: Corte de sangre\nHabilidad 2: Lanza de Aatrox\nHabilidad 3: El fin del mundo\nHabilidad 4: Descenso de la sangre", "https://www.mobafire.com/images/champion/square/aatrox.png",false),
            Campeon("Jax", "El maestro de armas", "Habilidad 1: Golpe de la espada\nHabilidad 2: Salto\nHabilidad 3: Venganza\nHabilidad 4: Despertar", "https://www.mobafire.com/images/champion/square/jax.png",false),
            Campeon("Lee Sin", "El monje ciego", "Habilidad 1: Sonic Wave\nHabilidad 2: Tempestad\nHabilidad 3: Carga resonante\nHabilidad 4: Golpe doble", "https://www.mobafire.com/images/champion/square/lee-sin.png",false),
            Campeon("Kha'Zix", "El depredador", "Habilidad 1: Salto\nHabilidad 2: Resurrección\nHabilidad 3: Sabores\nHabilidad 4: Carga letal", "https://www.mobafire.com/images/champion/square/khazix.png",false),
            Campeon("Nidalee", "La cazadora", "Habilidad 1: Jabalina\nHabilidad 2: Salto\nHabilidad 3: Azote\nHabilidad 4: Caza", "https://www.mobafire.com/images/champion/square/nidalee.png",false),
            Campeon("Warwick", "El cazador, el lobo", "Habilidad 1: Golpe sangriento\nHabilidad 2: Sed de sangre\nHabilidad 3: Caza imparable\nHabilidad 4: Llamado del lobo", "https://www.mobafire.com/images/champion/square/warwick.png",false),
            Campeon("Graves", "El vaquero", "Habilidad 1: Disparo a quemarropa\nHabilidad 2: Persecución\nHabilidad 3: Escudo\nHabilidad 4: Asalto", "https://www.mobafire.com/images/champion/square/graves.png",false),
            Campeon("Ahri", "El zorro de nueve colas", "Habilidad 1: Orb de Deception\nHabilidad 2: Charm\nHabilidad 3: Espíritu volador\nHabilidad 4: Fuerza embriagadora", "https://www.mobafire.com/images/champion/square/ahri.png",false),
            Campeon("Zed", "El maestro de las sombras", "Habilidad 1: Shuriken\nHabilidad 2: Marca de la muerte\nHabilidad 3: Sombras vivientes\nHabilidad 4: Muerte imparable", "https://www.mobafire.com/images/champion/square/zed.png",false),
            Campeon("Orianna", "La mecanomante", "Habilidad 1: Esfera de comando\nHabilidad 2: Comando de choque\nHabilidad 3: Comando de zona\nHabilidad 4: Ruptura de órbita", "https://www.mobafire.com/images/champion/square/orianna.png",false),
            Campeon("Syndra", "La reina de las esferas", "Habilidad 1: Esfera\nHabilidad 2: Explosión de esferas\nHabilidad 3: Fuerza de la oscuridad\nHabilidad 4: Potencia máxima", "https://www.mobafire.com/images/champion/square/syndra.png",false),
            Campeon("Lux", "La dama luminosa", "Habilidad 1: Luz cegadora\nHabilidad 2: Bola de luz\nHabilidad 3: Barrera de luz\nHabilidad 4: Llama solar", "https://www.mobafire.com/images/champion/square/lux.png",false),
            Campeon("Jinx", "La reina del caos", "Habilidad 1: Disparo rápido\nHabilidad 2: Super cohete\nHabilidad 3: Pasión explosiva\nHabilidad 4: Cañón de riel", "https://www.mobafire.com/images/champion/square/jinx.png",false),
            Campeon("Kai'Sa", "La hija del vacío", "Habilidad 1: Lluvia de misiles\nHabilidad 2: Pasaje del vacío\nHabilidad 3: Carga de vacío\nHabilidad 4: Vínculo mortal", "https://www.mobafire.com/images/champion/square/kaisa.png",false),
            Campeon("Miss Fortune", "La dama de las armas", "Habilidad 1: Disparo doble\nHabilidad 2: Ráfaga de bala\nHabilidad 3: Lluvia de balas\nHabilidad 4: Balas encantadas", "https://www.mobafire.com/images/champion/square/miss-fortune.png",false),
            Campeon("Ezreal", "El explorador prodigioso", "Habilidad 1: Disparo místico\nHabilidad 2: Fuego de arcángel\nHabilidad 3: Sobrecarga\nHabilidad 4: Puño de arcángel", "https://www.mobafire.com/images/champion/square/ezreal.png",false),
            Campeon("Ashe", "La reina de los francotiradores", "Habilidad 1: Tiro de hielo\nHabilidad 2: Flecha de cristal\nHabilidad 3: Tormenta de flechas\nHabilidad 4: Flecha congelada", "https://www.mobafire.com/images/champion/square/ashe.png",false),
            Campeon("Leona", "La amanecer radiante", "Habilidad 1: Escudo solar\nHabilidad 2: Llama solar\nHabilidad 3: Eclipse\nHabilidad 4: Luz radiante", "https://www.mobafire.com/images/champion/square/leona.png",false),
            Campeon("Janna", "La furia del viento", "Habilidad 1: Ventolera\nHabilidad 2: Onda de viento\nHabilidad 3: Murmullo\nHabilidad 4: Tormenta de arena", "https://www.mobafire.com/images/champion/square/janna.png",false),
            Campeon("Nami", "La marea", "Habilidad 1: Aguas profundas\nHabilidad 2: Curación marina\nHabilidad 3: Ola mística\nHabilidad 4: Resplandor del océano", "https://www.mobafire.com/images/champion/square/nami.png",false),
            Campeon("Thresh", "El carcelero", "Habilidad 1: Linterna\nHabilidad 2: Ira de la oscuridad\nHabilidad 3: Golpe mortal\nHabilidad 4: Aniquilación de almas", "https://www.mobafire.com/images/champion/square/thresh.png",false),
            Campeon("Alistar", "El minotauro", "Habilidad 1: Carga\nHabilidad 2: Puño doble\nHabilidad 3: Matanza\nHabilidad 4: Estampida", "https://www.mobafire.com/images/champion/square/alistar.png",false)
        )



        val campeonesFiltrados = when (selectedRol) {
            "Top" -> campeones.filter { it.nombre == "Darius" || it.nombre == "Shen" || it.nombre == "Renekton" || it.nombre == "Aatrox" || it.nombre == "Jax" }
            "Jungla" -> campeones.filter { it.nombre == "Lee Sin" || it.nombre == "Kha'Zix" || it.nombre == "Nidalee" || it.nombre == "Warwick" || it.nombre == "Graves" }
            "Mid" -> campeones.filter { it.nombre == "Ahri" || it.nombre == "Zed" || it.nombre == "Orianna" || it.nombre == "Syndra" || it.nombre == "Lux" }
            "AdCarry" -> campeones.filter { it.nombre == "Jinx" || it.nombre == "Kai'Sa" || it.nombre == "Miss Fortune" || it.nombre == "Ezreal" || it.nombre == "Ashe" }
            "Support" -> campeones.filter { it.nombre == "Leona" || it.nombre == "Janna" || it.nombre == "Nami" || it.nombre == "Thresh" || it.nombre == "Alistar" }
            else -> campeones
        }

        val adapter = CampeonAdapter(campeonesFiltrados, { campeon ->
            campeon.favorito = !campeon.favorito
            recyclerView.adapter?.notifyItemChanged(campeonesFiltrados.indexOf(campeon))

            val sharedPreferences = getSharedPreferences("FAVORITOS", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            val favoritosActuales = sharedPreferences.getStringSet("favoritos", mutableSetOf()) ?: mutableSetOf()

            if (campeon.favorito) {
                favoritosActuales.add(campeon.nombre)
            } else {
                favoritosActuales.remove(campeon.nombre)
            }
            editor.putStringSet("favoritos", favoritosActuales)
            editor.apply()
        }, this)

        recyclerView.adapter = adapter
    }
}
