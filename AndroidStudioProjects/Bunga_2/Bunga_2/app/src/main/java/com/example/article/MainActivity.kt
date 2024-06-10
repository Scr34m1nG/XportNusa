package com.example.article

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvManager: RecyclerView
    private val list = ArrayList<bunga>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvManager = findViewById(R.id.rv_manager)
        rvManager.setHasFixedSize(true)

        list.addAll(getListManager())
        showRecylerList()
    }

    private fun getListManager(): ArrayList<bunga> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listManager = ArrayList<bunga>()

        for (i in dataName.indices) {
            val manager = bunga(
                dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1)
            )

            listManager.add(manager)
        }

        return listManager
    }

    private fun showRecylerList() {
        rvManager.layoutManager = LinearLayoutManager(this)
        val listManagerAdapter = ListManagerAdapter(list)

        rvManager.adapter = listManagerAdapter

        listManagerAdapter.setOnItemClickCallback(object : ListManagerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: bunga) {
                showSelectedManager(data)
            }
        })
    }

    private fun showSelectedManager(manager: bunga) {
        val intent = Intent(this, detail::class.java)

        val bundle = Bundle()

        bundle.putString("nama", manager.name)
        bundle.putString("deskripsi", manager.description)
        bundle.putInt("img", manager.photo)

        intent.putExtras(bundle)

        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this, about::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}