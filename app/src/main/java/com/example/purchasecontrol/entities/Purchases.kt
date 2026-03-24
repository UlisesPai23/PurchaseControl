import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import dc.PurchasesDB
class Winer {

    var id = 0
    var name : String = ""

    //creamos las nuevas variables
    var price : Double = 0.0
    var store : String = ""
    var date : String = ""


                                        //creamos los constructores de las nuevas variables.
    constructor(id: Int, name: String, price: Double, store: String, date: String){

        this.id =id
        this.name = name
        this.price = price
        this.store = store
        this.date = date

    }

    fun save(context: Context, name: String, price: Double, store: String, date: String) {

        try {

            val purchasesDB = PurchasesDB(context,"PurchaseDB", null, 1)

            val dataBase : SQLiteDatabase = purchasesDB.writableDatabase

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

    fun getAll(context: Context): List<Winer>{
        var winners : MutableList<Winer> = ArrayList()

        try {

            val purchasesDB = PurchasesDB(context,"PurchaseDB", null, 1)

            val dataBase : SQLiteDatabase = purchasesDB.readableDatabase

            val resultSet = dataBase.rawQuery("SELECT id, name, price, store, date FROM Purchase", null)

            while (resultSet.moveToNext()){

                val purchase = Purchase(resultSet.getInt(0), resultSet.getString(1), resultSet.getString(2))

                purchases.add(purchase)

            }

        }catch (ex : Exception) {

            Log.e("Error saving winner", ex.message.toString())
        }
        return winners
    }


}