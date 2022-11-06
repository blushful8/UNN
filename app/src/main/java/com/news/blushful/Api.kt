package com.news.blushful

import com.news.blushful.rss.Feed
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fnews.un.org%2Ffeed%2Fsubscribe%2Fen%2Fnews%2Fall%2Frss.xml")
    suspend fun getFeedInfo(): Response<Feed>
}