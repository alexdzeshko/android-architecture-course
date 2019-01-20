package com.techyourchance.mvc.common.dependencyinjection.dagger.module

import android.app.Activity
import android.view.LayoutInflater
import com.techyourchance.mvc.common.dependencyinjection.dagger.ActivityScope
import com.techyourchance.mvc.questions.ui.common.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: Activity) {

    @Provides @ActivityScope
    fun provideLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(activity)
    }

    @Provides @ActivityScope
    fun providesViewMvcFactory(layoutInflater: LayoutInflater): ViewMvcFactory {
        return ViewMvcFactory(layoutInflater)
    }

}