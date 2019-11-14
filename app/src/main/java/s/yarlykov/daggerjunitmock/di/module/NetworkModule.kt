package s.yarlykov.daggerjunitmock.di.module

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import s.yarlykov.daggerjunitmock.data.GitApi
import s.yarlykov.daggerjunitmock.data.GitHelper
import java.util.concurrent.TimeUnit

import javax.inject.Singleton

@Module
open class NetworkModule(private val baseUrl: String) {

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache =
        Cache(application.cacheDir, (10 * 1024).toLong())

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder().apply {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        }.create()

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: Cache): OkHttpClient =
        OkHttpClient()
            .newBuilder()
            .cache(cache)
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    open fun provideRetrofit(gson: Gson, factory: CallAdapter.Factory, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(factory)
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideGitApi(retrofit: Retrofit): GitApi =
        retrofit.create(GitApi::class.java)

    @Provides
    @Singleton
    fun provideGitHelper(gitApi: GitApi) : GitHelper = GitHelper(gitApi)
}
