package com.example.twoscreens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.Home)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val chip = findViewById<Button>(R.id.chip)

        var sel = true
        chip.text="Hide Image"
        val i = findViewById<ImageView>(R.id.image1)
        i.visibility = View.VISIBLE

        chip.setOnClickListener {
            sel = !sel
            if( sel )  {
                chip.text="Hide Image"
                i.visibility = View.VISIBLE
            }
            else {
                chip.text="Show Image"
                i.visibility = View.INVISIBLE
            }
        }


    }
}