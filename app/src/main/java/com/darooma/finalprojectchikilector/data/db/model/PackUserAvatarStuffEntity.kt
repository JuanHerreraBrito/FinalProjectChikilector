package com.darooma.finalprojectchikilector.data.db.model

import androidx.room.*
import com.darooma.finalprojectchikilector.utils.Constants

data class PackUserAvatarStuffEntity(
//    @Embedded
//    val idUser: Long,
//    val idAvatarStuff: Long,
//    @Relation(parentColumn = "id_user", entityColumn = "id_avatar_stuff", )
//    val allAvatarStuffEntity: List<AvatarsStuffEntity>

    @Embedded val user: UserEntity? = null,
//    @Relation(
//        parentColumn = "idUser",
//        entityColumn = "id_avatar_stuff"
//    )
    @Relation(
        parentColumn = "id_user",
        entityColumn = "id_avatar_stuff"
    )
    val avatarStuff: List<AvatarsStuffEntity>? = null

){
    constructor() : this(UserEntity(), emptyList())
}


