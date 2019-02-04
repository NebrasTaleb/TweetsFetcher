package com.example.nebrasvm.tttapp

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {


    companion object {
        private var tweetsObject: TweetObject? = TweetObject(listOf())
        private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
            .baseUrl("https://api.twitter.com/1.1/search/")
            .addConverterFactory(GsonConverterFactory.create())
        private val retrofit: Retrofit = retrofitBuilder.build()

        fun <S> createService(serviceClass: Class<S>): S {
            return retrofit.create(serviceClass)
        }
    }

}