package com.example.nebrasvm.tttapp


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import dagger.internal.DaggerCollections
import android.view.inputmethod.InputMethodManager.HIDE_NOT_ALWAYS
import android.content.Context.INPUT_METHOD_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.inputmethod.InputMethodManager
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    //lateinit var listItemViewModel : ListItemViewModel
    //TODO move the following code the proper place (probably to the viewModel
//      val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()
//        .baseUrl("https://api.twitter.com/1.1/search/tweets.json")
//        .addConverterFactory(GsonConverterFactory.create())
//      val retrofit: Retrofit = retrofitBuilder.build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val searchButton: Button = findViewById(R.id.search_button)
        val searchField: EditText = findViewById(R.id.search_edit_text)
        searchButton.setOnClickListener { searchFor(searchField.text.toString()) }
        val twitterApiBaseUrl = "https://api.twitter.com/1.1/search/tweets.json"
        val mockList: MockRepository = MockRepository()
        //val repository : IRepository =  DaggerIRepository
        var recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        // val listItemViewModel = ViewModelProviders.of(this).get(ListItemViewModel::class.java)
        recyclerView.setLayoutManager(LinearLayoutManager(this))
        recyclerView.setHasFixedSize(true)
        var adapter = ListAdapter()
        //adapter.setItems(mockList.getList())
        recyclerView.setAdapter(adapter)

        val jsonFetcher: JsonFetcher = JsonFetcher(twitterApiBaseUrl, this)
        var tweets: List<ListItem> = jsonFetcher.fetchJson()
        adapter.setItems(tweets)


    }

    fun searchFor(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            currentFocus!!.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}
