package com.example.tvmaze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tvmaze.ui.TvViewModel
import com.example.tvmaze.utils.DebounceEditText
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlinx.android.synthetic.main.activity_main.*
import com.example.tvmaze.utils.DebounceEditText.*

class MainActivity : AppCompatActivity() {

    lateinit var debounceEditText: DebounceEditText


    private val viewModel by viewModel<TvViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        viewModel.getShows()

        debounceEditText.setOnDebounceTextWatcher(lifecycle) { input ->
            Log.d("DebounceEditText", input)


        }
    }
}