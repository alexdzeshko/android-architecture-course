package com.techyourchance.mvc.questions.ui.common

import android.support.v4.app.Fragment
import com.techyourchance.mvc.App
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot


abstract class BaseFragment : Fragment() {

    protected val compositionRoot: ControllerCompositionRoot by lazy {
        ControllerCompositionRoot(
                (requireActivity().application as App).compositionRoot,
                requireActivity()
        )
    }
}