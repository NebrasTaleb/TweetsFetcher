package com.example.nebrasvm.tttapp

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import javax.inject.Inject

class ListItemViewModel  @Inject constructor(application: Application, val repository : MockRepository ) : AndroidViewModel(application) {

    //val repoComponent : IRepository = DaggerIRepository.create()
    //lateinit var repository : IRepository
    private var allItems : List<ListItem> = repository.getList()

    fun getAllItems () : List<ListItem> {
        return allItems
    }
}