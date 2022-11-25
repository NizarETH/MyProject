package com.ofppt.myproject.dao

import androidx.room.*
import com.ofppt.myproject.beans.User

@Dao
interface UserDao {

    @Insert
    fun insertUser(user: User)

    @Query("Select * from User")
    fun gelAllUsers(): List<User>

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)
}
