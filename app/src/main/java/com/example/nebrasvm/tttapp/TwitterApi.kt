package com.example.nebrasvm.tttapp

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


val TWITTER_ACCESS_TOKEN = "4002126376-HJrTsavjL0tCG6BBWQlLNbIsGAOTjRLRIOqea4v"
val TWITTER_ACCESS_TOKEN_SECRET = "x4CDSSPXuhWs4gsEFJLs62ki3T9Kb401FfDIDyXkXfFXa"
val TWITTER_CONSUMER_KEY = "3pviFZKzXssabxhINVxUSRE10"
val TWITTER_CONSUMER_KEY_SECRET = "WG9ViWyk2Q4SFqxsSkRv0PZcr0HcY7WzQeRCDSfF0LQzGGlSX5"
val TWITTER_BASE_URL = "https://api.twitter.com/1.1/search/"

interface TwitterApi {

        @Headers("Authorization: OAuth oauth_consumer_key=\"3pviFZKzXssabxhINVxUSRE10\",oauth_token=\"4002126376-HJrTsavjL0tCG6BBWQlLNbIsGAOTjRLRIOqea4v\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1549121461\",oauth_nonce=\"kJg9hrnMULQ\",oauth_version=\"1.0\",oauth_signature=\"WW8jVbaX2D4UZNdq%2Bk2Fzaydnhs%3D\"")
        @GET(value = "tweets.json")
    fun getTweets(@Query(value = "q") keyWord: String ): retrofit2.Call<TweetObject>
                  //@Header("oauth_timestamp") generatedTimestamp: String
                  //@Header("oauth_nonce") generatedNonce: String ): retrofit2.Call<TweetObject>

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