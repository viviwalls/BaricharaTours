package com.christianrruiz.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class PoiAdapter(
    private val puntosList: ArrayList<SitiosItem>
) : RecyclerView.Adapter<PoiAdapter.PoiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi = puntosList[position]
        holder.bind(poi)
    }

    override fun getItemCount(): Int = puntosList.size
    class PoiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var nombreTextView: TextView = itemView.findViewById(R.id.nombre_card_text_view)
        private var descripcionTextView: TextView =
            itemView.findViewById(R.id.descripcion_card_text_view)
        private var calificacionTextView: TextView =
            itemView.findViewById(R.id.calificacion_card_text_view)
        private var imagenImageView: ImageView = itemView.findViewById(R.id.imagen_card_image_view)
        fun bind(sitios: SitiosItem) {
            nombreTextView.text = sitios.nombre
            descripcionTextView.text = sitios.descripcion
            calificacionTextView.text = sitios.calificacion
            Picasso.get().load(sitios.urlFoto).into(imagenImageView)
        }
    }
}