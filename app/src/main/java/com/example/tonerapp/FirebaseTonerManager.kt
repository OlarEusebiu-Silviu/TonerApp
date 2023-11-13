package com.example.tonerapp
import com.google.firebase.database.*

class FirebaseTonerManager {

    private val database = FirebaseDatabase.getInstance()
    private val tonerRef = database.getReference("tonere")

    fun adaugaToner(toner: Toner) {
        val tonerId = tonerRef.push().key
        tonerId?.let {
            tonerRef.child(it).setValue(toner)
        }
    }

    fun citesteTonere(listener: ValueEventListener) {
        tonerRef.addListenerForSingleValueEvent(listener)




            fun actualizeazaToner(tonerId: String, toner: Toner) {
                tonerRef.child(tonerId).setValue(toner)
            }

            fun stergeToner(tonerId: String) {
                tonerRef.child(tonerId).removeValue()
            }
        }

    fun adaugaListenerTonere(valueEventListener: ValueEventListener) {

    }


}



