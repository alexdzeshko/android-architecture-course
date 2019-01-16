package com.techyourchance.mvc.questions.api.stackoverflow

import com.techyourchance.mvc.questions.api.stackoverflow.dto.QuestionDetailsResponseSchema
import com.techyourchance.mvc.questions.api.stackoverflow.dto.QuestionsListResponseSchema

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StackoverflowApi {

    @GET("/questions?sort=activity&order=desc&site=stackoverflow&filter=withbody")
    fun fetchLastActiveQuestions(@Query("pagesize") pageSize: Int?): Call<QuestionsListResponseSchema>

    @GET("/questions/{questionId}?site=stackoverflow&filter=withbody")
    fun fetchQuestionDetails(@Path("questionId") questionId: String): Call<QuestionDetailsResponseSchema>
}
