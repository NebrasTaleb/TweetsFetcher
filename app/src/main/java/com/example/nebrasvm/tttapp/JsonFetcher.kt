package com.example.nebrasvm.tttapp

import android.app.PendingIntent.getActivity
import android.content.Context
import android.widget.Toast
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.security.AccessController.getContext
import kotlin.contracts.contract

class JsonFetcher constructor(baseUrl: String, appContext: Context) {

    val url: String = baseUrl
    val context = appContext
   // var fetchedListOfTweets: List<ListItem>? = listOf()
    fun fetchJson(): List<ListItem> {
      //  val request = Request.Builder().url(url).build()
      //  val client = OkHttpClient().newCall(request).enqueue(object : Callback {
        //    override fun onResponse(call: Call, response: Response) {
          //      val requestBody = response.body()?.string()
         //       fetchedListOfTweets = deserializeJson(requestBody)
         //   }
//
         //   override fun onFailure(call: Call, e: IOException) {
       //         println("Oops! Failed to execute request!")
      //      }
      //  })

        val tempResponse = "{  \n" +
                "   \"statuses\":[  \n" +
                "      {  \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"  Damascus is the oldest populated capital in the world.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\" Istanbul is a beautiful city.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Dubai is located in UAE.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\" Istanbul is located in the north west of Turkey.\"},\n" +
                "      {\"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Istanbul is located in two continents.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Damascus is the capital of Syria.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Dubai has the tallest structure and building in the world.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Damascus is a beautiful city located in Syria.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Muhammad Nebras Taleb was living in Damascus.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\"Muhammad Nebras Taleb is living in Istanbul right now.\"},\n" +
                "      {\"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\" Muhammad Nebras is an engineering student in Istanbul University.\"},\n" +
                "      { \"id\":967824267948773377,\n" +
                "         \"id_str\":\"967824267948773377\",\n" +
                "         \"text\":\" Muhammad Nebras Lived in Damascus and Istanbul.\"}\n" +
                "   ],\n" +
                "   \"search_metadata\":{  \n" +
                "\n" +
                "   }\n" +
                "}"
        return deserializeJson(tempResponse)
    }

    fun deserializeJson(jsonString: String?): List<ListItem>{
        if (jsonString.equals(null))
            Toast.makeText(context, "Oops! Failed to fetch tweets! ", Toast.LENGTH_SHORT).show()
            val gson = GsonBuilder().create()
            val tweetObject = gson.fromJson(jsonString, TweetObject::class.java)
            return mapTweetToListItem(tweetObject)

    }

    fun mapTweetToListItem(tweetObject: TweetObject): List<ListItem> {
        var listOfTweets: MutableList<ListItem> = mutableListOf()
        for (tweet: SingleTweet in tweetObject.statuses) {
            var newItem = ListItem(tweet.text , R.drawable.countryside)
            listOfTweets.add(newItem)
        }
        return listOfTweets
    }
}