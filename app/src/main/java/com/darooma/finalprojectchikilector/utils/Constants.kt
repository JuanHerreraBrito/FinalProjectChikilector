package com.darooma.finalprojectchikilector.utils

import com.darooma.finalprojectchikilector.data.db.model.Game1Words

object Constants{
    const val DATABASE_NAME: String = "chikilector_db"
    const val DATABASE_USER_TABLE: String = "user_data_table"
    const val DATABASE_SESSION_TABLE: String = "session_data_table"
    const val DATABASE_AVATARS_STUFF_TABLE: String = "avatar_data_table"
    const val DATABASE_USER_AVATARSTUFF_TABLE: String = "user_avatarstuff_data_table"

    //Tipos para updates
    const val TYPE_HEAD: String = "head"
    const val TYPE_SHOES: String = "shoes"
    const val TYPE_HANDS: String = "hands"

    //Arreglo para juego 1
    val GAME1_WORDS : Array<Game1Words> = arrayOf(
        Game1Words("Araña", "a", "game1_a_1","png"),
        Game1Words("Arcoiris", "a", "game1_a_2","png"),
        Game1Words("Avión", "a", "game1_a_3","png"),
        Game1Words("Árbol", "a", "game1_a_4","png"),
        Game1Words("Abeja", "a", "game1_a_5","png"),

        Game1Words("Escalera", "e", "game1_e_1","png"),
        Game1Words("Elefante", "e", "game1_e_2","png"),
        Game1Words("Elote", "e", "game1_e_3","png"),
        Game1Words("Escalera", "e", "game1_e_4","png"),
        Game1Words("Estrella", "e", "game1_e_5","png"),

        Game1Words("Imán", "i", "game1_i_1","png"),
        Game1Words("Iglesia", "i", "game1_i_2","png"),
        Game1Words("Iglu", "i", "game1_i_3","png"),
        Game1Words("Isla", "i", "game1_i_4","png"),
        Game1Words("Iguana", "i", "game1_i_5","png"),

        Game1Words("Ola", "o", "game1_o_1","png"),
        Game1Words("Oruga", "o", "game1_o_2","png"),
        Game1Words("Oveja", "o", "game1_o_3","png"),
        Game1Words("Ojo", "o", "game1_o_4","png"),
        Game1Words("Oso", "o", "game1_o_5","png"),

        Game1Words("Uno", "u", "game1_u_1","png"),
        Game1Words("Uña", "u", "game1_u_2","png"),
        Game1Words("Unicornio", "u", "game1_u_3","png"),
        Game1Words("Uva", "u", "game1_u_4","png"),
        Game1Words("Utiles", "u", "game1_u_5","png")
    )

}