package com.example.ymsamplexml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.ymsamplexml.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySpinnerBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val items = listOf("-선택하세요", "1월", "2월", "3월")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
        binding.spItems.adapter = adapter

        binding.spItems.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selected = items[position]
                binding.tvTitle.text = selected
            }
        }
    }
}