package com.example.apideadpool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: SuperheroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SuperheroViewModel::class.java)

        val imageView: ImageView = findViewById(R.id.imageView)
        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val idTextView: TextView = findViewById(R.id.idTextView)
        val powerstatsTextView: TextView = findViewById(R.id.powerstatsTextView)
        val biographyTextView: TextView = findViewById(R.id.biographyTextView)
        val appearanceTextView: TextView = findViewById(R.id.appearanceTextView)
        val workTextView: TextView = findViewById(R.id.workTextView)
        val connectionsTextView: TextView = findViewById(R.id.connectionsTextView)

        viewModel.superhero.observe(this) { superhero ->
            nameTextView.text = superhero.name
            idTextView.text = "ID: ${superhero.id}"

            powerstatsTextView.text = """
                Powerstats:
                Intelligence: ${superhero.powerstats.intelligence}
                Strength: ${superhero.powerstats.strength}
                Speed: ${superhero.powerstats.speed}
                Durability: ${superhero.powerstats.durability}
                Power: ${superhero.powerstats.power}
                Combat: ${superhero.powerstats.combat}
            """.trimIndent()

            biographyTextView.text = """
                Biography:
                Full Name: ${superhero.biography.fullName}
                Alter Egos: ${superhero.biography.alterEgos}
                Aliases: ${superhero.biography.aliases.joinToString(", ")}
                Place of Birth: ${superhero.biography.placeOfBirth}
                First Appearance: ${superhero.biography.firstAppearance}
                Publisher: ${superhero.biography.publisher}
                Alignment: ${superhero.biography.alignment}
            """.trimIndent()

            appearanceTextView.text = """
                Appearance:
                Gender: ${superhero.appearance.gender}
                Race: ${superhero.appearance.race}
                Height: ${superhero.appearance.height.joinToString(", ")}
                Weight: ${superhero.appearance.weight.joinToString(", ")}
                Eye Color: ${superhero.appearance.eyeColor}
                Hair Color: ${superhero.appearance.hairColor}
            """.trimIndent()

            workTextView.text = """
                Work:
                Occupation: ${superhero.work.occupation}
                Base: ${superhero.work.base}
            """.trimIndent()

            connectionsTextView.text = """
                Connections:
                Group Affiliation: ${superhero.connections.groupAffiliation}
                Relatives: ${superhero.connections.relatives}
            """.trimIndent()

            Glide.with(this)
                .load(superhero.image.url)
                .into(imageView)
        }

        viewModel.fetchSuperhero("213")
    }
}