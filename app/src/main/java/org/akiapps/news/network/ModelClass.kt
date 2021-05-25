package org.akiapps.news.network

import com.google.gson.annotations.SerializedName

data class articles(val articles:ArrayList<Article>)

data class Article(val source:source,val author:String?,val title:String,val description:String,val url:String,val urlToImage:String,val publishedAt:String,
                   val content:String)

data class source(val name:String)
