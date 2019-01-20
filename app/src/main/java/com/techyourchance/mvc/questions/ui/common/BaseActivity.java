package com.techyourchance.mvc.questions.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.techyourchance.mvc.App;
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot;
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.DaggerQuestionsComponent;
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.QuestionsComponent;

public abstract class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;
    private QuestionsComponent questionsComponent;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((App) getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public QuestionsComponent getQuestionsComponent() {
        if (questionsComponent == null) {
            questionsComponent = DaggerQuestionsComponent.builder().appComponent(((App) getApplication()).getAppComponent()).build();
        }
        return questionsComponent;
    }
}
