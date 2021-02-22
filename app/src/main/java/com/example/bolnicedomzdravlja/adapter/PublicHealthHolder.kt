package com.example.bolnicedomzdravlja.adapter



import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bolnicedomzdravlja.R


class PublicHealthHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tv_nama_publicHealth: TextView
    var tv_location: TextView
    var cvPublicHealth: CardView

    init {
        cvPublicHealth = view.findViewById(R.id.cvPuskesmas)
        tv_nama_publicHealth = view.findViewById(R.id.tv_nama_publicHealthAd)
        tv_location = view.findViewById(R.id.tv_location)
    }
}