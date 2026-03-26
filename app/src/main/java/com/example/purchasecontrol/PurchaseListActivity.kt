package com.example.purchasecontrol

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.purchasecontrol.adapters.PurchasesAdapter
import com.example.purchasecontrol.entities.Purchases

class PurchaseListActivity : AppCompatActivity() {
    var listShopping: ListView? = null
    var context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_purchase_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listShopping = findViewById(R.id.list_shopping)
        loadShopping()
    }

    fun loadShopping(){
        val shopping = Purchases().getAll(context)
        listShopping?.adapter = PurchasesAdapter(context, shopping)
    }
}