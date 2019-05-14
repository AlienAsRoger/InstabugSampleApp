package com.developer4droid.instabug

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

//class ReportBugActivity : BaseActivity() {
class ReportBugActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, ReportBugActivity::class.java)
        }
    }

    @Inject
    lateinit var instabug: ChessInstabug

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_report_bug)
        instabug.init(application)
    }

    override fun onResume() {
        super.onResume()
        instabug.show()
        // we only need this activity to launch popup and trick lifecycle events for instabug SDK
        finish()
    }
}