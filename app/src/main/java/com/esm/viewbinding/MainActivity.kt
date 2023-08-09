package com.esm.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.esm.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val myTextView : TextView = findViewById<TextView>(R.id.myTextView)
//        myTextView.text = "This is a test"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val myBank :Int = 1000

        if (binding.dollarValue.text.isNotEmpty()) {
            val dollarValue = binding.dollarValue.text.toString().toFloat()

            val euroValue = myBank * 0.92f
            binding.euroValue.text = euroValue.toString()
        }else{
            binding.euroValue.text=""
        }

    }
}