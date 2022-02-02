package com.babylinechelangat.childimmunization.nurse.domain.repository

import com.babylinechelangat.childimmunization.baby.model.Baby
import com.babylinechelangat.childimmunization.common.model.User
import com.babylinechelangat.childimmunization.nurse.model.Schedule
import kotlinx.coroutines.flow.Flow

interface NurseRepository {

    suspend fun getNurseDetails(nurseId: String): Flow<User>

    suspend fun addBabyDetails(baby: Baby)

    suspend fun setImmunizationSchedule(schedule: Schedule)

    suspend fun sendNotification(schedule: Schedule)
}
