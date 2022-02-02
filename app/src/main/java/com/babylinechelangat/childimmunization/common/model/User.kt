package com.babylinechelangat.childimmunization.common.model

import android.util.Log

data class User(
    val id: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val userClass: String?
){
    companion object {
        enum class UserClass {
            Nurse,
            Parent
        }

        fun fromUserClassToString(userClass: UserClass): String? {
            return try {
                userClass.toString()
            } catch (e: Exception) {
                Log.d("castException", e.message.toString())
                null
            }
        }

        fun fromStringToUserClass(userString: String): UserClass? {
            return try {
                UserClass.valueOf(userString)
            } catch(e: Exception) {
                Log.d("castException", e.message.toString())
                null
            }
        }

    }

}
