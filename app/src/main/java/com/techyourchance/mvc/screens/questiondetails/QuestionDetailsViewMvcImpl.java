package com.techyourchance.mvc.screens.questiondetails;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.BaseViewMvc;

import org.jetbrains.annotations.NotNull;

public class QuestionDetailsViewMvcImpl extends BaseViewMvc implements QuestionDetailsViewMvc {
    private static final String TAG = "QuestionDetailsViewMvcI";

    public QuestionDetailsViewMvcImpl(LayoutInflater inflater, ViewGroup root) {
        setRootView(inflater.inflate(R.layout.question_details, root, false));
    }

    @Override
    public void bindDetails(QuestionDetails questionDetails) {
        Log.d(TAG, "bindDetails() called with: questionDetails = [" + questionDetails + "]");
        ((TextView) findViewById(R.id.topicTitle)).setText(questionDetails.getTitle());
        ((TextView) findViewById(R.id.topicBody)).setText(questionDetails.getBody());
    }

    @Override
    public void showError(@NotNull Throwable t) {
        Log.d(TAG, "showError() called with: t = [" + t + "]");
        ((TextView) findViewById(R.id.topicTitle)).setText("Error");
        TextView body = findViewById(R.id.topicBody);
        body.setText(t.getMessage());
        body.setTextColor(Color.RED);
    }

}
