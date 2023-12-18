package com.darooma.finalprojectchikilector.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.darooma.finalprojectchikilector.utils.Constants

//se entiende que se trajo de la biblioteca ROOM
@Entity(tableName = Constants.DATABASE_AVATARS_STUFF_TABLE)
data class AvatarsStuffEntity(
    //Anotaciones de room
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_avatar_stuff")
    val id_avatar_stuff: Long = 0,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "image")
    var image: String,



)
