package com.techyourchance.mvc.questions.ui.toolbar

import com.techyourchance.mvc.questions.ui.common.ObservableViewMvc


interface ToolbarMvcView: ObservableViewMvc<ToolbarMvcView.Listener> {

    interface Listener {
        fun onBackPress()
    }

    fun setTitle(title: String)
}