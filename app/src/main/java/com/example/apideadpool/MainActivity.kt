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

        val nameTextView: TextView = findViewById(R.id.nameTextView)
        val fullNameTextView: TextView = findViewById(R.id.fullNameTextView)
        val intelligenceTextView: TextView = findViewById(R.id.intelligenceTextView)
        val strengthTextView: TextView = findViewById(R.id.strengthTextView)
        val speedTextView: TextView = findViewById(R.id.speedTextView)
        val imageView: ImageView = findViewById(R.id.imageView)

        viewModel.superhero.observe(this) { superhero ->
            nameTextView.text = superhero.name
            fullNameTextView.text = superhero.biography.fullName
            intelligenceTextView.text = "Intelligence: ${superhero.powerstats.intelligence}"
            strengthTextView.text = "Strength: ${superhero.powerstats.strength}"
            speedTextView.text = "Speed: ${superhero.powerstats.speed}"

            Glide.with(this)
                .load(superhero.image.url)
                .into(imageView)
        }

        viewModel.fetchSuperhero("213")
    }
}