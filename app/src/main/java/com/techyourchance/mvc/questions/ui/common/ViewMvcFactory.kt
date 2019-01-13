package com.techyourchance.mvc.questions.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup

import com.techyourchance.mvc.questions.ui.details.QuestionDetailsViewMvc
import com.techyourchance.mvc.questions.ui.details.QuestionDetailsViewMvcImpl
import com.techyourchance.mvc.questions.ui.list.QuestionsListItemViewMvc
import com.techyourchance.mvc.questions.ui.list.QuestionsListItemViewMvcImpl
import com.techyourchance.mvc.questions.ui.list.QuestionsListViewMvc
import com.techyourchance.mvc.questions.ui.list.QuestionsListViewMvcImpl
import com.techyourchance.mvc.questions.ui.toolbar.ToolbarMvcView
import com.techyourchance.mvc.questions.ui.toolbar.ToolbarMvcViewImpl

class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {

    fun getQuestionDetailViewMvc(parent: ViewGroup? = null): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getQuestionsListItemViewMvc(parent: ViewGroup?): QuestionsListItemViewMvc {
        return QuestionsListItemViewMvcImpl(mLayoutInflater, parent)
    }

    fun getToolbarView(parent: ViewGroup): ToolbarMvcView {
        return ToolbarMvcViewImpl(mLayoutInflater, parent)
    }
}

