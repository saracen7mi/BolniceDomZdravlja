package com.example.bolnicedomzdravlja.activits



import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.example.bolnicedomzdravlja.R

import com.example.bolnicedomzdravlja.adapter.HospitalSpecialAdapter
import com.example.bolnicedomzdravlja.model.ModelHospital
import com.example.bolnicedomzdravlja.model.ModelPublicHealth
import org.json.JSONException
import org.json.JSONObject
import java.util.*


class HospitalSpisialActivity : AppCompatActivity(), HospitalSpecialAdapter.onSelectDataa {
    var recyclerView: RecyclerView? = null
    var hospitalAdapter: HospitalSpecialAdapter? = null
    var modelHospitalList: MutableList<ModelHospital> = ArrayList()
    var progressDialog: ProgressDialog? = null
    var tbRSU: Toolbar? = null
    var tvNotFound: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)
        tvNotFound = findViewById(R.id.tvNotFound)
        val imgRefresh = findViewById<ImageView>(R.id.imgRefresh)
        tbRSU = findViewById(R.id.tbRS)
        setSupportActionBar(tbRSU)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("Please wait")
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Currently displaying data")
        recyclerView = findViewById(R.id.rvRS)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))

        imgRefresh.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
        }

        modelHospitalList = ArrayList<ModelHospital>()
        modelHospitalList.add(
            ModelHospital(
                "Bolnica Jagomir",
                "Psihijatrijska bolnica",
                "71000 Sarajevo",
                "Nahorevska 248, Sarajevo",
                "++ 387 33 561-500",
                "info@jagomir.ba",
                "https://www.jagomir.ba",
                "++ 387 33 561-532",
                43.887377, 18.417618))

        modelHospitalList.add(
            ModelHospital(
                "JZU \"Zavod za forenzičku psihijatriju\" Sokolac",
                "Psihijatrijska bolnica",
                "71350 Sokolac",
                " Adresa :  Podromanija bb, Sokolac, Republika Srpska, 71350 BiH",
                " +387 57 400-040",
                "e-mail:  forenpsi@teol.net",
                "https://www.zzfps.ba/",
                "  Faks:  057-444-858",
                43.5610, 18.4752))

        modelHospitalList.add(
            ModelHospital(
                "JZU  Bolnica za hroničnu psihijatriju Modriča",
                "Psihijatrijska bolnica",
                "74480 Modrica",
                "Address: Gornjani 99, Modriča 74480",
                "053 818-858",
                "kontakt@bolnicamodrica.net",
                "https://www.bolnicamodrica.net/",
                "053 818 389",
                44.5724, 18.1804))

        modelHospitalList.add(
            ModelHospital(
                "Medical Institute Bayer",
                "Specijalna bolnica \"Centar za srce BH\" Tuzla",
                "75000 Tuzla",
                "Alekse Šantića 8",
                "+ 387 35 309 100",
                "info@mib.institute",
                "https://mib.institute/kontakt/",
                "", 0.0))

        modelHospitalList.add(
            ModelHospital(
                "Javna ustanova Bolnica za plućne bolesti i TBC Travnik ",
                "Bolnica za plućne bolesti i tuberkulozu Travnik",
                "72270 Travnik",
                "Bašbunar bb.",
                " +387 30 511-553",
                "bolnicatbc@global.net.ba",
                "https://jubpbt.com/",
                "Fax: +387 30 511 556",
                44.2297, 17.6583))

        hospitalAdapter =
            HospitalSpecialAdapter(this@HospitalSpisialActivity, modelHospitalList, this)
        recyclerView!!.adapter = hospitalAdapter

    }
    override fun onSelected(modelHospital: ModelHospital?) {
        val intnt = Intent(this@HospitalSpisialActivity, DetailHospitalActivity::class.java)
        intnt.putExtra("rsDetail", modelHospital)
        startActivity(intnt)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}