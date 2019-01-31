package com.example.nebrasvm.tttapp

import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

const val TWITTER_ACCESS_TOKEN = "4002126376-HJrTsavjL0tCG6BBWQlLNbIsGAOTjRLRIOqea4v"
const val TWITTER_ACCESS_TOKEN_SECRET = "x4CDSSPXuhWs4gsEFJLs62ki3T9Kb401FfDIDyXkXfFXa"
const val TWITTER_CONSUMER_KEY = "3pviFZKzXssabxhINVxUSRE10"
const val TWITTER_CONSUMER_KEY_SECRET = "WG9ViWyk2Q4SFqxsSkRv0PZcr0HcY7WzQeRCDSfF0LQzGGlSX5"
const val RESOURCE_URL = "https://api.twitter.com/1.1/search/tweets.json"

interface ApiService {
    @GET(value = "tweets.json")
    fun getTweets(@Query(value = "q") keyWord: String , @Header("authorization") authHeader: String): Deferred<TweetObject>

//    companion object {
//        operator fun invoke(): ApiService{
//            val requestInterceptor = Interceptor {chain ->
//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                    .()
//            }
//        }
//    }
}