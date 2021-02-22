package com.example.bolnicedomzdravlja.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bolnicedomzdravlja.R

import com.example.bolnicedomzdravlja.model.ModelHospital


class HospitalPublicAdapter(
    private val mContext: Context, var hospitalList: List<ModelHospital>,
    private var onSelectData: onSelectData1
) : RecyclerView.Adapter<HospitalHolder>() {

    interface onSelectData1 {
        fun onSelected(modelHospital: ModelHospital?)
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HospitalHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.list_data_rsu, viewGroup, false)
        return HospitalHolder(view)
    }

    override fun onBindViewHolder(viewHolder: HospitalHolder, position: Int) {
        val data = hospitalList[position]
        viewHolder.tv_nama_rs.text = "RS" + " " + data.namaRs
        viewHolder.tv_location.text = data.location
        viewHolder.cvRs.setOnClickListener { onSelectData.onSelected(data) }
    }

    override fun getItemCount(): Int {
        return hospitalList.size
    }
}
