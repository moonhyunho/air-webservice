package com.air.webservice.interfaces.request

import com.air.webservice.support.enums.Cabin

data class SearchRequest(
    val adult: Int,
    val child: Int = 0,
    val infant: Int = 0,
    val cabins: List<Cabin>,
    val originDestinations: List<OriginDestination>
)

data class OriginDestination(
    val origin: String,
    val destination: String,
    val departureDate: String
)