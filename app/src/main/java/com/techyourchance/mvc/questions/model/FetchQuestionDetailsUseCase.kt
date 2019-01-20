package com.techyourchance.mvc.questions.model

import com.techyourchance.mvc.common.UseCase
import com.techyourchance.mvc.questions.api.stackoverflow.StackoverflowApi
import com.techyourchance.mvc.questions.api.stackoverflow.dto.QuestionDetailsResponseSchema
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchQuestionDetailsUseCase(private val stackoverflowApi: StackoverflowApi) : UseCase<FetchQuestionDetailsUseCase.Listener>() {

    interface Listener {
        fun onSuccess(details: QuestionDetails)
        fun onError(t: Throwable)
    }

    fun fetchAndNotify(qId: String) {
        val call = stackoverflowApi.fetchQuestionDetails(qId)
        call.enqueue(object : Callback<QuestionDetailsResponseSchema> {
            override fun onFailure(call: Call<QuestionDetailsResponseSchema>, t: Throwable) {
                notifyError(t)
            }

            override fun onResponse(call: Call<QuestionDetailsResponseSchema>, response: Response<QuestionDetailsResponseSchema>) {
                if (response.isSuccessful) {
                    notifySuccess(response.body())
                } else {
                    notifyError(Exception())
                }
            }

        })
    }

    private fun notifySuccess(response: QuestionDetailsResponseSchema?) {
        listeners.forEach {
            val schema = response?.question
            it.onSuccess(QuestionDetails(schema?.id, schema?.title, schema?.body))
        }
    }

    private fun notifyError(t: Throwable) {
        listeners.forEach { it.onError(t) }
    }
}
