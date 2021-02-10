package com.fynzero.i_covid.ui.news

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.NewsModel
import com.fynzero.i_covid.ui.webview.InfoActivity
import kotlinx.android.synthetic.main.fragment_hoax.*

class HoaxFragment : Fragment() {

    private val list = ArrayList<NewsModel>()
    private val hoaxAdapter = NewsAdapter(list)
    private lateinit var hoaxViewModel: HoaxViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hoax, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_hoax.layoutManager = LinearLayoutManager(activity)
        rv_hoax.setHasFixedSize(true)
        hoaxAdapter.notifyDataSetChanged()
        rv_hoax.adapter = hoaxAdapter

        hoaxViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(HoaxViewModel::class.java)

        hoaxViewModel.setHoax()
        hoaxViewModel.getHoax().observe(requireActivity(), Observer { hoaxList ->
            if (hoaxList != null) {
                hoaxAdapter.setData(hoaxList)
            }
        })

        hoaxAdapter.setOnItemClickCallback(object : NewsAdapter.OnItemClickCallback {
            override fun onItemClicked(newsModel: NewsModel) {
                val intent = Intent(activity, InfoActivity::class.java)
                intent.putExtra(InfoActivity.EXTRA_INFO, newsModel)
                startActivity(intent)
            }

        })
    }
}