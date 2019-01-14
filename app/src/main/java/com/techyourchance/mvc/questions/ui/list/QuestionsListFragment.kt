package com.techyourchance.mvc.questions.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.techyourchance.mvc.R
import com.techyourchance.mvc.questions.model.FetchQuestionsUseCase
import com.techyourchance.mvc.questions.model.Question
import com.techyourchance.mvc.questions.ui.common.BaseFragment
import com.techyourchance.mvc.questions.ui.details.QuestionDetailsActivity


class QuestionsListFragment: BaseFragment(), QuestionsListViewMvc.Listener {

    private var mViewMvc: QuestionsListViewMvc? = null
    private var mFetchQuestions: FetchQuestionsUseCase? = null
    private val listener = object : FetchQuestionsUseCase.Listener {
        override fun onSuccess(data: List<Question>) {
            mViewMvc?.bindQuestions(data)
        }

        override fun onError(t: Throwable) {
            Toast.makeText(requireContext(), R.string.error_network_call_failed, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        mViewMvc = compositionRoot.viewMvcFactory.getQuestionsListViewMvc(null)
        mViewMvc?.registerListener(this)

        mFetchQuestions = compositionRoot.fetchQuestionsUseCase

        return mViewMvc!!.rootView
    }

    override fun onStart() {
        super.onStart()
        mFetchQuestions?.registerListener(listener)
        fetchQuestions()
    }

    override fun onStop() {
        super.onStop()
        mFetchQuestions?.unregisterListener(listener)
    }

    private fun fetchQuestions() {
        mFetchQuestions?.fetchAndNotify()
    }

    override fun onQuestionClicked(question: Question) {
        QuestionDetailsActivity.start(requireContext(), question.id)
    }
}