package com.example.bolnicedomzdravlja.activits


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bolnicedomzdravlja.R

import com.example.bolnicedomzdravlja.model.ModelHospital
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetailHospitalActivity : AppCompatActivity(), OnMapReadyCallback {
    private var googleMaps: GoogleMap? = null
    private var latitude = 0.0
    private var longitude = 0.0
    var txtNameRS: TextView? = null
    var txtFax: TextView? = null
    var txtJenisRs: TextView? = null
    var txtKodePos: TextView? = null
    var txtNoTlp: TextView? = null
    var txtEmail: TextView? = null
    var txtWebsite: TextView? = null
    var NameRS: String? = null
    var JenisRs: String? = null
    var KodePos: String? = null
    var NoTlp: String? = null
    var Email: String? = null
    var Website: String? = null
    var Alamat: String? = null
    var Fax: String? = null
    var modelHospitalList: ModelHospital? = null
    var btnCall: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hospital)
        val tbDetailRS = findViewById<Toolbar>(R.id.tbDetailRS)
        setSupportActionBar(tbDetailRS)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        modelHospitalList = intent.getSerializableExtra("rsDetail") as ModelHospital?
        if (modelHospitalList != null) {
            NameRS = modelHospitalList!!.namaRs
            JenisRs = modelHospitalList!!.jenisRs
            KodePos = modelHospitalList!!.kodePos
            NoTlp = modelHospitalList!!.telepon
            Email = modelHospitalList!!.email
            Fax = modelHospitalList!!.faximile
            Website = modelHospitalList!!.website
            latitude = modelHospitalList!!.latitude
            longitude = modelHospitalList!!.longitude
            txtNameRS = findViewById(R.id.txtNameRS)
            txtJenisRs = findViewById(R.id.txtJenisRs)
            txtKodePos = findViewById(R.id.txtKodePos)
            txtNoTlp = findViewById(R.id.txtNoTlp)
            txtEmail = findViewById(R.id.txtEmail)
            txtFax = findViewById(R.id.txtFax)
            txtWebsite = findViewById(R.id.txtWebsite)
            btnCall = findViewById(R.id.btnCall)
            txtNameRS!!.setText("RS $NameRS")
            txtJenisRs!!.setText(JenisRs)
            txtKodePos!!.setText(KodePos)
            txtNoTlp!!.setText(" $NoTlp")
            txtFax!!.setText(" $Fax")
            txtEmail!!.setText(Email)
            if (Website == null) {
                txtWebsite!!.setText("-")
            } else {
                val spannableString = SpannableString("$Website")
                spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, 0)
                txtWebsite!!.setText(spannableString)
                txtWebsite!!.setOnClickListener(View.OnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("$Website"))
                    startActivity(intent)
                })

            }
            btnCall!!.setOnClickListener(View.OnClickListener {
                val intent: Intent
                intent = Intent(Intent.ACTION_DIAL, Uri.parse(" $NoTlp"))
                startActivity(intent)
            })
            txtEmail!!.setOnClickListener {
                intent = Intent(Intent.ACTION_SEND, Uri.parse("email: $Email"))
                intent.type="text/plain"
                startActivity(Intent.createChooser(intent,"Choase Email Client.."))
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMaps = googleMap
        val latLng = LatLng(latitude, longitude)
        googleMaps!!.addMarker(MarkerOptions().position(latLng).title(Alamat))
        googleMaps!!.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMaps!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16f))
        googleMaps!!.uiSettings.setAllGesturesEnabled(true)
        googleMaps!!.uiSettings.isZoomGesturesEnabled = true
        googleMaps!!.isTrafficEnabled = true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}