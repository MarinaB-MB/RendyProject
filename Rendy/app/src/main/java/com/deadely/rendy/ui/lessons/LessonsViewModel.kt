package com.deadely.rendy.ui.lessons

import androidx.lifecycle.viewModelScope
import com.deadely.rendy.base.BaseViewModel
import com.deadely.rendy.model.Lesson
import com.deadely.rendy.repo.UserRepository
import com.deadely.rendy.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonsViewModel @Inject constructor(private val userRepository: UserRepository) :
    BaseViewModel() {

    private val _lessons = MutableStateFlow<DataState<List<Lesson>>>(DataState.Success(listOf()))
    val lessons = _lessons

    fun getLessons() = viewModelScope.launch {
        /* repository.getLessons().collect { dataState ->
             when (dataState) {
                 is DataState.Success -> {
                     _lessons.value = DataState.Success(dataState.data)
                 }
                 is DataState.Error -> {
                     _lessons.value = DataState.Error(dataState.exception)
                 }
                 is DataState.Loading -> {
                     _lessons.value = DataState.Loading
                 }
             }
         }*/
    }
}
