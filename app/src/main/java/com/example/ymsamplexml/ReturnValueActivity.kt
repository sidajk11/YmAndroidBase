package com.example.ymsamplexml

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ymsamplexml.databinding.ActivityReturnValueBinding

class ReturnValueActivity : AppCompatActivity() {

    private val binding by lazy { ActivityReturnValueBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            tvDescA.text = intent.getStringExtra("from1")
            tvDescB.text = "${intent.getIntExtra("from2", 0)}"

            btnDone.setOnClickListener {
                val returnIntent = Intent()
                val message = editMessage.text.toString()
                returnIntent.putExtra("returnValue", message)
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }
        }
    }
}