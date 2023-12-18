package com.darooma.finalprojectchikilector.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.darooma.finalprojectchikilector.utils.Constants

//se entiende que se trajo de la biblioteca ROOM
@Entity(tableName = Constants.DATABASE_USER_AVATARSTUFF_TABLE)
data class UserAvatarStuffEntity(
    //Anotaciones de room
    @PrimaryKey(autoGenerate = true) //relationship table
    val idJoinUserAvatar: Int,
    @ColumnInfo(name = "id_user")
    val idUser: Long ,
    @ColumnInfo(name = "id_avatar_stuff")
    var idAvatarStuff: Long,



)
