package com.example.drugtracker.repository
import com.example.drugtracker.data.DrugEntity
import com.example.drugtracker.data.NewDrugDao
import com.example.drugtracker.model.Drug
import com.example.drugtracker.network.RxNormApiService
import kotlinx.coroutines.flow.Flow

class DrugRepository(
    private val api: RxNormApiService,
    private val dao: NewDrugDao
) {
    suspend fun searchDrugs(name: String): List<Drug> {
        val response = api.searchDrugs(name)
        return response.drugGroup.conceptGroup
            ?.filter { it.tty == "SBD" }
            ?.flatMap { it.conceptProperties ?: emptyList() }
            ?.take(10)
            ?: emptyList()
    }

    suspend fun getAllUserDrugs(): Flow<List<DrugEntity>> = dao.getAllDrugs()

    suspend fun addDrug(drug: DrugEntity): Boolean {
        val count = dao.getDrugCount()
        return if (count < 3) {
            dao.insertDrug(drug)
            true
        } else false
    }

    suspend fun deleteDrug(drug: DrugEntity) {
        dao.deleteDrug(drug)
    }
}
