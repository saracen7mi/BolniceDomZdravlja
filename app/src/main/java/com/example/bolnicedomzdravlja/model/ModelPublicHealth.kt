package com.example.bolnicedomzdravlja.model

import java.io.Serializable



data class ModelPublicHealth(
    var nameHospital: String? = null,
    var location: String? = null,
    var telepon: String? = null,
    var faximile: String? = null,
    var email: String? = null,
    var direktorHospital: String? = null,
    var latitude: Double = 0.0,
    var longitude: Double = 0.0
) : Serializable {
}