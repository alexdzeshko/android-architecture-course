package com.techyourchance.mvc.questions.ui.common

import android.support.v4.app.Fragment
import com.techyourchance.mvc.App
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.DaggerQuestionsComponent
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.QuestionsComponent
import com.techyourchance.mvc.common.dependencyinjection.dagger.module.ActivityModule


abstract class BaseFragment : Fragment() {

    protected val compositionRoot: ControllerCompositionRoot by lazy {
        ControllerCompositionRoot(
                (requireActivity().application as App).compositionRoot,
                requireActivity()
        )
    }

    protected val questionsComponent: QuestionsComponent by lazy {
        DaggerQuestionsComponent.builder()
                .activityModule(ActivityModule(requireActivity()))
                .appComponent((requireActivity().application as App).appComponent).build()
    }
}