package com.babylinechelangat.childimmunization.baby.model

data class Baby(
    val id: String,
    val firstname: String,
    val lastname: String,
    val dateOfBirth: String,
    val age: String,
    val parentName: String,
    val weight: String,
    val height: String,
    val bloodGroup: String,
    val gender: String,
    val noOfVisits: Int,
)