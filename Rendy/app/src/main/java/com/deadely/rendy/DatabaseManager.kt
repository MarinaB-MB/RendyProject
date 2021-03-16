package com.deadely.rendy

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

object DatabaseManager {
    private val database = Firebase.database
    private val reference = database.reference

    fun getDatabaseValue(
        path: String,
        onComplete: (DataSnapshot) -> Unit,
        onError: (DatabaseError) -> Unit
    ) {
        val reference = database.getReference(path)
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                onComplete(snapshot)
            }

            override fun onCancelled(error: DatabaseError) {
                onError(error)
            }
        })
    }

    fun setDatabaseValue(
        path: String,
        value: Any
    ) {
        val reference = database.getReference(path)
        reference.setValue(value)
    }
}
