package c.m.popcorn.movie.di

import c.m.popcorn.movie.data.remote.MoviePopCornApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providePopCornApi(okHttpClient: OkHttpClient, baseUrlApi: String): MoviePopCornApi {
        return Retrofit.Builder()
            .baseUrl(baseUrlApi)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MoviePopCornApi::class.java)
    }
}