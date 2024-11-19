package com.konstantion.lab5

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.konstantion.lab5.adapter.RecyclerViewAdapter
import com.konstantion.lab5.data.AppDatabase
import com.konstantion.lab5.model.DataModel
import com.konstantion.lab5.repository.DataRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.dataList.observe(this) { data ->
            adapter = RecyclerViewAdapter(data)
            recyclerView.adapter = adapter
        }
    }
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DataRepository
    val dataList: LiveData<List<DataModel>>

    init {
        val dataDao = AppDatabase.getDatabase(application).dataDao()
        repository = DataRepository(dataDao)
        dataList = repository.allData

        viewModelScope.launch {
            if (dataList.value.isNullOrEmpty()) {
                repository.insert(generateTestData())
            }
        }
    }

    private fun generateTestData(): List<DataModel> {
        val items = mutableListOf<DataModel>()
        for (i in 1..20) {
            items.add(
                DataModel(
                    id = i,
                    title = "Item $i",
                    description = "Description of Item $i"
                )
            )
        }
        return items
    }
}