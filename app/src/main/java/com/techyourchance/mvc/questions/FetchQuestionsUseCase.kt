package com.techyourchance.mvc.questions

import com.techyourchance.mvc.common.Constants
import com.techyourchance.mvc.common.DataListener
import com.techyourchance.mvc.common.UseCase
import com.techyourchance.mvc.networking.QuestionsListResponseSchema
import com.techyourchance.mvc.networking.StackoverflowApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FetchQuestionsUseCase(private val api: StackoverflowApi)
    : UseCase<FetchQuestionsUseCase.Listener>() {

    interface Listener: DataListener<List<Question>>

    fun fetchAndNotify() {
        api.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE)
                .enqueue(object : Callback<QuestionsListResponseSchema> {
                    override fun onResponse(call: Call<QuestionsListResponseSchema>, response: Response<QuestionsListResponseSchema>) {
                        if (response.isSuccessful) {
                            notifySuccess(response.body())
                        } else {
                            notifyError(Exception())
                        }
                    }

                    override fun onFailure(call: Call<QuestionsListResponseSchema>, t: Throwable) {
                        notifyError(t)
                    }
                })
    }

    private fun notifyError(exception: Throwable) {
        listeners.forEach { it.onError(exception) }
    }

    private fun notifySuccess(schema: QuestionsListResponseSchema?) {
        listeners.forEach {
            it.onSuccess(schema?.questions?.map { e -> Question(e.id, e.title) } ?: listOf())
        }
    }
}