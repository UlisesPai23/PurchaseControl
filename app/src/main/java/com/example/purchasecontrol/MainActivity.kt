package com.example.purchasecontrol

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var  btn_form: Button
    lateinit var btn_list: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn_form = findViewById<Button>(R.id.btn_form)
        btn_form.setOnClickListener(this)

        btn_list = findViewById<Button>(R.id.btn_list)
        btn_list.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {

        R.id.btn_form -> {
            val intentRegisterForm = Intent(this, RegisterFormsActiivity::class.java)
            startActivity(intentRegisterForm)
        }

        R.id.btn_list ->{
            val intentPurchaseList = Intent(this, PurchaseListActivity:: class.java)
            startActivity(intentPurchaseList)
        }

        }

    }
}