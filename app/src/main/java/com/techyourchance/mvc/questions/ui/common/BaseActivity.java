package com.techyourchance.mvc.questions.ui.common;

import android.support.v7.app.AppCompatActivity;

import com.techyourchance.mvc.App;
import com.techyourchance.mvc.common.dependencyinjection.ControllerCompositionRoot;

public abstract class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot() {
        if (mControllerCompositionRoot == null) {
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((App) getApplication()).getCompositionRoot(),
                    this
            );
        }
        return mControllerCompositionRoot;
    }

}
