package com.techyourchance.mvc.questions.ui.list;

import com.techyourchance.mvc.questions.model.Question;
import com.techyourchance.mvc.questions.ui.common.ObservableViewMvc;

public interface QuestionsListItemViewMvc extends ObservableViewMvc<QuestionsListItemViewMvc.Listener> {

    interface Listener {
        void onQuestionClicked(Question question);
    }

    void bindQuestion(Question question);
}
