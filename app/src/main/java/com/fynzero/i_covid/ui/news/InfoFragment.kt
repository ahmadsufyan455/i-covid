package com.fynzero.i_covid.ui.news

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.NewsModel
import com.fynzero.i_covid.ui.webview.InfoActivity
import kotlinx.android.synthetic.main.fragment_info.*

class InfoFragment : Fragment() {

    private lateinit var infoViewModel: InfoViewModel
    private val list = ArrayList<NewsModel>()
    private val infoAdapter = NewsAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_info.layoutManager = LinearLayoutManager(activity)
        rv_info.setHasFixedSize(true)
        infoAdapter.notifyDataSetChanged()
        rv_info.adapter = infoAdapter

        infoViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(InfoViewModel::class.java)

        infoViewModel.setInfo()
        infoViewModel.getInfo().observe(viewLifecycleOwner, Observer { infoList ->
            if (infoList != null) {
                infoAdapter.setData(infoList)
            }
        })

        infoAdapter.setOnItemClickCallback(object : NewsAdapter.OnItemClickCallback {
            override fun onItemClicked(newsModel: NewsModel) {
                val intent = Intent(activity, InfoActivity::class.java)
                intent.putExtra(InfoActivity.EXTRA_INFO, newsModel)
                startActivity(intent)
            }

        })
    }
}