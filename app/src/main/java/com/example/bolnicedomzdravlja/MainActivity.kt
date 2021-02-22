package com.example.bolnicedomzdravlja


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.bolnicedomzdravlja.activits.HospitalSpisialActivity
import com.example.bolnicedomzdravlja.activits.HospitalPublicActivity
import com.example.bolnicedomzdravlja.activits.PublicHealthActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("ObsoleteSdkInt")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
       
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
        val llRSU = findViewById<LinearLayout>(R.id.llRSU)
        llRSU.setOnClickListener {
            val intent = Intent(this@MainActivity, HospitalPublicActivity::class.java)
            startActivity(intent)
        }
        val llRSK = findViewById<LinearLayout>(R.id.llRSK)
        llRSK.setOnClickListener {
            val intent = Intent(this@MainActivity, HospitalSpisialActivity::class.java)
            startActivity(intent)
        }
        val llPuskes = findViewById<LinearLayout>(R.id.llPuskes)
        llPuskes.setOnClickListener {
            val intent = Intent(this@MainActivity, PublicHealthActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        fun setWindowFlag(activity: Activity, bits: Int, on: Boolean) {
            val win = activity.window
            val winParams = win.attributes
            if (on) {
                winParams.flags = winParams.flags or bits
            } else {
                winParams.flags = winParams.flags and bits.inv()
            }
            win.attributes = winParams
        }
    }
}