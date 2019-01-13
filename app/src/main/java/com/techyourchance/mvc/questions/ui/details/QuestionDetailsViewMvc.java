package com.techyourchance.mvc.questions.ui.details;

import com.techyourchance.mvc.questions.model.QuestionDetails;
import com.techyourchance.mvc.questions.ui.common.ViewMvc;

import org.jetbrains.annotations.NotNull;

public interface QuestionDetailsViewMvc extends ViewMvc {

    void bindDetails(QuestionDetails questionDetails);

    void showError(@NotNull Throwable t);
}
