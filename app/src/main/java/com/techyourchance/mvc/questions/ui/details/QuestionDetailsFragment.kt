package com.techyourchance.mvc.questions.ui.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.techyourchance.mvc.questions.model.FetchQuestionDetailsUseCase
import com.techyourchance.mvc.questions.model.QuestionDetails
import com.techyourchance.mvc.questions.ui.common.BaseFragment


class QuestionDetailsFragment : BaseFragment() {

    private lateinit var view: QuestionDetailsViewMvc
    private lateinit var fetchDetails: FetchQuestionDetailsUseCase
    private val listener = object : FetchQuestionDetailsUseCase.Listener {
        override fun onSuccess(details: QuestionDetails) {
            view.bindDetails(details)
        }

        override fun onError(t: Throwable) {
            view.showError(t)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        view = compositionRoot.viewMvcFactory.getQuestionDetailViewMvc()
        fetchDetails = compositionRoot.fetchQuestionDetailsUseCase
        return view.rootView
    }

    override fun onStart() {
        super.onStart()

        fetchDetails.registerListener(listener)
        loadDetails()
    }

    override fun onStop() {
        super.onStop()
        fetchDetails.unregisterListener(listener)
    }

    private fun loadDetails() {
        fetchDetails.fetchAndNotify(arguments!!.getString(QuestionDetailsActivity.EXTRA_QUESTION_ID))
    }

    companion object {
        fun newInst(qid: String): Fragment {
            val fragment = QuestionDetailsFragment()
            fragment.arguments = Bundle().apply { putString(QuestionDetailsActivity.EXTRA_QUESTION_ID, qid) }
            return fragment
        }
    }
}