package com.northland.assesment.services;

import com.northland.assesment.dto.AmadeusResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Spring Service to call Amadeus API and get payload.
 */
@Service
public class AmadeusRestClient extends AbstractRestClientService {

    private StringBuffer url = null;
    JsonToObjectMappingService jsonToObjectMappingService = new JsonToObjectMappingService();
    private String authorizatioKey = null;

    /**
     * Flight details based on the params passed
     * @param origin
     * @param destination
     * @param date
     * @param numOfResults
     * @return
     * @throws IOException
     */
    public AmadeusResponse getFlightDetails(String origin, String destination, String date, int numOfResults) throws IOException {
        setUrl(origin, destination, date, numOfResults);
        String payload = makeWebServiceCall();
        AmadeusResponse amadeusResponse = jsonToObjectMappingService.getPayload(payload, AmadeusResponse.class);
        return amadeusResponse;

    }

    /**
     *
     * @param key
     */
    public void setAuthorizatioKey(String key){
        authorizatioKey = "Bearer "+key;
    }

    @Override
    public String getUrl() {
        return url.toString();
    }

    @Override
    public HttpMethod getRestMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getAuthorization() {
        return authorizatioKey;
    }


    /**
     * Generate the URL based on params passed into the REST controller.
     * @param origin
     * @param destination
     * @param date
     * @param numOfResults
     */
    public void setUrl(String origin, String destination, String date, int numOfResults){
        url = new StringBuffer("https://test.api.amadeus.com/v1/shopping/flight-offers?");

        url.append("origin=").append(origin).append("&")
                .append("destination=").append(destination).append("&")
                .append("departureDate=").append(date).append("&")
                .append("max=").append(numOfResults);


    }


}
