package com.strone.week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.strone.week4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Toast message!!!", Toast.LENGTH_SHORT).show()
        }
        binding.btnCount.setOnClickListener {
            binding.tvCount.text = (++count).toString()
        }

        val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                count = it.data?.getIntExtra("random", count) ?: count
                binding.tvCount.text = count.toString()
            }
        }
        val intent = Intent(this, RandomActivity::class.java)

        binding.btnRandom.setOnClickListener {
            intent.putExtra("count", count)
            activityResult.launch(intent)
        }
    }
}