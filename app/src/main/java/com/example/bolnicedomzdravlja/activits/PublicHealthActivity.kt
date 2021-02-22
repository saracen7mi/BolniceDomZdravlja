package com.example.bolnicedomzdravlja.activits


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bolnicedomzdravlja.R


import com.example.bolnicedomzdravlja.adapter.PublicHealthAdapter
import com.example.bolnicedomzdravlja.model.ModelPublicHealth
import kotlin.collections.ArrayList


class PublicHealthActivity : AppCompatActivity(), PublicHealthAdapter.onSelectData2 {
    var recyclerView: RecyclerView? = null
    var publicHealthAdapter: PublicHealthAdapter? = null
    var modelPublicHealthList: MutableList<ModelPublicHealth> = ArrayList()

    var progressDialog: ProgressDialog? = null
    var tbPublicHealth: Toolbar? = null
    var tvNotFound: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_public_health)
        tvNotFound = findViewById(R.id.tvNotFound)
        val imgRefresh = findViewById<ImageView>(R.id.imgRefresh)
        tbPublicHealth = findViewById(R.id.tbPublicHealth)
        setSupportActionBar(tbPublicHealth)
        assert(supportActionBar != null)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        progressDialog = ProgressDialog(this)
        progressDialog!!.setTitle("Please wait")
        progressDialog!!.setCancelable(false)
        progressDialog!!.setMessage("Currently displaying data ")
        recyclerView = findViewById(R.id.rvPublicHealth)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this))

        imgRefresh.setOnClickListener {
            val intent = intent
            finish()
            startActivity(intent)
        }


         modelPublicHealthList = ArrayList<ModelPublicHealth>()
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Kantonalna bolnica \"Dr Irfan Ljubijankić\" Bihać",
                "\tDarivalaca krvi 67, Bihać,",
                " +387 37 318-800",
                "",
                "kabinet@kbbihac.ba",
                "",
                 44.809319,
                 15.855553
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Sanski Most General Hospital (Opća bolnica Sanski Most)",
                "Address: Prijedorska 111, Sanski Most 79260",
                "037 689-266",
                "",
                "",
                "",
                44.7682,  16.6507
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Kantonalna bolnica \"Dr Fra Mihovil Sučić\" Livno",
                "Address: Svetog Ive 2, Livno 80101, Bosnia & Herzegovina",
                " +387 34 200-423",
                "",
                "E-mail: bolnica-livno@tel.net.ba",
                "",
                43.826859,  17.002507
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Kantonalna bolnica Travnik",
                "Address: Kalibunar, Travnik, Bosnia & Herzegovina",
                "+387 30 509-445",
                "",
                "bolnica_tr@bih.net.ba",
                "",
                44.2291,  17.6548
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Bugojno",
                "Address: Ambasadora Wagnera 15, Bugojno 70230",
                " +387 30 252-090",
                "+387 30 252 090",
                "opcabolnica.bugojno@gmail.com",
                "",
                44.0531, 17.4483
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Jajce",
                "Address: Kraljice Jelene, Jajce 70101, Bosnia & Herzegovina",
                "+387 30 658-107",
                "Phone: +387 30 658-107",
                "kabinet@kbbihac.ba",
                "",
                44.3453, 17.2716
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica \"Dr Fra Mato Nikolić\" Nova Bila",
                "Address: Dubrave bb, Nova Bila 72276",
                " 030 708-500",
                "+387 30 707 421",
                "uprava@bolnica-novabila.com",
                "",
                0.0

            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Kantonalna bolnica Zenica",
                "Address: Crkvice 67, Zenica 72000",
                " 032 447-000",
                "+387 32 226 576",
                "kbzenica@kbze.ba",
                "",
                44.2101, 17.9261
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Tešanj",
                "Address: Braće Pobrić 17, Tešanj 74260, Bosnia & Herzegovina",
                " +387 32 650-187",
                "",
                "info@bolnicatesanj.ba" ,
                "",
                44.6097, 17.9891
            )
        )

        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica \"Dr Abdulah Nakaš\" Sarajevo",
                "Address: Kranjčevićeva 12, Sarajevo 71000, Bosnia & Herzegovina",
                "+ 387 33 285 100",
                " +387 33 285 370",
                "Email: info@obs.ba ",
                "",
                43.8585 ,43.51307
            )
        )
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Kantonalna bolnica \"Dr Safet Mujić\" Mostar",
                "Address: Maršala Tita 294, Mostar 88000, Bosnia & Herzegovina",
                "+387 36 503-100",
                "+387 36 576 915",
                "protokol@kbmostar.ba",
                " Prim. dr. Zlatko Guzin",
                43.3244, 17.8230))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Konjic",
                "Address: Bolnička, Konjic 88400",
                " 036 712-511",
                "Fax:036 712-519",
                "info@bolnicakonjic.com",
                "Lepara dr. Dženan",
                43.6558, 17.9523))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica \"Dr Mustafa Beganović\" Gračanica",
                "Address: M. Ahmedbegovića 50, Gračanica 75320, Bosnia & Herzegovina",
                "+387 35 702-032",
                "Fax. +387 35 702745",
                "E-Mail: bolnica.beganovic@bih.net.ba",
                " Dr. Jusufa Hodžića",
                0.0))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Kantonalna bolnica Orašje",
                "Address: Treća ul., Orašje 76270, Bosnia & Herzegovina",
                "+387 31 716-300",
                "",
                "kbzenica@kbze.ba",
                "prim.dr.med. Perica Jelečević",
                0.0))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Bolnica \"Sveti apostol Luka\" Doboj",
                "Address: Pop Ljubina, Doboj 74000, Bosnia & Herzegovina",
                " +387 53 241-022",
                "+387 (0)53 242 799",
                "E-mail: bolnicadoboj@teol.net",
                "Mladen Gajić, mr ekonomije",
                44.4353,44.73139))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Gradiška",
                "Address: Dr. Mladena Stojanovića 10, Gradiška 78400, Bosnia & Herzegovina",
                " +387 51 810-600",
                "",
                "info@bolnicagradiska.ba",
                " Rajko Dodik, v.d.",
                45.1454, 17.2476))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Bolnica Kasindo Istočno Sarajevo",
                "Address: Kasindolskog bataljona 113, Kasindo 71213, Bosnia & Herzegovina",
                " +387 57 325-300",
                "+387 (0) 57 316 195",
                "uprava@bolnicasrbija. com",
                "Nebojisa Seslija",
                43.7980, 18.3893))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica \"Sveti vračevi\" Bijeljina",
                "Address: Srpske vojske 53, Bijeljina 76300, Bosnia & Herzegovina",
                "+387 55 415-555",
                "Faks: +387 (0)55 212 529",
                "e-mail: svuprava@telrad.net , uprava@bolnicabijeljina.com",
                "",
                0.0))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Trebinje",
                "Address: Dr. Levija 2, Trebinje 89101, Bosnia & Herzegovina",
                " +387 59 223-755",
                "FAX: +387 (59) 261 102",
                "tb-hospit@teol.net",
                "dr.Nedeljko Lambeta",
                42.7102, 18.3517
                ))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opšta Bolnica Prijedor",
                "Address: 1, Milana Vrhovca, Prijedor, Bosnia & Herzegovina",
                " +387 52 238-411",
                "",
                "",
                "Mirko Sovilj",
                44.9838699487, 16.7316359778
                ))
        modelPublicHealthList.add(
            ModelPublicHealth(
                "Opća bolnica Zdravstveni centar Brčko",
                "Reisa Džemaludina Čauševića 1",
                " 049/234-740",
                "049/216-050",
                "e-mail: brcko.bolnica@gmail.com",
                "Nihad Sibonjic",
                0.0))
        publicHealthAdapter =
            PublicHealthAdapter(this@PublicHealthActivity, modelPublicHealthList, this)
        recyclerView!!.adapter = publicHealthAdapter
    }

    override fun onSelected(modelPublicHealthList: ModelPublicHealth?) {
        val intent = Intent(this@PublicHealthActivity, DetailPublicHealthActivity::class.java)
        intent.putExtra("publicHealthDetail", modelPublicHealthList)
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