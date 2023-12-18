package com.darooma.finalprojectchikilector.utils

import android.app.AlertDialog
import android.content.Context
import android.util.Patterns

class GeneralTools {

    companion object {
        fun sendAlert(titulo: String, mensaje: String, context: Context) {
            val dialog = AlertDialog.Builder(context)
                .setTitle(titulo)
                .setMessage(mensaje)
                .setPositiveButton("Entendido") { view, _ ->
                    view.dismiss()
                    //                Poner accion al dar click en boton Eliminar
                }
                .setCancelable(false)
                .create()
            dialog.show()
        }

        fun isValidEmail(target: CharSequence?): Boolean {
            if (target != null) {
                return target.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(target).matches()
            }else{
                return false
            }
        }
    }
}

