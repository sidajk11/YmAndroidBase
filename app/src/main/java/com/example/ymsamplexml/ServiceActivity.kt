package com.example.ymsamplexml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ymsamplexml.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {
    private val binding by lazy { ActivityServiceBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnServiceStart.setOnClickListener {
            startMyService()
        }

        binding.btnServiceStop.setOnClickListener {
            stopMyService()
        }
    }

    private fun startMyService() {
        val intent = Intent(this, MyService::class.java)
        intent.action = MyService.ACTION_CREATE
        startService(intent)
    }

    private fun stopMyService() {
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }
}