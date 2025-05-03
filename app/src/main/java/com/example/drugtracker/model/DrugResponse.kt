package com.example.drugtracker.model
data class DrugResponse(
    val drugGroup: DrugGroup
)

data class DrugGroup(
    val conceptGroup: List<ConceptGroup>?
)

data class ConceptGroup(
    val tty: String?,
    val conceptProperties: List<Drug>?
)

data class Drug(
    val rxcui: String,
    val name: String
)
