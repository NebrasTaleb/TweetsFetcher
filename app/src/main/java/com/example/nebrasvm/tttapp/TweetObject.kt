package com.example.nebrasvm.tttapp

class TweetObject(val statuses: List<SingleTweet>) {
    fun getTweetObject(): List<SingleTweet>{
        return statuses
    }
    class SingleTweet(val text: String)
}


