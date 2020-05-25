package com.air.webservice.interfaces.controller

import com.air.webservice.interfaces.request.SearchRequest
import com.air.webservice.interfaces.response.FareItineraryView
import com.air.webservice.interfaces.response.PassengerFareView
import com.air.webservice.interfaces.response.ScheduleView
import com.air.webservice.interfaces.response.SearchView
import com.air.webservice.support.enums.Cabin
import com.air.webservice.support.enums.PassengerType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/search")
class SearchController {

    @PostMapping
    fun search(@RequestBody request: SearchRequest): ResponseEntity<SearchView> {
        return ResponseEntity.ok(
            SearchView(
                fareItineraries = listOf(
                    FareItineraryView(
                        schedules = listOf(
                            ScheduleView(
                                departureLocation = "ICN",
                                departureAt = "2020-10-15T10:00:00",
                                arrivalLocation = "BKK",
                                arrivalAt = "2020-10-15T15:30:00",
                                flightNumber = "1234",
                                cabin = Cabin.ECONOMY,
                                bookingClass = "Y",
                                seatAvailability = 9
                            ),
                            ScheduleView(
                                departureLocation = "BKK",
                                departureAt = "2020-10-20T11:00:00",
                                arrivalLocation = "ICN",
                                arrivalAt = "2020-10-20T17:30:00",
                                flightNumber = "5678",
                                cabin = Cabin.ECONOMY,
                                bookingClass = "Y",
                                seatAvailability = 9
                            )
                        ),
                        validatingCarrier = "KE",
                        passengerFares = listOf(
                            PassengerFareView(
                                type = PassengerType.ADULT,
                                airPrice = 250000,
                                tax = 50000
                            )
                        )
                    )
                )
            )

        )
    }

}