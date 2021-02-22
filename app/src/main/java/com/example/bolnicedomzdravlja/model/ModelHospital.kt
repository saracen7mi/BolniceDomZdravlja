package com.example.bolnicedomzdravlja.model

import java.io.Serializable


data class ModelHospital(
    var namaRs: String? = null,
    var jenisRs: String? = null,
    var kodePos: String? = null,
    var location: String? = null,
    var telepon: String? = null,
    var email: String? = null,
    var website: String? = null,
    var faximile: String? = null,
    var latitude: Double = 0.0,
    var longitude: Double = 0.0): Serializable {
}