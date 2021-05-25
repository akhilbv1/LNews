package org.akiapps.news.country

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.akiapps.news.databinding.RowItemNewsBinding
import org.akiapps.news.extensions.GlideUtils
import org.akiapps.news.network.Article

class CountriesListAdapter(val articlesList: ArrayList<Article>) :
    RecyclerView.Adapter<CountriesListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountriesListAdapter.ViewHolder {
        val binding = RowItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountriesListAdapter.ViewHolder, position: Int) {
        holder.updateUi(position)
    }

    override fun getItemCount(): Int = articlesList.size

    inner class ViewHolder(private val binding: RowItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun updateUi(position: Int) {
            val obj = articlesList[position]
            Glide.with(binding.root.context).load(obj.urlToImage)
                .apply(GlideUtils.getRoundedCornerOption(15)).into(binding.ivNewsBanner)
            binding.tvNewsDes.text = obj.title
            if (obj.author.isNullOrEmpty())
                binding.tvNewsChannel.visibility = View.GONE
            else
                binding.tvNewsChannel.text = obj.author
        }
    }
}