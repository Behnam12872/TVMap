package ir.entekhab.motaharzamir.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val txtLocation: String,
    val txtInfo: String,
    val focusX: Int,
    val focusY: Int,
    val pageIndex: Int,
    val targetScale: Float,
    val duration: Long
)
