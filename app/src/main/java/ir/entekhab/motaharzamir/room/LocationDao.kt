package ir.entekhab.motaharzamir.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface LocationDao {
    @Insert
    fun insertLocation(location: Location)

    @Update
    fun updateLocation(location: Location)

    @Delete
    fun deleteLocatin(location: Location)

    @Query("SELECT * FROM table_location")
    fun getAllLocations() :List<Location>

    @Query("SELECT * FROM table_location WHERE txtLocation LIKE '%' || :searching || '%'")
    fun searchLocation(searching : String) : List<Location>



}