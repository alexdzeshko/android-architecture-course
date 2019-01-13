package com.techyourchance.mvc.common.dependencyinjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.techyourchance.mvc.questions.api.stackoverflow.StackoverflowApi;
import com.techyourchance.mvc.questions.model.FetchQuestionDetailsUseCase;
import com.techyourchance.mvc.questions.model.FetchQuestionsUseCase;
import com.techyourchance.mvc.questions.ui.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;
    private final Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot, Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    private StackoverflowApi getStackoverflowApi() {
        return mCompositionRoot.getStackoverflowApi();
    }

    private LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory() {
        return new ViewMvcFactory(getLayoutInflater());
    }

    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }

    public FetchQuestionsUseCase getFetchQuestionsUseCase() {
        return new FetchQuestionsUseCase(getStackoverflowApi());
    }
}
