package com.benchmark.assesment.controllers;

import com.benchmark.assesment.dto.AmadeusResponse;

import java.util.List;

@Controller

public class CheapestTripFinderController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Produces ("application/json")
    @Accepts("Application/Jjon")
    public String getCheapest(String source, String destination) {
        return null;

    }

    private AmadeusResponse getPayload(String source, String destination){
        return null;
    }


    private List<String> getCheapest(AmadeusResponse payload, int count){
        return null;
    }

}



