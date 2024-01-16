package com.example.ymsamplexml

import android.app.Activity
import android.app.Activity.*
import android.app.Instrumentation
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.ymsamplexml.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStartActivity.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("from1", "Hello Bundle")
            intent.putExtra("from2", 1234)
            // SubActivity 실행, 리턴값 없음
            startActivity(intent)
        }

        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.getStringExtra("returnValue")?.let { text ->
                    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnStartReturnValueActivity.setOnClickListener {
            val intent = Intent(this, ReturnValueActivity::class.java)
            intent.putExtra("from1", "Hello Bundle")
            intent.putExtra("from2", 1234)

            // ReturnValueActivity 실행, 리턴 값 있음
            resultLauncher.launch(intent)
        }

        binding.btnSpinner.setOnClickListener {
            val intent = Intent(this, SpinnerActivity::class.java)
            startActivity(intent)
        }

        binding.btnRecycler.setOnClickListener {
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }

        binding.btnPermission.setOnClickListener {
            val intent = Intent(this, PermissionActivity::class.java)
            startActivity(intent)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == Activity.RESULT_OK) {
//            when (requestCode) {
//                99 -> {
//                    data?.getStringExtra("returnValue").let { message ->
//                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }
//    }
}