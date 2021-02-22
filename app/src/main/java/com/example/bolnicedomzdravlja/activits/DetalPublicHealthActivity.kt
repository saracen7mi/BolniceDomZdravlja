package com.example.bolnicedomzdravlja.activits


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bolnicedomzdravlja.R

import com.example.bolnicedomzdravlja.model.ModelPublicHealth
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class DetailPublicHealthActivity : AppCompatActivity(), OnMapReadyCallback {
    private var googleMaps: GoogleMap? = null
    private var latitude = 0.0
    private var longitude = 0.0
    var txtNameHospital: TextView? = null
    var txtNameDirektor: TextView? = null
    var txtNoTlp: TextView? = null
    var txtEmail: TextView? = null
    var txtFax: TextView? = null
    var NameHospital: String? = null
    var NameDirektor: String? = null
    var NoTlp: String? = null
    var Email: String? = null
    var Alamat: String? = null
    var Fax: String? = null
    var modelPublicHealth: ModelPublicHealth? = null
    var btnCall: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_public_health)
        val tbDetailPuskesmas = findViewById<Toolbar>(R.id.tbDetailHospital)
        setSupportActionBar(tbDetailPuskesmas)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)



        modelPublicHealth = intent.getSerializableExtra("publicHealthDetail") as ModelPublicHealth?
        if (modelPublicHealth != null) {
            NameHospital = modelPublicHealth!!.nameHospital
            NameDirektor = modelPublicHealth!!.direktorHospital
            NoTlp = modelPublicHealth!!.telepon
            Email = modelPublicHealth!!.email
            Fax = modelPublicHealth!!.faximile
            latitude = modelPublicHealth!!.latitude
            longitude = modelPublicHealth!!.longitude
            txtNameHospital = findViewById(R.id.txtNameHospital)
            txtNameDirektor = findViewById(R.id.txtNameDirektor)
            txtNoTlp = findViewById(R.id.txtNoTlp)
            txtEmail = findViewById(R.id.txtEmail)
            txtFax = findViewById(R.id.txtFax)
            btnCall = findViewById(R.id.btnCall)
            txtNameHospital!!.setText(NameHospital)
            txtNameDirektor!!.setText(NameDirektor)
            txtNoTlp!!.setText(" $NoTlp")
            txtFax!!.setText(" $Fax")
            txtEmail!!.setText(Email)
            btnCall!!.setOnClickListener(View.OnClickListener {
                val intent: Intent
                intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $NoTlp"))
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