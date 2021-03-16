package com.deadely.rendy.ui.lessons

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.deadely.rendy.R
import com.deadely.rendy.base.BaseFragment
import com.deadely.rendy.databinding.FragmentLessonsBinding
import com.deadely.rendy.model.Lesson
import com.deadely.rendy.utils.DataState
import com.deadely.rendy.utils.ErrorUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class LessonsFragment :
    BaseFragment<FragmentLessonsBinding, LessonsViewModel>(R.layout.fragment_lessons) {
    override val viewModel: LessonsViewModel by viewModels()
    private val lessonsAdapter = LessonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initAdapter()
        viewModel.getLessons()
    }

    private fun initAdapter() {
        binding.rvLessons.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = lessonsAdapter
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.lessons.collect { dataState ->
                when (dataState) {
                    is DataState.Success -> {
                        setData(dataState.data)
                        showProgress(false)
                    }
                    is DataState.Error -> {
                        ErrorUtils.proceed(dataState.exception) {
                            showError(it)
                        }
                        showEmptyList(true)
                        showProgress(false)
                    }
                    is DataState.Loading -> {
                        showProgress(true)
                    }
                }
            }
        }
    }

    private fun setData(lessons: List<Lesson>) {
        showEmptyList(lessons.isEmpty())
        lessonsAdapter.setData(lessons)
    }

    private fun showEmptyList(isEmpty: Boolean) {
        with(binding) {
            rvLessons.isVisible = !isEmpty
            llEmptyList.isVisible = isEmpty
        }
    }

    private fun showError(error: String) {
        AlertDialog.Builder(context)
            .setTitle("Ошибка")
            .setMessage(error)
            .setPositiveButton("Ок") { _, _ ->
            }.create().show()
    }

    private fun showProgress(show: Boolean) {
    }
}
