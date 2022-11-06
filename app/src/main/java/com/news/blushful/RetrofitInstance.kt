package com.news.blushful

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

        private val retrofit = Retrofit.Builder()
            .baseUrl(" https://api.rss2json.com/v1/api.json/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: Api = retrofit.create(Api::class.java)
    }
