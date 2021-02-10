package com.fynzero.i_covid.ui.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.NewsModel
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_INFO = "extra_info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val info = intent.getParcelableExtra<NewsModel>(EXTRA_INFO)
        val url = info?.url.toString()

        webView.loadUrl(url)
    }
}