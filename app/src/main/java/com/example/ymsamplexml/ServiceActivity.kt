package com.example.ymsamplexml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.ymsamplexml.data.HeroDM
import com.example.ymsamplexml.data.HeroesDM
import com.example.ymsamplexml.databinding.ActivityServiceBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

        val retrofit = Retrofit.Builder()
            .baseUrl(OpenApi.DOMAIN)
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        binding.btnRequest.setOnClickListener {
            val service = retrofit.create(Service::class.java)
            service.getHeroes()
                .enqueue(object : Callback<HeroesDM> {
                    override fun onResponse(call: Call<HeroesDM>, response: Response<HeroesDM>) {
                        val result = response.body()
                        Log.d("ServiceActivity", "$result")
                    }

                    override fun onFailure(call: Call<HeroesDM>, t: Throwable) {
                        Log.d("ServiceActivity", "$t")
                        Toast.makeText(this@ServiceActivity, "데이터를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()
                    }
                })
        }

        binding.btnRequestById.setOnClickListener {
            val service = retrofit.create(Service::class.java)
            service.getHero("2")
                .enqueue(object : Callback<HeroDM> {
                    override fun onResponse(call: Call<HeroDM>, response: Response<HeroDM>) {
                        val result = response.body()
                        Log.d("ServiceActivity", "$result")
                    }

                    override fun onFailure(call: Call<HeroDM>, t: Throwable) {
                        Log.d("ServiceActivity", "$t")
                        Toast.makeText(this@ServiceActivity, "데이터를 가져올 수 없습니다", Toast.LENGTH_SHORT).show()
                    }
                })
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