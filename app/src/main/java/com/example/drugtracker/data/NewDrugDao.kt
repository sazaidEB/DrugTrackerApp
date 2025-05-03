package com.example.drugtracker.data


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NewDrugDao {

    @Query("SELECT * FROM user_drugs")
    fun getAllDrugs(): Flow<List<DrugEntity>>

    @Insert
    suspend fun insertDrug(drug: DrugEntity)

    @Delete
    suspend fun deleteDrug(drug: DrugEntity)
    @Query("SELECT COUNT(*) FROM user_drugs")
    suspend fun getDrugCount(): Int
}
