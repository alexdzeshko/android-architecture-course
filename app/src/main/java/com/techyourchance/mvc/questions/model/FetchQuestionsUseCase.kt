package com.techyourchance.mvc.questions.model

import com.techyourchance.mvc.common.Constants
import com.techyourchance.mvc.common.DataListener
import com.techyourchance.mvc.common.UseCase
import com.techyourchance.mvc.questions.api.stackoverflow.StackoverflowApi
import com.techyourchance.mvc.questions.api.stackoverflow.dto.QuestionsListResponseSchema
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response


class FetchQuestionsUseCase(private val api: StackoverflowApi)
    : UseCase<FetchQuestionsUseCase.Listener>() {

    interface Listener: DataListener<List<Question>>

    private val uiScope = CoroutineScope(Dispatchers.Main)

    fun fetchAndNotify() {
        uiScope.launch {
            val response = loadFromNetwork()
            handleResponse(response)
        }
    }

    private suspend fun loadFromNetwork() = withContext(Dispatchers.IO) {
        api.fetchLastActiveQuestions(Constants.QUESTIONS_LIST_PAGE_SIZE).execute()
    }

    private fun handleResponse(response: Response<QuestionsListResponseSchema>) {
        if (response.isSuccessful) {
            notifySuccess(response.body())
        } else {
            notifyError(Exception())
        }
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