package com.techyourchance.mvc.questions.ui.list;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.model.Question;
import com.techyourchance.mvc.questions.ui.common.BaseObservableViewMvc;

public class QuestionsListItemViewMvcImpl extends BaseObservableViewMvc<QuestionsListItemViewMvc.Listener>
        implements QuestionsListItemViewMvc {

    private final TextView mTxtTitle;

    private Question mQuestion;

    public QuestionsListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_question_list_item, parent, false));

        mTxtTitle = findViewById(R.id.txt_title);
        getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getListeners()) {
                    listener.onQuestionClicked(mQuestion);
                }
            }
        });
    }

    @Override
    public void bindQuestion(Question question) {
        mQuestion = question;
        mTxtTitle.setText(question.getTitle());
    }
}