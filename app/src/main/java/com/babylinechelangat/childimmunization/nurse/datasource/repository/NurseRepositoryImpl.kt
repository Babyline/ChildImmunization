package com.babylinechelangat.childimmunization.nurse.datasource.repository

import com.babylinechelangat.childimmunization.baby.model.Baby
import com.babylinechelangat.childimmunization.common.Constants
import com.babylinechelangat.childimmunization.common.model.User
import com.babylinechelangat.childimmunization.nurse.domain.repository.NurseRepository
import com.babylinechelangat.childimmunization.nurse.model.Schedule
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class NurseRepositoryImpl: NurseRepository {
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getNurseDetails(nurseId: String): Flow<User> = callbackFlow {
        firebaseFirestore
            .collection(Constants.usersCollection)
            .document(nurseId)
            .addSnapshotListener { value, error ->
                if (error != null) {
                    cancel(cause = error, message = error.message.toString())
                    return@addSnapshotListener
                }
                val nurse = value?.toObject(User::class.java)!!
                trySend(nurse).isSuccess
            }
    }.flowOn(Dispatchers.IO)

    override suspend fun addBabyDetails(baby: Baby) {
        firebaseFirestore
            .collection(Constants.babiesCollection)
            .document()
            .set(baby, SetOptions.merge())
            .await()
    }

    override suspend fun setImmunizationSchedule(schedule: Schedule) {
        firebaseFirestore
            .collection(Constants.immunizationSchedules)
            .document()
            .set(schedule, SetOptions.merge())
            .await()
    }

    override suspend fun sendNotification(schedule: Schedule) {

    }

}