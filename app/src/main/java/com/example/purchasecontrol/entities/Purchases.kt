package com.example.purchasecontrol.entities
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import dc.PurchasesDB


class Purchases {

    var id = 0
    var name : String = ""

    //creamos las nuevas variables
    var price : Double = 0.0
    var store : String = ""
    var date : String = ""

    constructor()
                                        //creamos los constructores de las nuevas variables.
    constructor(id: Int, name: String, price: Double, store: String, date: String){

        this.id =id
        this.name = name
        this.price = price
        this.store = store
        this.date = date

    }
        //en esta funcion agregamos todos los parametros que recibira. agregando price, store y date.
    fun save(context: Context, name: String, price: Double, store: String, date: String) {

        try {

            val purchasesDB = PurchasesDB(context,"PurchaseDB", null, 1)

            val dataBase : SQLiteDatabase = purchasesDB.writableDatabase

            //declaramos los valores que recibiran y donde se pondran.-
            val values = ContentValues()
            values.put("name", name)
            values.put("price", price)
            values.put("store", store)
            values.put("date", date)


            dataBase.insert("Purchase",null, values)


        }catch (ex: Exception){

            Log.e("Error saving Compra", ex.message.toString())

        }

    }

    fun getAll(context: Context): List<Purchases>{
        var purchases1 : MutableList<Purchases> = ArrayList()

        try {

            val purchasesDB = PurchasesDB(context,"PurchaseDB", null, 1)

            val dataBase : SQLiteDatabase = purchasesDB.readableDatabase

            val resultSet = dataBase.rawQuery("SELECT id, name, price, store, date FROM Purchase", null)

            while (resultSet.moveToNext()){

                val purchases = Purchases(resultSet.getInt(0)
                    , resultSet.getString(1)
                    , resultSet.getDouble(2)
                    , resultSet.getString(3)
                    , resultSet.getString(4))

                purchases1.add(purchases)

            }

        }catch (ex : Exception) {

            Log.e("Error saving purchases", ex.message.toString())
        }
        return purchases1
    }


}