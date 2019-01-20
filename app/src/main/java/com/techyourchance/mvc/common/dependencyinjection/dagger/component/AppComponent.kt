package com.techyourchance.mvc.common.dependencyinjection.dagger.component

import com.techyourchance.mvc.common.dependencyinjection.dagger.module.ApiModule
import com.techyourchance.mvc.questions.api.stackoverflow.StackoverflowApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {

    fun stackOverflowApi(): StackoverflowApi
}