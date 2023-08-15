package com.esm.viewbinding

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.esm.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e(TAG, "onCreate: STEP 1")

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

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: STEP 2")
        Log.e(TAG, "onStart: STEP 2 => User navigate to the activity  (onRestart -> onStart) ")



    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: STEP 3")
        Log.e(TAG, "onResume: In this step Activity Running")
        Log.e(TAG, "onResume: In this step User returns to the activity ( onResume <-> onPause)")



    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: STEP 4")
        Log.e(TAG, "onPause: Another activity comes into the foreground  ( onResume <-> onPause) ")



    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: STEP 5 ")
        Log.e(TAG, "onStop: STEP 5 => The activity is no longer visible (onStop -> onRestart) ")

    }

    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: STEP 6")
        Log.e(TAG, "onRestart: STEP 6 => User navigate to the activity  (onRestart -> onStart) ")



    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: STEP 7")
        Log.e(TAG, "onDestroy: STEP 7 The activity is finishing or being destroyed by the system ")


    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val TAG = "MainActivity"

    }

}