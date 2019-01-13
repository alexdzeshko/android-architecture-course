package com.techyourchance.mvc.questions.ui.list;

import com.techyourchance.mvc.questions.model.Question;
import com.techyourchance.mvc.questions.ui.common.ObservableViewMvc;

import java.util.List;

public interface QuestionsListViewMvc extends ObservableViewMvc<QuestionsListViewMvc.Listener> {

    public interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestions(List<Question> questions);

}
