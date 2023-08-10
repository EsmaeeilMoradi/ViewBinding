package com.esm.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.esm.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(this)
        binding.btnTake.setOnClickListener(this)
        binding.btnGrow.setOnClickListener(this)
        binding.btnShrink.setOnClickListener(this)
        binding.btnReset.setOnClickListener(this)
        binding.btnHide.setOnClickListener(this)
        binding.myTextView.setOnClickListener(this)


    }

    override fun onClick(v: View) {
        val size: Float
        when (v.id) {
            R.id.btnAdd -> {
                value++
                binding.myTextView.text = "$value"
            }

            R.id.btnTake -> {
                value--
                binding.myTextView.text = "$value"
            }

            R.id.btnReset -> {
                value = 0
                binding.myTextView.text = "$value"
                binding.myTextView.textScaleX = 1.0f
            }

            R.id.btnShrink -> {
                size = binding.myTextView.textScaleX

                binding.myTextView.textScaleX = size - 1
            }

            R.id.btnHide -> {

                if (binding.myTextView.visibility == View.VISIBLE) {
                    binding.myTextView.visibility = View.GONE
                    binding.btnHide.text = "SHOW"
                } else if (binding.myTextView.visibility == View.GONE) {
                    binding.myTextView.visibility = View.VISIBLE
                    binding.btnHide.text = "HIDE"
                }

            }

            R.id.btnGrow -> {
                size = binding.myTextView.textScaleX

                binding.myTextView.textScaleX = size + 1
            }

        }
    }
}