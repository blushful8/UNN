package com.news.blushful.rss

data class Feed(
    val feed: FeedX? = null,
    val items: List<Item>,
    val status: String?
)