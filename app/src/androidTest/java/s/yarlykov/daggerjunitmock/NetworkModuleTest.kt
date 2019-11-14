package s.yarlykov.daggerjunitmock

import com.google.gson.Gson
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import s.yarlykov.daggerjunitmock.di.module.NetworkModule
import javax.inject.Singleton

class NetworkModuleTest(private val baseUrl: String) : NetworkModule(baseUrl) {

    @Provides
    @Singleton
    override fun provideRetrofit(
        gson: Gson,
        factory: CallAdapter.Factory,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(factory)
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
}