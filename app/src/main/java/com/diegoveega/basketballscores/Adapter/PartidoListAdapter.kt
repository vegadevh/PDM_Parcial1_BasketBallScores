package com.diegoveega.basketballscores.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.diegoveega.basketballscores.R
//import com.diegoveega.basketballscores.Room.Entities.Equipo
import com.diegoveega.basketballscores.Room.Entities.Partido

class PartidoListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<PartidoListAdapter.PartidoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var partidos = emptyList<Partido>()
    private var listener: View.OnClickListener ?= null
    private var listenerBoton: View.OnClickListener ?= null

    inner class PartidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val partidoItemView: TextView = itemView.findViewById(R.id.textView)
//Recyclerviewitem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PartidoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        itemView.setOnClickListener(listener)

        return PartidoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PartidoViewHolder, position: Int) {
        val current = partidos[position]
        holder.partidoItemView.text = current.EquipoNameA
        holder.partidoItemView.text = current.EquipoNameB
        holder.partidoItemView.text = current.Id_Partido.toString()
    }

    internal fun setPartidos(partidos: List<Partido>) {
        this.partidos = partidos
        notifyDataSetChanged()
    }

    override fun getItemCount() = partidos.size

    fun setOnClickListener(listener: View.OnClickListener){
        this.listener = listener

    }
}