package com.techyourchance.mvc.questions.ui.toolbar

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.techyourchance.mvc.R
import com.techyourchance.mvc.questions.ui.common.BaseObservableViewMvc

class ToolbarMvcViewImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseObservableViewMvc<ToolbarMvcView.Listener>(), ToolbarMvcView {

    init {
        rootView = inflater.inflate(R.layout.toolbar, parent, false)
    }

    override fun setTitle(title: String) {
        findViewById<TextView>(R.id.title).text = title
    }
}