package com.darooma.finalprojectchikilector.data.db

import androidx.room.*
import com.darooma.finalprojectchikilector.data.db.model.*
import com.darooma.finalprojectchikilector.utils.Constants

//darta access object
@Dao
interface ChikilectorDao {

    //---------- Para Usuario
    //Create
    @Insert
    suspend fun insertUser(user: UserEntity): Long//funciones suspendidas se ejecutan en corrutinas, y se suspenda si el sistema lo requiere
    //Update
    @Update
    suspend fun updateUser(user: UserEntity)
    //ReadOneUser
    @Query("SELECT * FROM ${Constants.DATABASE_USER_TABLE} WHERE id_user = :idUser LIMIT 1")
    suspend fun findUserById(idUser: Long): UserEntity

    @Query("SELECT * FROM ${Constants.DATABASE_USER_TABLE} WHERE user_name = :name LIMIT 1")
    suspend fun findUserByName(name: String): UserEntity

    //ReadAllUsers
    @Query("SELECT * FROM ${Constants.DATABASE_USER_TABLE} ")
    suspend fun getAllUsers():List<UserEntity>
    //Delete
    @Delete
    suspend fun deleteUser(user: UserEntity)

    @Query("UPDATE ${Constants.DATABASE_USER_TABLE} SET head = :head WHERE id_user =:idUser")
    fun updateUserHead(head: Long, idUser: Long)
    @Query("UPDATE ${Constants.DATABASE_USER_TABLE} SET hands = :hands WHERE id_user =:idUser")
    fun updateUserHands(hands: Long, idUser: Long)
    @Query("UPDATE ${Constants.DATABASE_USER_TABLE} SET shoes = :shoes WHERE id_user =:idUser")
    fun updateUserShoes(shoes: Long, idUser: Long)
    @Query("UPDATE ${Constants.DATABASE_USER_TABLE} SET progress_game1 = progress_game1 + 1 WHERE id_user =:idUser")
    fun updateUserProgressG1(idUser: Long)
//    @Insert
//    suspend fun insertUsers(users: List<UserEntity>)
    //---------- Para Usuario


    //---------- Para Session
    //Create
    @Insert
    suspend fun insertSesion(session: SessionEntity)//funciones suspendidas se ejecutan en corrutinas, y se suspenda si el sistema lo requiere
    //Delete
    @Delete
    suspend fun deleteSession(session: SessionEntity)
    //DeleteAllSessions
    @Query("DELETE FROM ${Constants.DATABASE_SESSION_TABLE} ")
    suspend fun deleteAllSessions()
    //ReadSession
    @Query("SELECT * FROM ${Constants.DATABASE_SESSION_TABLE}  LIMIT 1")
    suspend fun findSession(): List<SessionEntity>

    @Query("SELECT COUNT(*) FROM ${Constants.DATABASE_SESSION_TABLE} ")
    suspend fun countSessions(): Integer
    //---------- Para Session

    //---------- Para UserSession
    //@Query("SELECT * FROM ${Constants.DATABASE_SESSION_TABLE}  LIMIT 1")
    @Query("select * from ${Constants.DATABASE_USER_TABLE} where id_user = (SELECT id_usuario as id_user FROM ${Constants.DATABASE_SESSION_TABLE}  LIMIT 1)")
    suspend fun getSessionUser(): List<UserEntity>
    //---------- Para UserSession

    //---------- Para Avatar Stuff
    //Create
    @Insert
    suspend fun insertAvatarStuff(avatarStuff: AvatarsStuffEntity)//funciones suspendidas se ejecutan en corrutinas, y se suspenda si el sistema lo requiere
    @Insert
    suspend fun insertAllAvatarStuff(allAvatarStuff: List<AvatarsStuffEntity>)
    //ReadAllAvatarStuff
    @Query("SELECT * FROM ${Constants.DATABASE_AVATARS_STUFF_TABLE} ")
    suspend fun getAllAvatarStuff():List<AvatarsStuffEntity>
    //ReadAvatarStuffById
    @Query("SELECT * FROM ${Constants.DATABASE_AVATARS_STUFF_TABLE} WHERE id_avatar_stuff = :stuffId LIMIT 1")
    suspend fun findStuffById(stuffId: Long): AvatarsStuffEntity
    //ReadAvatarStuffByTipo
    @Query("SELECT * FROM ${Constants.DATABASE_AVATARS_STUFF_TABLE} WHERE type LIKE :stuffType ")
    suspend fun findStuffByType(stuffType: String): List<AvatarsStuffEntity>
    //---------- Para Avatar Stuff


    //---------- Para User join UserAvatarStuff
    @Insert
    suspend fun insertUserAvatarStuff(userAvatarStuff: UserAvatarStuffEntity)//funciones suspendidas se ejecutan en corrutinas, y se suspenda si el sistema lo requiere

    //ReadUserAvatarStuffById
    @Query("SELECT * FROM ${Constants.DATABASE_USER_AVATARSTUFF_TABLE} WHERE id_user = :idUser ")
    suspend fun findStuffByType(idUser: Long): List<UserAvatarStuffEntity>
    //---------- Para User join UserAvatarStuff


    @Query("SELECT * FROM ${Constants.DATABASE_USER_AVATARSTUFF_TABLE} ")
    fun loadUserAndAvatarStuff(): List<PackUserAvatarStuffEntity>

}