package com.techyourchance.mvc.questions.ui.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.techyourchance.mvc.R
import com.techyourchance.mvc.questions.ui.common.BaseActivity

class QuestionDetailsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_container)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.root_container, QuestionDetailsFragment.newInst(intent.getStringExtra(EXTRA_QUESTION_ID)))
                    .commit()
        }
    }

    companion object {

        const val EXTRA_QUESTION_ID = "EXTRA_QUESTION_ID"

        fun start(context: Context, questionId: String) {
            val intent = Intent(context, QuestionDetailsActivity::class.java)
            intent.putExtra(EXTRA_QUESTION_ID, questionId)
            context.startActivity(intent)
        }
    }
}
