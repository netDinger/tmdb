package com.dinger.tmdbmovie.di

import com.dinger.tmdbmovie.BuildConfig
import com.dinger.tmdbmovie.data.remoteDataSource.CustomInterceptor
import com.dinger.tmdbmovie.data.service.MovieDetailService
import com.dinger.tmdbmovie.data.service.PopularMovieService
import com.dinger.tmdbmovie.data.service.UpcomingMovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dns
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .dns(Dns.SYSTEM)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(CustomInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUpcomingMoviesService(retrofit: Retrofit): UpcomingMovieService {
        return retrofit.create(UpcomingMovieService::class.java)
    }

    @Provides
    @Singleton
    fun providePopularMoviesService(retrofit: Retrofit): PopularMovieService {
        return retrofit.create(PopularMovieService::class.java)
    }



    @Provides
    @Singleton
    fun provideMovieDetailService(retrofit: Retrofit): MovieDetailService {
        return retrofit.create(MovieDetailService::class.java)
    }



}