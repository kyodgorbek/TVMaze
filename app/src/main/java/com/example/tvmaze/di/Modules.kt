package com.example.tvmaze.di



import com.example.tvmaze.api.ApiInterface
import com.example.tvmaze.ui.TvViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.tvmaze.utils.Constants

val viewModels = module {
    viewModel { TvViewModel(get())
    }
}




val apiModule = module {

        val logInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(logInterceptor)
                .build()

        val retrofit =
            Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

        retrofit.create(ApiInterface::class.java)
    }
