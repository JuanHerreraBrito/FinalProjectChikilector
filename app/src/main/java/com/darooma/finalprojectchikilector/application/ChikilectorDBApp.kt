package com.darooma.finalprojectchikilector.application

import android.app.Application
import com.darooma.finalprojectchikilector.data.ChikilectorRepository
import com.darooma.finalprojectchikilector.data.db.ChikilectorDatabase

//Para poderle meter inyeccion de dependencias

class ChikilectorDBApp(): Application() {
    private val  database by lazy{
        ChikilectorDatabase.getDatabase(this@ChikilectorDBApp)
    }

    val repository by lazy{
        ChikilectorRepository(database.chikilectorDao())
    }
}