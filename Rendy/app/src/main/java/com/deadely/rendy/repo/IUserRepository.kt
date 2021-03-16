package com.deadely.rendy.repo

import com.deadely.rendy.model.User
import com.deadely.rendy.utils.DataState
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    suspend fun isActiveUserExist(): Boolean
    suspend fun getUserById(id: String): Flow<DataState<User>>
    suspend fun getUserByCredentials(email: String, password: String): Flow<DataState<User>>
    suspend fun deleteUser(id: String)
    suspend fun updateUser(id: String)
    suspend fun createUser(user: User)

    fun getActiveUser(): Flow<DataState<User>>
    fun saveActiveUser(user: User)
    fun clearActiveUser()
}
