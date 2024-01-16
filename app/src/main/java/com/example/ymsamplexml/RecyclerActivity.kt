package com.example.ymsamplexml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ymsamplexml.databinding.ActivityRecyclerBinding
import com.example.ymsamplexml.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class RecyclerActivity : AppCompatActivity() {

    private val binding by lazy { ActivityRecyclerBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data = loadData()
        val adapter = CustomAdapter(data)
        binding.rvRecord.adapter = adapter
        binding.rvRecord.layoutManager = LinearLayoutManager(this)
    }

    private fun loadData() : MutableList<RecordDM> {
        val recordList = mutableListOf<RecordDM>()
        for (idx in 1..100) {
            val date = System.currentTimeMillis()
            val model = RecordDM(idx, "test",date)
            recordList.add(model)
        }

        return recordList
    }
}

class CustomAdapter(val listData: MutableList<RecordDM>): RecyclerView.Adapter<CustomAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = listData[position]
        holder.reload(item)
    }

    override fun getItemCount() = listData.size
//    override fun getItemCount(): Int {
//        return listData.size
//    }

    class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        fun reload(record: RecordDM) {
            with(binding) {
                tvNo.text = "${record.no}"
                tvTitle.text = record.title
                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val dateSting = sdf.format(record.timestamp)
                tvDate.text = dateSting
            }
        }
    }
}