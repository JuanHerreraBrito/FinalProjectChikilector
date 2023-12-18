package com.darooma.finalprojectchikilector.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.darooma.finalprojectchikilector.utils.Constants

//se entiende que se trajo de la biblioteca ROOM
@Entity(tableName = Constants.DATABASE_USER_TABLE)
data class UserEntity(
    //Anotaciones de room
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    val idUser: Long = 0,
    @ColumnInfo(name = "user_name")
    var userName: String = "",
    @ColumnInfo(name = "password")
    var password: String = "",
    @ColumnInfo(name = "avatar_selected")
    var avatarSelected: Int? = 0,
    @ColumnInfo(name = "head")
    var head: Long? = 0,
    @ColumnInfo(name = "hands")
    var hands: Long? = 0,
    @ColumnInfo(name = "shoes")
    var shoes: Long? = 0,
    @ColumnInfo(name = "progress_game1")
    var progress_game1: Long? = 0,


)
