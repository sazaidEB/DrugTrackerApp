package com.example.drugtracker.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_drugs")
data class DrugEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val rxcui: String,
    val name: String
)

