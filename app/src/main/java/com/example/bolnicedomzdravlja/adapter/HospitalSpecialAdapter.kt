package com.example.bolnicedomzdravlja.adapter



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bolnicedomzdravlja.R

import com.example.bolnicedomzdravlja.model.ModelHospital



class HospitalSpecialAdapter(
    val mContext: Context, var hospitalList: List<ModelHospital>,
    val onSelectData: onSelectDataa
) : RecyclerView.Adapter<HospitalHolder>() {

    interface onSelectDataa {
        fun onSelected(modelHospital: ModelHospital?)
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): HospitalHolder {
        val view: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.list_data_rsk, viewGroup, false)
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
