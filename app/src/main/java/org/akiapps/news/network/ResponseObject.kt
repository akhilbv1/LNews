package org.akiapps.news.network

data class ResponseObject( var status:String,var errorBody: ErrorBody?,var totalResults:Int,val articles:ArrayList<Article>)

data class ErrorBody(var code:String,var message:String)

