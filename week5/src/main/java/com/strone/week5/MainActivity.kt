package com.strone.week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import com.strone.week5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDialog.setOnClickListener {
            showAlertDialog()
        }

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = (++count).toString()
        }

        binding.btnRandom.setOnClickListener {
            val fragment = RandomFragment.newInstance(count)
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_random, fragment, "random_fragment")
                .commit()
        }

        onBackPressedDispatcher
            .addCallback(this, object: OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    removeRandomFragment()
                }
            })
    }

    private fun removeRandomFragment() {
        val randomFragment = supportFragmentManager.findFragmentByTag("random_fragment")
        if (randomFragment != null){
            supportFragmentManager.beginTransaction()
                .remove(randomFragment)
                .commit()
        }
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(this)
            .setTitle("Hello")
            .setMessage("Hello, welcome to week5")
            .setPositiveButton("Ok"){ _, _ ->
                count = 0
                binding.tvCount.text = "0"
            }
            .setNeutralButton("Neutral"){ _, _ ->
                Toast.makeText(this, "Neutral Message!!!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){ _, _ ->
            }
            .create()
            .show()
    }

}