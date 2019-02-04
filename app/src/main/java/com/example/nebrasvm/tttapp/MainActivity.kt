package com.example.nebrasvm.tttapp


import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar



class MainActivity : AppCompatActivity() {
    //lateinit var listItemViewModel : ListItemViewModel
     var  tweetsObject: TweetObject? = TweetObject(listOf())
     lateinit var call : Call<TweetObject>
     lateinit var client : TwitterApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)
        var adapter = ListAdapter()
        val mockList = MockRepository()
        adapter.setItems(mockList.getList())
        recyclerView.setAdapter(adapter)


        client  = ServiceGenerator.createService(TwitterApi::class.java)

        // Execute the call asynchronously. Get a positive or negative callback.



        val searchButton: Button = findViewById(R.id.search_button)
        val searchField: EditText = findViewById(R.id.search_edit_text)
        searchButton.setOnClickListener { searchFor(searchField.text.toString()) }

        val twitterApiBaseUrl = "https://api.twitter.com/1.1/search/tweets.json/"

        // val repository : IRepository =  DaggerIRepository
        // val listItemViewModel = ViewModelProviders.of(this).get(ListItemViewModel::class.java)


       // val jsonFetcher: JsonFetcher = JsonFetcher(twitterApiBaseUrl, this)
        //var tweets: List<ListItem> = jsonFetcher.mapTweetToListItem(tweetsObject)
       // adapter.setItems(tweets)


    }

    fun searchFor(passedString: String) {
        //var generatedTime : String = (System.currentTimeMillis()/1000).toString()
            // var generatedNonce : String =
        //call  = client.getTweets(passedString)
        //call.enqueue(object : Callback<TweetObject> {
         //   override fun onResponse(call: Call<TweetObject>, response: Response<TweetObject>) {
             //   // The network call was a success and we got a response
          //      tweetsObject = response.body()
         //   }
          //  override fun onFailure(call: Call<TweetObject>, t: Throwable) {
              //  // the network call was a failure
           //     Toast.makeText( this@MainActivity , "Network error!" , Toast.LENGTH_SHORT).show()
           // }
      //  })
        Toast.makeText(this, passedString, Toast.LENGTH_SHORT).show()
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}
