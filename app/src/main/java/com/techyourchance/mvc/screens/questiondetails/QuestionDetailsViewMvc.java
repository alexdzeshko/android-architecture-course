package com.techyourchance.mvc.screens.questiondetails;

import com.techyourchance.mvc.questions.QuestionDetails;
import com.techyourchance.mvc.screens.common.ViewMvc;

import org.jetbrains.annotations.NotNull;

public interface QuestionDetailsViewMvc extends ViewMvc {

    void bindDetails(QuestionDetails questionDetails);

    void showError(@NotNull Throwable t);
}
