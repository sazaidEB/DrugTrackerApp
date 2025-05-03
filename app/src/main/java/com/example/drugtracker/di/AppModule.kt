package com.example.drugtracker.di

import android.content.Context
import com.example.drugtracker.data.AppDatabase
import com.example.drugtracker.data.NewDrugDao
import com.example.drugtracker.network.RxNormApiService
import com.example.drugtracker.repository.DrugRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): RxNormApiService {
        return Retrofit.Builder()
            .baseUrl("https://rxnav.nlm.nih.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RxNormApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDrugDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    @Singleton
    fun provideDrugDao(db: AppDatabase): NewDrugDao {
        return db.drugDao()
    }

    @Provides
    @Singleton
    fun provideDrugRepository(api: RxNormApiService, dao: NewDrugDao): DrugRepository {
        return DrugRepository(api, dao)
    }
}
