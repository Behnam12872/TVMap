package ir.entekhab.motaharzamir.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, exportSchema = false, entities = [Location::class])
abstract class MyDatabase : RoomDatabase() {

    abstract val locationDao: LocationDao

    companion object {
        private var database: MyDatabase? = null
        fun getDatabase(context: Context): MyDatabase {

            if (database == null) {
                database = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "myDatabase.db"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return database!!
        }
    }

}