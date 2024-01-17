package com.example.ymsamplexml

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ymsamplexml.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            binding.tvUserName.setText("User Name!")
            Log.d("Tag", "메시지")
        }

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        with(binding) {
            thread(start = true) {
                Thread.sleep(3000)
                runOnUiThread {
                    tvPassword.setText("Password")
                }
            }
        }

        // 스코프 함수 apply, run, with, let, also
        val phones = mutableListOf("010-1234-5678", "010-2345-6789")
        phones.run {
            add("010-1111-2222")
        }

        val objA = A(a = 11, b = 22)
        objA.desc()

        val resultA = with(objA) {
            println("a: $a, b: $b")
            b
        }

        Log.d("Tag", "resultA: $resultA")

        val obj = B()
        obj.a = 10
        obj.b = 20

        val result = with(obj) {
            println("a: $a, b: $b")
            b
        }

        Log.d("Tag", "resultB: $result")
    }

    private fun heavyWorld(num: Int): String {
        println("heavy method called: $num")
        return "world"
    }
}

class A(var a: Int, var b: Int) {
    fun desc() {
        Log.d("Tag", "$a, $b")
    }
}

class B {
    var a: Int = 0
    var b: Int = 1
}