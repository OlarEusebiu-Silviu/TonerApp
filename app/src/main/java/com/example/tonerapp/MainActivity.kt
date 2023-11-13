package com.example.tonerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private val firebaseTonerManager = FirebaseTonerManager()
    private lateinit var tonereAdapter: TonerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurare RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        tonereAdapter = TonerAdapter()
        recyclerView.adapter = tonereAdapter

        // Adăugare toner în Firebase (doar în scop de demo)
        firebaseTonerManager.adaugaToner(Toner("Model123", "Negru", 10))

        // Citirea și afișarea tonerelor din Firebase
        firebaseTonerManager.adaugaListenerTonere(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val tonere = mutableListOf<Toner>()
                for (tonerSnapshot in snapshot.children) {
                    val toner = tonerSnapshot.getValue(Toner::class.java)
                    toner?.let { tonere.add(it) }
                }
                tonereAdapter.setTonere(tonere)
            }

            override fun onCancelled(error: DatabaseError) {
                // Tratare erori
            }
        })
    }
}
