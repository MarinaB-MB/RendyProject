package com.deadely.rendy.repo

import com.deadely.rendy.model.Lesson
import com.deadely.rendy.model.Test
import com.deadely.rendy.model.Word
import com.deadely.rendy.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ToolsRepository @Inject constructor() : IToolsRepository {
    override suspend fun getLessons(): Flow<DataState<List<Lesson>>> = flow {
    }

    override suspend fun getTests(): Flow<DataState<List<Test>>> = flow {
    }

    override suspend fun getWords(): Flow<DataState<List<Word>>> = flow {
    }

    override suspend fun getFavoritesWords(): Flow<DataState<List<Word>>> = flow {
    }

    override fun addToFavoriteWords() {
    }

    override fun deleteFromFavoritesWords() {
    }
}
