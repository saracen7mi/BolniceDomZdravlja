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

import com.example.bolnicedomzdravlja.adapter.HospitalPublicAdapter
import com.example.bolnicedomzdravlja.model.ModelHospital
import org.json.JSONException
import org.json.JSONObject
import java.util.*


class HospitalPublicActivity : AppCompatActivity(), HospitalPublicAdapter.onSelectData1 {
    var recyclerView: RecyclerView? = null
    var hospitalAdapter: HospitalPublicAdapter? = null
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
    "Univerzitetski klinički centar Sarajevo",
    "KLINIČKI CENTAR",
    "71000 Sarajevo",
    "Bolnička 25, Sarajevo",
    "+387 33 298 487",
        "Email: info@kcus.ba",
    "https://www.ukcs.ba",
    "+387 33 213 308",
        43.869171, 18.415607 ))

    modelHospitalList.add(
    ModelHospital(
    "Univerzitetski klinički centar Republike Srpske",
    "KLINICKI CENTAR",
    "78000",
    " Macvanska 17",
    "051 342 100",
    "administarcija@kc-bl.com",
    "https://www.kc-bl.com/",
    " 051 310 530 ",
        44.784167, 17.178335 ))

    modelHospitalList.add(
    ModelHospital(
    "Univerzitetski klinički centar Tuzla",
    "KLINICKI CENTAR",
    "75000 Tuzla",
    "Adresa: Trnovac bb , 75 000 Tuzla, Bosna i Hercegovina",
    "00387 35 303 300",
    "mail: info@ukctuzla.ba",
    "https://www.ukctuzla.ba",
    "00387 35 250 474",
        44.536551,18.692438  ))

    modelHospitalList.add(
    ModelHospital(
    "Univerzitetska klinička bolnica Mostar",
    "KLINICKI CENTAR",
    "88000 Mostar",
    "Kralja Tvrtka bb, Mostar, Bosna i Hercegovina",
    " +387 36 336-000",
    "E-mail: ravnateljstvo@skbm.ba",
    "https://www.skbm.ba/",
    "",
        43.345046, 17.789829         ))

    modelHospitalList.add(
    ModelHospital(
    " Univerzitetska bolnica Foča",
    "KLINICKI CENTAR",
    "73300",
    " Studentska bb",
    "+387 58 222-500",
    " bolnicaf@bolnicafoca.com",
    "https://www.bolnicafoca.com/informacije/kontakt/ ",
    "+387-58/210 -417",
    44.2297, 17.6583))



    hospitalAdapter = HospitalPublicAdapter(this@HospitalPublicActivity , modelHospitalList, this)
    recyclerView!!.adapter = hospitalAdapter
}

    override fun onSelected(modelHospital: ModelHospital?) {
        val intent = Intent(this@HospitalPublicActivity, DetailHospitalActivity::class.java)
        intent.putExtra("rsDetail", modelHospital)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}