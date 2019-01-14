package com.techyourchance.mvc.questions.ui.list;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.model.Question;
import com.techyourchance.mvc.questions.ui.common.BaseObservableViewMvc;
import com.techyourchance.mvc.questions.ui.common.ViewMvcFactory;
import com.techyourchance.mvc.questions.ui.toolbar.ToolbarMvcView;

import java.util.List;

public class QuestionsListViewMvcImpl extends BaseObservableViewMvc<QuestionsListViewMvc.Listener>
        implements QuestionsListViewMvc, QuestionsRecyclerAdapter.Listener {

    private QuestionsRecyclerAdapter mAdapter;


    public QuestionsListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(inflater.inflate(R.layout.layout_questions_list, parent, false));

        RecyclerView mRecyclerQuestions = findViewById(R.id.recycler_questions);
        mRecyclerQuestions.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QuestionsRecyclerAdapter(this, viewMvcFactory);
        mRecyclerQuestions.setAdapter(mAdapter);

        Toolbar toolbarParent = findViewById(R.id.toolbar);
        ToolbarMvcView toolbar = viewMvcFactory.getToolbarView(toolbarParent);
        toolbarParent.addView(toolbar.getRootView());
        toolbar.setTitle("Latest Questions");
    }

    @Override
    public void onQuestionClicked(Question question) {
        for (Listener listener : getListeners()) {
            listener.onQuestionClicked(question);
        }
    }

    @Override
    public void bindQuestions(List<Question> questions) {
        findViewById(R.id.listProgressBar).setVisibility(View.GONE);
        mAdapter.bindQuestions(questions);
    }
}
