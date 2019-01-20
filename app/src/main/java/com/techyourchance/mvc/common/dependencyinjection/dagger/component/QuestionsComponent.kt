package com.techyourchance.mvc.common.dependencyinjection.dagger.component

import com.techyourchance.mvc.common.dependencyinjection.dagger.ActivityScope
import com.techyourchance.mvc.common.dependencyinjection.dagger.module.ActivityModule
import com.techyourchance.mvc.common.dependencyinjection.dagger.module.QuestionsModule
import com.techyourchance.mvc.questions.model.FetchQuestionDetailsUseCase
import com.techyourchance.mvc.questions.model.FetchQuestionsUseCase
import com.techyourchance.mvc.questions.ui.common.ViewMvcFactory
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class, QuestionsModule::class])
interface QuestionsComponent {

    fun getViewMvcFactory(): ViewMvcFactory
    fun getFetchQuestionsUseCase(): FetchQuestionsUseCase
    fun getFetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
}