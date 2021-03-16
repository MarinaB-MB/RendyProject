package com.deadely.rendy.repo

import com.deadely.rendy.model.User
import com.deadely.rendy.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor() : IUserRepository {
    override suspend fun isActiveUserExist(): Boolean {
        return false
    }

    override suspend fun getUserById(id: String): Flow<DataState<User>> = flow {
    }

    override suspend fun getUserByCredentials(
        email: String,
        password: String
    ): Flow<DataState<User>> = flow {
    }

    override suspend fun deleteUser(id: String) {
    }

    override suspend fun updateUser(id: String) {
    }

    override suspend fun createUser(user: User) {
    }

    override fun getActiveUser(): Flow<DataState<User>> = flow {
    }

    override fun saveActiveUser(user: User) {
    }

    override fun clearActiveUser() {
    }
}
