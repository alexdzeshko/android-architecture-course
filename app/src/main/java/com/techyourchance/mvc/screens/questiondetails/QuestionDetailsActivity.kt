package com.techyourchance.mvc.screens.questiondetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.techyourchance.mvc.questions.FetchQuestionDetailsUseCase
import com.techyourchance.mvc.questions.FetchQuestionDetailsUseCase.Listener
import com.techyourchance.mvc.questions.QuestionDetails
import com.techyourchance.mvc.screens.common.BaseActivity

class QuestionDetailsActivity : BaseActivity() {
    private lateinit var view: QuestionDetailsViewMvc
    private lateinit var fetchDetails: FetchQuestionDetailsUseCase
    private val listener = object : Listener {
        override fun onSuccess(details: QuestionDetails) {
            view.bindDetails(details)
        }

        override fun onError(t: Throwable) {
            view.showError(t)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = compositionRoot.viewMvcFactory.getQuestionDetailViewMvc()
        fetchDetails = compositionRoot.fetchQuestionDetailsUseCase
        setContentView(view.rootView)
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
        fetchDetails.fetchAndNotify(intent.getStringExtra(EXTRA_QUESTION_ID));
    }

    companion object {

        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"

        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }
}
