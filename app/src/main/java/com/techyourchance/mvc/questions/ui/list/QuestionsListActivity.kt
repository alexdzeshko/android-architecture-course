package com.techyourchance.mvc.questions.ui.list

import android.os.Bundle
import android.support.v4.app.Fragment
import com.techyourchance.mvc.R
import com.techyourchance.mvc.questions.ui.common.BaseActivity

class QuestionsListActivity : BaseActivity() {

    private lateinit var questionsListFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.app_container)

        if (savedInstanceState == null) {
            questionsListFragment = QuestionsListFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.root_container, questionsListFragment)
                    .commit()
        } else {
            questionsListFragment = supportFragmentManager.findFragmentById(R.id.root_container)
        }
    }

}
