package com.example.tonerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TonerAdapter : RecyclerView.Adapter<TonerAdapter.TonerViewHolder>() {

    private var tonere: List<Toner> = emptyList()

    fun setTonere(tonere: List<Toner>) {
        this.tonere = tonere
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TonerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.toner_item, parent, false)
        return TonerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TonerViewHolder, position: Int) {
        val toner = tonere[position]
        holder.bind(toner)
    }

    override fun getItemCount(): Int {
        return tonere.size
    }

    class TonerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val modelTextView: TextView = itemView.findViewById(R.id.modelTextView)
        private val culoareTextView: TextView = itemView.findViewById(R.id.culoareTextView)
        private val cantitateTextView: TextView = itemView.findViewById(R.id.cantitateTextView)

        fun bind(toner: Toner) {
            modelTextView.text = "Model: ${toner.model}"
            culoareTextView.text = "Culoare: ${toner.culoare}"
            cantitateTextView.text = "Cantitate: ${toner.cantitate}"
        }
    }
}
