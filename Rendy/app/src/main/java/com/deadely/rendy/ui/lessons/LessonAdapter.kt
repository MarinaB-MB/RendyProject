package com.deadely.rendy.ui.lessons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deadely.rendy.R
import com.deadely.rendy.databinding.ItemLessonBinding
import com.deadely.rendy.model.Lesson
import com.deadely.rendy.ui.lessons.LessonAdapter.ViewHolder

class LessonAdapter : RecyclerView.Adapter<ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemLessonBinding.bind(view)

        fun bind(lesson: Lesson) {
            with(itemView) {
                binding.tvTitle.text = lesson.title
                if (lesson.isChecked) {
                    binding.vProgress.setBackgroundResource(R.color.green)
                } else {
                    binding.vProgress.setBackgroundResource(R.color.red)
                }
                setOnClickListener {
                    onClickListener?.onClick(lesson)
                }
            }
        }
    }

    private var list = mutableListOf<Lesson>()
    private var onClickListener: OnClickListener? = null

    fun setOnClickListener(clickListener: OnClickListener) {
        onClickListener = clickListener
    }

    fun setData(newList: List<Lesson>) {
        list.apply {
            clear()
            addAll(newList)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewTyp: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(list[position])

    override fun getItemCount(): Int = list.size

    interface OnClickListener {
        fun onClick(lesson: Lesson)
    }
}
