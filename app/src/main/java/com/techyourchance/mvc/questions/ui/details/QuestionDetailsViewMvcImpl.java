package com.techyourchance.mvc.questions.ui.details;

import android.graphics.Color;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.model.QuestionDetails;
import com.techyourchance.mvc.questions.ui.common.BaseViewMvc;
import com.techyourchance.mvc.questions.ui.common.ViewMvcFactory;
import com.techyourchance.mvc.questions.ui.toolbar.ToolbarMvcView;

import org.jetbrains.annotations.NotNull;

public class QuestionDetailsViewMvcImpl extends BaseViewMvc implements QuestionDetailsViewMvc {
    private static final String TAG = "QuestionDetailsViewMvcI";

    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup root, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.question_details, root, false));

        Toolbar toolbarParent = findViewById(R.id.toolbar);
        ToolbarMvcView toolbar = viewMvcFactory.getToolbarView(toolbarParent);
        toolbarParent.addView(toolbar.getRootView());
        toolbar.setTitle("Question Details");
    }

    @Override
    public void bindDetails(QuestionDetails questionDetails) {
        findViewById(R.id.detailsProgressBar).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.topicTitle)).setText(questionDetails.getTitle());
        ((TextView) findViewById(R.id.topicBody)).setText(Html.fromHtml(questionDetails.getBody()));
    }

    @Override
    public void showError(@NotNull Throwable t) {
        Log.d(TAG, "showError() called with: t = [" + t + "]");
        findViewById(R.id.detailsProgressBar).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.topicTitle)).setText("Error");
        TextView body = findViewById(R.id.topicBody);
        body.setText(t.getMessage());
        body.setTextColor(Color.RED);
    }

}
