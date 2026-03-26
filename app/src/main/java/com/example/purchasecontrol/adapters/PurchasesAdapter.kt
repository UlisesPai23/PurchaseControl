package com.example.purchasecontrol.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.purchasecontrol.R
import com.example.purchasecontrol.entities.Purchases

class PurchasesAdapter (context: Context, purchases: List<Purchases>) : BaseAdapter() {
    var context : Context = context
    var purchasesList : List<Purchases> = purchases

    override fun getCount() : Int{
        return purchasesList.size
    }

    override fun getItem(position: Int): Any? {
        return purchasesList[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val element = LayoutInflater.from(context).inflate(R.layout.purchases_item, null)
        try {

            val purchases = getItem(position) as Purchases

            val txtProduct : TextView = element.findViewById(R.id.shopping_product)
            txtProduct.text = "Producto: ${purchases.product}"

            val txtPrice : TextView = element.findViewById(R.id.shopping_price)
            txtPrice.text = "Precio: $${purchases.price}"

            val txtStore : TextView = element.findViewById(R.id.shopping_store)
            txtStore.text = "Tienda: ${purchases.store}"

            val txtDate : TextView = element.findViewById(R.id.shopping_date)
            txtDate.text = "Fecha: ${purchases.date}"


        }catch (ex: Exception){
            Log.e("Error showing winners", ex.message.toString())
        }
        return element

    }
}