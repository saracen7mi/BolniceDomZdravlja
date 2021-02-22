package com.example.bolnicedomzdravlja.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bolnicedomzdravlja.R

import com.example.bolnicedomzdravlja.model.ModelPublicHealth


class PublicHealthAdapter(
    private val mContext: Context, var publicHealthList: List<ModelPublicHealth>,
    private val onSelectData: onSelectData2
) : RecyclerView.Adapter<PublicHealthHolder>() {
    interface onSelectData2 {
        fun onSelected(modelRumahSakit: ModelPublicHealth?)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PublicHealthHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_data_public_health, viewGroup, false)
        return PublicHealthHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PublicHealthHolder, position: Int) {
        val data = publicHealthList[position]
        viewHolder.tv_nama_publicHealth.text = data.nameHospital
        viewHolder.tv_location.text = data.location
        viewHolder.cvPublicHealth.setOnClickListener { onSelectData.onSelected(data) }
    }

    override fun getItemCount(): Int {
        return publicHealthList.size
    }
}
