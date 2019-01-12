package com.techyourchance.mvc.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup

import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvc
import com.techyourchance.mvc.screens.questiondetails.QuestionDetailsViewMvcImpl
import com.techyourchance.mvc.screens.questionslist.QuestionsListItemViewMvc
import com.techyourchance.mvc.screens.questionslist.QuestionsListItemViewMvcImpl
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvc
import com.techyourchance.mvc.screens.questionslist.QuestionsListViewMvcImpl
class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {

    fun getQuestionDetailViewMvc(parent: ViewGroup? = null): QuestionDetailsViewMvc {
        return QuestionDetailsViewMvcImpl(mLayoutInflater, parent)
    }

    fun getQuestionsListViewMvc(parent: ViewGroup?): QuestionsListViewMvc {
        return QuestionsListViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getQuestionsListItemViewMvc(parent: ViewGroup?): QuestionsListItemViewMvc {
        return QuestionsListItemViewMvcImpl(mLayoutInflater, parent)
    }
}

