package com.darooma.finalprojectchikilector.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.darooma.finalprojectchikilector.utils.Constants

//se entiende que se trajo de la biblioteca ROOM
@Entity(tableName = Constants.DATABASE_SESSION_TABLE)
data class SessionEntity(
    //Anotaciones de room
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_session")
    val id_session: Long = 0,
    @ColumnInfo(name = "id_usuario")
    var id_usuario: Long = 0,

)
