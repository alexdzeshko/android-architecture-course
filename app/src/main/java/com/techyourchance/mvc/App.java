package com.techyourchance.mvc;

import android.app.Application;

import com.techyourchance.mvc.common.dependencyinjection.CompositionRoot;
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.AppComponent;
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.DaggerAppComponent;
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.DaggerQuestionsComponent;
import com.techyourchance.mvc.common.dependencyinjection.dagger.component.QuestionsComponent;

public class App extends Application {

    private CompositionRoot mCompositionRoot;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
        appComponent = DaggerAppComponent.create();

    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
