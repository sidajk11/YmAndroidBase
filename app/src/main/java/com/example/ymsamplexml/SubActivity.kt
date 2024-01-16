package com.example.ymsamplexml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ymsamplexml.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvDescA.text = intent.getStringExtra("from1")
        binding.tvDescB.text = "${intent.getIntExtra("from2", 0)}"
    }
}