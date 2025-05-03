package com.example.drugtracker.network
import com.example.drugtracker.model.DrugResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RxNormApiService {
    @GET("REST/drugs.json")
    suspend fun searchDrugs(
        @Query("name") name: String,
        @Query("expand") expand: String = "psn"
    ): DrugResponse
}
