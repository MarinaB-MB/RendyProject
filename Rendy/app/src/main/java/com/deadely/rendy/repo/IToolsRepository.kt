package com.deadely.rendy.repo

import com.deadely.rendy.model.Lesson
import com.deadely.rendy.model.Test
import com.deadely.rendy.model.Word
import com.deadely.rendy.utils.DataState
import kotlinx.coroutines.flow.Flow

interface IToolsRepository {
    suspend fun getLessons(): Flow<DataState<List<Lesson>>>
    suspend fun getTests(): Flow<DataState<List<Test>>>

    suspend fun getWords(): Flow<DataState<List<Word>>>
    suspend fun getFavoritesWords(): Flow<DataState<List<Word>>>
    fun addToFavoriteWords()
    fun deleteFromFavoritesWords()
}
