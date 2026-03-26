package com.example.purchasecontrol

import android.content.Intent
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.purchasecontrol.entities.Purchases

class RegisterFormsActiivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_forms)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn_save = findViewById<Button>(R.id.btn_save)
        btn_save.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btn_save ->{
                val product = findViewById<EditText>(R.id.txt_product).text.toString()
                android.util.Log.d("DEBUG_PRODUCT", "Producto capturado: '$product'")
                val price = findViewById<EditText>(R.id.txt_price).text.toString().toDouble()
                val store = findViewById<EditText>(R.id.txt_store).text.toString()
                val date = findViewById<EditText>(R.id.txt_date).text.toString()

                Purchases().save(this, product, price, store, date)
                Toast.makeText(this,"Se registro correctamente", Toast.LENGTH_SHORT).show()
                val intentMainForm = Intent(this, MainActivity::class.java)
                startActivity(intentMainForm)
                val vibrator = applicationContext.getSystemService(VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(1500)
            }
        }
    }
}