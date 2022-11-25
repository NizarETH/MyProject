package com.ofppt.myproject.repository

import android.content.Context
import com.ofppt.myproject.beans.User
import com.ofppt.myproject.dao.UserDao
import com.ofppt.myproject.db.AppDatabase

class UserRepository (context: Context) {

    var db: UserDao = AppDatabase.getInstance(context)?.userDao()!!

    //Fetch All the Users
    fun getAllUsers(): List<User> {
        return db.gelAllUsers()
    }

    // Insert new user
    fun insertUser(user: User) {
        db.insertUser(user)

    }
    // Insert All users
    fun insertAllUserS(users: MutableList<User>) {
        for(user in users)
            db.insertUser(user)

    }

    // update user
    fun updateUser(users: User) {
        db.updateUser(users)
    }

    // Delete user
    fun deleteUser(users: User) {
        db.deleteUser(users)
    }

}