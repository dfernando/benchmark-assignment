package com.northland.assesment.controllers;

import com.northland.assesment.dto.AmadeusResponse;
import com.northland.assesment.dto.Price;
import com.northland.assesment.services.AmadeusRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class CheapestTripFinderController {

    int numResults = 3;

    private static int INITIAL_OBJECT = 0;

    @Autowired
    AmadeusRestClient amadeusRestClient;

    /**
     * Finds the cheapest <code>numResults</code> flight from Amadeus flight API
     * @param origin - Airport codeof flight origination
     * @param destination - Destination airpirt code.
     * @param departureDate - Date of the departure flight
     * @param key = Authorization Key of Amadeus API
     * @return List of lowest price objects
     * @throws IOException - API failed -
     */


    @RequestMapping(value = "/findCheapest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Price> getCheapest(@RequestParam(name = "origin") String origin,
                              @RequestParam(name = "destination") String destination,
                              @RequestParam(name = "departureDate") String departureDate,
                              @RequestParam(name = "key") String key) throws IOException {

        amadeusRestClient.setAuthorizatioKey(key);
        AmadeusResponse amadeusResponse = amadeusRestClient.getFlightDetails(origin, destination, departureDate, numResults);

        List<Price> subList = getCheapest(amadeusResponse, numResults>5?5:numResults);
        return subList;
    }


    /**
     * Finds the lowest prices in the list
     * @param payload - Payload from the web servide
     * @param count - Number of results to return
     * @return - List of price objects.
     */

    private List<Price> getCheapest(AmadeusResponse payload, int count){
        /*
            As per the requirements, I've only mapped the <code>Price</code> object to the list. If the flight details is also wanted
            it's possible to map the <code>FlightSegment</code> object to a HashMap and return the flight segment info along with the price.
         */
        List<Price> prices = payload.getData().stream().map(v->v.getOfferItems().get(INITIAL_OBJECT).getPrice()).collect(Collectors.toList());
        Collections.sort(prices, new Comparator<Price>() {
            @Override
            public int compare(Price p1, Price p2) {
                return (int)(p1.getTotal() - p2.getTotal());
            }
        });

        return prices.subList(0,count);
    }




}



