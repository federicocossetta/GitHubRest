package com.fcossetta.githubrest.di

import com.fcossetta.githubrest.MyApplication
import com.fcossetta.githubrest.api.GitHubService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton


@Module
class ApiModule   {

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient? {
        val client = OkHttpClient.Builder()
        return client.build()
    }


    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient?,baseUrl : String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): GitHubService {
        return retrofit.create(GitHubService::class.java)
    }

}