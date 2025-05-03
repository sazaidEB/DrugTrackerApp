package com.example.drugtracker.viewmodel



import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drugtracker.data.DrugEntity
import com.example.drugtracker.model.Drug
import com.example.drugtracker.repository.DrugRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class DrugViewModel @Inject constructor(
    private val repository: DrugRepository
) : ViewModel() {

    private val _searchResults = MutableStateFlow<List<Drug>>(emptyList())
    val searchResults: StateFlow<List<Drug>> = _searchResults

    private val _userDrugs = MutableStateFlow<List<DrugEntity>>(emptyList())
    val userDrugs: StateFlow<List<DrugEntity>> = _userDrugs

    private val _drugDetail = MutableStateFlow("Loading...")
    val drugDetail: StateFlow<String> = _drugDetail

    fun searchDrugs(name: String) {
        viewModelScope.launch {
            _searchResults.value = repository.searchDrugs(name)
        }
    }

    fun getUserDrugs() {
        viewModelScope.launch {
            repository.getAllUserDrugs().collect { drugs ->
                _userDrugs.value = drugs
            }
        }
    }


    fun addDrug(drug: DrugEntity, onLimitExceeded: () -> Unit) {
        viewModelScope.launch {
            val added = repository.addDrug(drug)
            if (!added) onLimitExceeded() else getUserDrugs()
        }
    }

    fun deleteDrug(drug: DrugEntity) {
        viewModelScope.launch {
            repository.deleteDrug(drug)
            getUserDrugs()
        }
    }


    fun fetchDrugDetail(rxcui: String) {
        viewModelScope.launch {
            try {
                val url = "https://rxnav.nlm.nih.gov/REST/rxcui/$rxcui/allProperties.json?prop=all"
                val response = java.net.URL(url).readText()
                _drugDetail.value = response.take(500)
                Log.d("sazaid111","${response.toString()}")
            } catch (e: Exception) {
                _drugDetail.value = "Failed to load details."
            }
        }
    }
}
