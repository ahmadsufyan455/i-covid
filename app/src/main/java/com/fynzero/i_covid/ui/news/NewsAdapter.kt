package com.fynzero.i_covid.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fynzero.i_covid.R
import com.fynzero.i_covid.model.NewsModel
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(private val newsList: ArrayList<NewsModel>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(list: ArrayList<NewsModel>) {
        newsList.clear()
        newsList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        ))
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(newsList[holder.adapterPosition])
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(newsModel: NewsModel) {
            with(itemView) {
                txt_news_title.text = newsModel.title
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(newsModel: NewsModel)
    }
}