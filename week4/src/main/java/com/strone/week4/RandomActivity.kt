package com.strone.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.strone.week4.databinding.ActivityRandomBinding

class RandomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRandomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val count = intent.getIntExtra("count", 0)
        val random = (0..count).random()
        binding.tvRandomCaption.text = "Random between 0 and $count"
        binding.tvRandom.text = random.toString()

        intent.putExtra("random", random)
        setResult(RESULT_OK, intent)
    }

}