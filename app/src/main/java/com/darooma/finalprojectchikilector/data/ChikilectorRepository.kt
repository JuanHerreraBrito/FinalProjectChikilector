package com.darooma.finalprojectchikilector.data


import com.darooma.finalprojectchikilector.data.db.ChikilectorDao
import com.darooma.finalprojectchikilector.data.db.model.SessionEntity
import com.darooma.finalprojectchikilector.data.db.model.UserEntity
import com.darooma.finalprojectchikilector.utils.Constants


//En este se definen cuestioens de datos online o del back
//
class ChikilectorRepository(private val chikilectorDao: ChikilectorDao) {
//Arquitectura limpia, el interactor se tiene antes del repositorio

    //User
    suspend fun insertUser(user: UserEntity) : Long{
        return chikilectorDao.insertUser(user)
    }
    suspend fun getUserById(userId: Long){
        chikilectorDao.findUserById(userId)
    }
    suspend fun getUserByName(name: String) : UserEntity{
        return chikilectorDao.findUserByName(name)
    }
    //User
    //Session
    suspend fun insertSession(session: SessionEntity){
        chikilectorDao.insertSesion(session)
    }
    suspend fun getActualSessionUser() : UserEntity? {
        val list = chikilectorDao.getSessionUser()
        if (list.isNotEmpty()){
            return list[0]
        }else{
            return null
        }
    }

    suspend fun countSessions(): Integer{
        return chikilectorDao.countSessions()
    }

    suspend fun findSession(): List<SessionEntity>{
        return chikilectorDao.findSession()
    }

    suspend fun deleteAllSessions(){
        return chikilectorDao.deleteAllSessions()
    }

    //Session

    //types: "head", "shoes", "hands"
    suspend fun updateUserStuffByType(avatarStuff: Long, idUser: Long, type: String){
        when (type) {
            Constants.TYPE_HEAD -> chikilectorDao.updateUserHead(avatarStuff,idUser)
            Constants.TYPE_HANDS -> chikilectorDao.updateUserHands(avatarStuff,idUser)
            Constants.TYPE_SHOES -> chikilectorDao.updateUserShoes(avatarStuff,idUser)
            else -> { // Note the block
                print("no existe el tipo requerido")
            }
        }
    }

    suspend fun add1ProgressGame1(idUser: Long){
        chikilectorDao.updateUserProgressG1(idUser)
    }


    //suspend fun getAllRadMovies(): List<UserEntity> = chikilectorDao.getAllRadMovies()

//    suspend fun updateRadMovie(movie: UserEntity){
//        chikilectorDao.updateRadMovie(movie)
//    }

    //suspend fun deleteRadMovie(movie: UserEntity){
    //    chikilectorDao.deleteRadMovie(movie)
    //}
}