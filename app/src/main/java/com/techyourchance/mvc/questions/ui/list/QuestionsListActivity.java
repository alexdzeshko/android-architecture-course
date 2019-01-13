package com.techyourchance.mvc.questions.ui.list;

import android.os.Bundle;
import android.widget.Toast;

import com.techyourchance.mvc.R;
import com.techyourchance.mvc.questions.model.FetchQuestionsUseCase;
import com.techyourchance.mvc.questions.model.Question;
import com.techyourchance.mvc.questions.ui.common.BaseActivity;
import com.techyourchance.mvc.questions.ui.details.QuestionDetailsActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class QuestionsListActivity extends BaseActivity implements QuestionsListViewMvcImpl.Listener {

    private QuestionsListViewMvc mViewMvc;
    private FetchQuestionsUseCase mFetchQuestions;
    private final FetchQuestionsUseCase.Listener listener = new FetchQuestionsUseCase.Listener() {
        @Override
        public void onSuccess(List<? extends Question> data) {
            mViewMvc.bindQuestions((List<Question>) data);
        }

        @Override
        public void onError(@NotNull Throwable t) {
            Toast.makeText(QuestionsListActivity.this, R.string.error_network_call_failed, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewMvc = getCompositionRoot().getViewMvcFactory().getQuestionsListViewMvc(null);
        mViewMvc.registerListener(this);

        mFetchQuestions = getCompositionRoot().getFetchQuestionsUseCase();

        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFetchQuestions.registerListener(listener);
        fetchQuestions();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFetchQuestions.unregisterListener(listener);
    }

    private void fetchQuestions() {
        mFetchQuestions.fetchAndNotify();
    }

    @Override
    public void onQuestionClicked(Question question) {
        QuestionDetailsActivity.Companion.start(this, question.getId());
    }
}
