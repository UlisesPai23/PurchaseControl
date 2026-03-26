package dc


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class PurchasesDB(
    context : Context?,
    name : String?,
    factory : SQLiteDatabase.CursorFactory?,
    version : Int
) : SQLiteOpenHelper(context, name, factory, version){

    override fun onCreate(sqliteDatabase: SQLiteDatabase) {
        try {
            // Creamos la tabla con los campos solicitados: nuevo producto, precio, tienda. (fecha queda pendiente).
            sqliteDatabase.execSQL("CREATE TABLE Purchases (id INTEGER PRIMARY KEY AUTOINCREMENT, product TEXT, price DOUBLE, store TEXT, date TEXT)")
        } catch (ex: Exception){
            Log.e("Error al crear la base de datos", ex.message.toString())
        }
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }


}