package com.example.nebrasvm.tttapp

import javax.inject.Inject


class MockRepository @Inject constructor() : IRepository {

    private val mockListOfItems: List<ListItem> =
        listOf(
            ListItem("Damascus is the oldest populated capital in the world.", R.drawable.countryside)
            , ListItem("Istanbul is a beautiful city.", R.drawable.countryside)
            , ListItem("Dubai is located in UAE.", R.mipmap.ic_launcher)
            , ListItem("Istanbul is located in the north west of Turkey.", R.mipmap.ic_launcher)
            , ListItem("Istanbul is located in two continents.", R.mipmap.ic_launcher)
            , ListItem("Damascus is the capital of Syria.", R.drawable.countryside)
            , ListItem("Dubai has the tallest structure and building in the world.", R.mipmap.ic_launcher)
            , ListItem("Damascus is a beautiful city located in Syria.", R.mipmap.ic_launcher)
            , ListItem("Muhammad Nebras Taleb was living in Damascus.", R.drawable.countryside)
            , ListItem("Muhammad Nebras Taleb is living in Istanbul right now.", R.mipmap.ic_launcher)
        )

    fun getList(): List<ListItem> {
        return mockListOfItems
    }
}