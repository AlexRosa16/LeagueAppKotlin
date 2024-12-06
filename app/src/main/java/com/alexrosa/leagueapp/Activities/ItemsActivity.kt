package com.alexrosa.leagueapp.Activities

import com.alexrosa.leagueapp.R
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexrosa.leagueapp.Adapter.ItemAdapter
import com.alexrosa.leagueapp.Classes.Item
import com.bumptech.glide.Glide

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campeon)

        val fondoItems = findViewById<ImageView>(R.id.fondoPrincipal)
        Glide.with(this)
            .load(R.drawable.dianaluna)
            .into(fondoItems)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCampeones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val selectedStat = intent.getStringExtra("selectedStat")

        val items = listOf(

            Item("Espada del Rey Arruinado", "AttackDamage", "Ataque: 40, Vida robada: 12%", "https://www.mobafire.com/images/item/blade-of-the-ruined-king-64x.png"),
            Item("Fueza de Trinidad", "AttackDamage", "15 Ability Haste\n36 Attack Damage\n30% Attack Speed\n333 Health", "https://www.mobafire.com/images/item/trinity-force-64x.png"),
            Item("Kraken Slayer", "AttackDamage", "45 Attack Damage\nAttack Speed: 40%", "https://www.mobafire.com/images/item/kraken-slayer-64x.png"),
            Item("Filo Infinito", "AttackDamage", "Ataque: 80, Crítico: 25%", "https://www.mobafire.com/images/item/infinity-edge-64x.png"),

            Item("Rabadon", "AbilityPower", "Poder de habilidad: 120", "https://www.mobafire.com/images/item/rabadons-deathcap-64x.png"),
            Item("Bastón del Vacío", "AbilityPower", "Poder de habilidad: 100\nPenetración mágica: 40", "https://www.mobafire.com/images/item/void-staff-64x.png"),
            Item("Vara de las Edades", "AbilityPower", "Salud: 450\nPoder de habilidad: 60", "https://www.mobafire.com/images/item/rod-of-ages-64x.png"),
            Item("Llamado del Vacío", "AbilityPower", "Poder de habilidad: 90\nPenetración mágica: 40", "https://www.mobafire.com/images/item/liandrys-torment-64x.png"),

            Item("Corazón de Acero", "Armor", "Armadura: 80\nVida: 500", "https://www.mobafire.com/images/item/heartsteel-64x.png"),
            Item("Armado de Randuin", "Armor", "Armadura: 70\nSalud: 500", "https://www.mobafire.com/images/item/randuins-omen-64x.png"),
            Item("Malla de Espinas", "Armor", "Armadura: 50\nReflejo de daño: 30%", "https://www.mobafire.com/images/item/thornmail-64x.png"),
            Item("Corazon de Hielo", "Armor", "Armadura: 75\nMana: 400", "https://www.mobafire.com/images/item/frozen-heart-64x.png"),

            Item("Vara de las Edades", "Health", "Salud: 450\nPoder de habilidad: 60", "https://www.mobafire.com/images/item/rod-of-ages-64x.png"),
            Item("Mikael's Blessing", "Health", "Salud: 400\nRegeneración de salud: 20%", "https://www.mobafire.com/images/item/mikaels-blessing-64x.png"),
            Item("Guantele Helado", "Health", "Salud: 300\nArmor: 50", "https://www.mobafire.com/images/item/iceborn-gauntlet-64x.png"),
            Item("Solari's Shield", "Health", "Salud: 350\nResistencia mágica: 40", "https://www.mobafire.com/images/item/locket-of-the-iron-solari-64x.png"),

            Item("Manto de la Noche", "MagicResist", "Resistencia mágica: 45", "https://www.mobafire.com/images/item/negatron-cloak-64x.png"),
            Item("Anathema's Chains", "MagicResist", "Resistencia mágica: 60\nArmadura: 40", "https://www.mobafire.com/images/item/anathemas-chains-64x.png"),
            Item("Cloak of Agility", "MagicResist", "Resistencia mágica: 40", "https://www.mobafire.com/images/item/guardian-angel-64x.png"),
            Item("Mascara Abyssal", "MagicResist", "Resistencia mágica: 55\n" + "300 Health", "https://www.mobafire.com/images/item/abyssal-mask-64x.png")
        )


        val itemsFiltrados = when (selectedStat) {
            "Armor" -> items.filter { it.tipoitem.contains("Armor", ignoreCase = true) }
            "AttackDamage" -> items.filter { it.tipoitem.contains("AttackDamage", ignoreCase = true) }
            "AbilityPower" -> items.filter { it.tipoitem.contains("AbilityPower", ignoreCase = true) }
            "MagicResist" -> items.filter { it.tipoitem.contains("MagicResist", ignoreCase = true) }
            "Health" -> items.filter { it.tipoitem.contains("Health", ignoreCase = true) }
            else -> items
        }


        if (itemsFiltrados.isEmpty()) {
            Log.d("ItemsActivity", "No hay items para mostrar.")
        }


        val adapter = ItemAdapter(itemsFiltrados) { item ->
            val wikipediaUrl = "https://leagueoflegends.fandom.com/wiki/${item.nombre.replace(" ", "_")}/LoL"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaUrl))
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
