package com.example.twoscreens

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPair: MediaPlayer // SOUND
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val b = findViewById<Button>(R.id.button)

        b.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val mediaPlayer = MediaPlayer.create(this, R.raw.tada)  // SOUND

        val sb = findViewById<Button>(R.id.sndBtn)  // SOUND
        sb.setOnClickListener {                     // SOUND
            mediaPlayer.start()                     // SOUND
        }                                           // SOUND
    }
}