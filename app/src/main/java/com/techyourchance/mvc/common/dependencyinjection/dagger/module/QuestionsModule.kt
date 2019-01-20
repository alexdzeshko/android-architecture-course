package com.techyourchance.mvc.common.dependencyinjection.dagger.module

import com.techyourchance.mvc.questions.api.stackoverflow.StackoverflowApi
import com.techyourchance.mvc.questions.model.FetchQuestionDetailsUseCase
import com.techyourchance.mvc.questions.model.FetchQuestionsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class QuestionsModule @Inject constructor() {

    @Provides
    fun providesFetchQuestionDetailsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionDetailsUseCase {
        return FetchQuestionDetailsUseCase(stackoverflowApi)
    }

    @Provides
    fun providesFetchQuestionsUseCase(stackoverflowApi: StackoverflowApi): FetchQuestionsUseCase {
        return FetchQuestionsUseCase(stackoverflowApi)
    }

}