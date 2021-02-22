package com.example.bolnicedomzdravlja.adapter


import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bolnicedomzdravlja.R


class HospitalHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tv_nama_rs: TextView
    var tv_location: TextView
    var cvRs: CardView

    init {
        cvRs = view.findViewById(R.id.cvRs)
        tv_nama_rs = view.findViewById(R.id.tv_nama_rs)
        tv_location = view.findViewById(R.id.tv_location)
    }
}