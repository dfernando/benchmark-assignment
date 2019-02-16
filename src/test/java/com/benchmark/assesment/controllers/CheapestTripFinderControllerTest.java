package com.benchmark.assesment.controllers;

import com.benchmark.assesment.controllers.CheapestTripFinderController;

import com.benchmark.assesment.dto.AmadeusResponse;
import com.benchmark.assesment.dto.Price;
import com.benchmark.assesment.services.AbstractRestClientService;
import com.benchmark.assesment.services.AmadeusRestClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.validation.constraints.AssertTrue;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath*: /WEB-INF/spring-servlet.xml")
public class CheapestTripFinderControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    private CheapestTripFinderController fixture;

    MockMvc mockMvc;


    @Spy
    AmadeusRestClient mockedAmadeusRestClient = new AmadeusRestClient();

    @Before
    public void setup(){

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void shouldEstablishProperConnectionAndFailDueToNotAuthorized() throws Exception {
        mockMvc.perform(get("/hello")
                .param("origin", "NYC")
                .param("destination", "MAD")
                .param("departureDate","2019-10-01")
                .param("key","dummykey")
         ).andExpect(status().is(404));

    }


    @Test
    public void shouldMakeSureParamsAreValid() throws Exception {
        AmadeusRestClient spyMockedAmadeusRestClient = spy(mockedAmadeusRestClient);
        CheapestTripFinderController cheapestTripFinderController = new CheapestTripFinderController();
        cheapestTripFinderController.amadeusRestClient = spyMockedAmadeusRestClient;
        cheapestTripFinderController.numResults = 2;

        spyMockedAmadeusRestClient.setUrl("NYC","MAD","222",2);
        doReturn(testPayload).when(spyMockedAmadeusRestClient).makeWebServiceCall();

        List<Price> list = cheapestTripFinderController.getCheapest("a","b","c","112");
        assertTrue(list.size() == 2);
        assertTrue(list.get(0).getTotal() == 118.38D);



    }


    private String testPayload = "{\n" +
            "    \"data\": [\n" +
            "        {\n" +
            "            \"type\": \"flight-offer\",\n" +
            "            \"id\": \"1550356801654--92446414\",\n" +
            "            \"offerItems\": [\n" +
            "                {\n" +
            "                    \"services\": [\n" +
            "                        {\n" +
            "                            \"segments\": [\n" +
            "                                {\n" +
            "                                    \"flightSegment\": {\n" +
            "                                        \"departure\": {\n" +
            "                                            \"iataCode\": \"JFK\",\n" +
            "                                            \"terminal\": \"4\",\n" +
            "                                            \"at\": \"2019-08-01T22:05:00-04:00\"\n" +
            "                                        },\n" +
            "                                        \"arrival\": {\n" +
            "                                            \"iataCode\": \"MAD\",\n" +
            "                                            \"terminal\": \"1\",\n" +
            "                                            \"at\": \"2019-08-02T11:40:00+02:00\"\n" +
            "                                        },\n" +
            "                                        \"carrierCode\": \"UX\",\n" +
            "                                        \"number\": \"92\",\n" +
            "                                        \"aircraft\": {\n" +
            "                                            \"code\": \"332\"\n" +
            "                                        },\n" +
            "                                        \"operating\": {\n" +
            "                                            \"carrierCode\": \"UX\",\n" +
            "                                            \"number\": \"92\"\n" +
            "                                        },\n" +
            "                                        \"duration\": \"0DT7H35M\"\n" +
            "                                    },\n" +
            "                                    \"pricingDetailPerAdult\": {\n" +
            "                                        \"travelClass\": \"ECONOMY\",\n" +
            "                                        \"fareClass\": \"M\",\n" +
            "                                        \"availability\": 9,\n" +
            "                                        \"fareBasis\": \"MYYOAE\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"price\": {\n" +
            "                        \"total\": \"1716.49\",\n" +
            "                        \"totalTaxes\": \"179.49\"\n" +
            "                    },\n" +
            "                    \"pricePerAdult\": {\n" +
            "                        \"total\": \"1716.49\",\n" +
            "                        \"totalTaxes\": \"179.49\"\n" +
            "                    }\n" +
            "                }\n" +
            "            ]\n" +
            "        },\n" +
            "        {\n" +
            "            \"type\": \"flight-offer\",\n" +
            "            \"id\": \"1550356801654-1344204028\",\n" +
            "            \"offerItems\": [\n" +
            "                {\n" +
            "                    \"services\": [\n" +
            "                        {\n" +
            "                            \"segments\": [\n" +
            "                                {\n" +
            "                                    \"flightSegment\": {\n" +
            "                                        \"departure\": {\n" +
            "                                            \"iataCode\": \"JFK\",\n" +
            "                                            \"terminal\": \"5\",\n" +
            "                                            \"at\": \"2019-08-01T23:25:00-04:00\"\n" +
            "                                        },\n" +
            "                                        \"arrival\": {\n" +
            "                                            \"iataCode\": \"LIS\",\n" +
            "                                            \"terminal\": \"1\",\n" +
            "                                            \"at\": \"2019-08-02T11:15:00+01:00\"\n" +
            "                                        },\n" +
            "                                        \"carrierCode\": \"TP\",\n" +
            "                                        \"number\": \"208\",\n" +
            "                                        \"aircraft\": {\n" +
            "                                            \"code\": \"332\"\n" +
            "                                        },\n" +
            "                                        \"operating\": {\n" +
            "                                            \"carrierCode\": \"TP\",\n" +
            "                                            \"number\": \"208\"\n" +
            "                                        },\n" +
            "                                        \"duration\": \"0DT6H50M\"\n" +
            "                                    },\n" +
            "                                    \"pricingDetailPerAdult\": {\n" +
            "                                        \"travelClass\": \"ECONOMY\",\n" +
            "                                        \"fareClass\": \"O\",\n" +
            "                                        \"availability\": 9,\n" +
            "                                        \"fareBasis\": \"OUSDSI0E\"\n" +
            "                                    }\n" +
            "                                },\n" +
            "                                {\n" +
            "                                    \"flightSegment\": {\n" +
            "                                        \"departure\": {\n" +
            "                                            \"iataCode\": \"LIS\",\n" +
            "                                            \"terminal\": \"1\",\n" +
            "                                            \"at\": \"2019-08-02T13:15:00+01:00\"\n" +
            "                                        },\n" +
            "                                        \"arrival\": {\n" +
            "                                            \"iataCode\": \"MAD\",\n" +
            "                                            \"terminal\": \"2\",\n" +
            "                                            \"at\": \"2019-08-02T15:30:00+02:00\"\n" +
            "                                        },\n" +
            "                                        \"carrierCode\": \"TP\",\n" +
            "                                        \"number\": \"1028\",\n" +
            "                                        \"aircraft\": {\n" +
            "                                            \"code\": \"319\"\n" +
            "                                        },\n" +
            "                                        \"operating\": {\n" +
            "                                            \"carrierCode\": \"TP\",\n" +
            "                                            \"number\": \"1028\"\n" +
            "                                        },\n" +
            "                                        \"duration\": \"0DT1H15M\"\n" +
            "                                    },\n" +
            "                                    \"pricingDetailPerAdult\": {\n" +
            "                                        \"travelClass\": \"ECONOMY\",\n" +
            "                                        \"fareClass\": \"O\",\n" +
            "                                        \"availability\": 9,\n" +
            "                                        \"fareBasis\": \"OUSDSI0E\"\n" +
            "                                    }\n" +
            "                                }\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ],\n" +
            "                    \"price\": {\n" +
            "                        \"total\": \"118.38\",\n" +
            "                        \"totalTaxes\": \"95.38\"\n" +
            "                    },\n" +
            "                    \"pricePerAdult\": {\n" +
            "                        \"total\": \"118.38\",\n" +
            "                        \"totalTaxes\": \"95.38\"\n" +
            "                    }\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    ],\n" +
            "    \"dictionaries\": {\n" +
            "        \"carriers\": {\n" +
            "            \"UX\": \"AIR EUROPA\",\n" +
            "            \"TP\": \"TAP PORTUGAL\"\n" +
            "        },\n" +
            "        \"currencies\": {\n" +
            "            \"EUR\": \"EURO\"\n" +
            "        },\n" +
            "        \"aircraft\": {\n" +
            "            \"319\": \"AIRBUS INDUSTRIE A319\",\n" +
            "            \"332\": \"AIRBUS INDUSTRIE A330-200\"\n" +
            "        },\n" +
            "        \"locations\": {\n" +
            "            \"MAD\": {\n" +
            "                \"subType\": \"AIRPORT\",\n" +
            "                \"detailedName\": \"ADOLFO SUAREZ BARAJAS\"\n" +
            "            },\n" +
            "            \"LIS\": {\n" +
            "                \"subType\": \"AIRPORT\",\n" +
            "                \"detailedName\": \"AIRPORT\"\n" +
            "            },\n" +
            "            \"JFK\": {\n" +
            "                \"subType\": \"AIRPORT\",\n" +
            "                \"detailedName\": \"JOHN F KENNEDY INTL\"\n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
            "    \"meta\": {\n" +
            "        \"links\": {\n" +
            "            \"self\": \"https://test.api.amadeus.com/v1/shopping/flight-offers?origin=NYC&destination=MAD&departureDate=2019-08-01&adults=1&nonStop=false&max=2\"\n" +
            "        },\n" +
            "        \"currency\": \"EUR\",\n" +
            "        \"defaults\": {\n" +
            "            \"nonStop\": false,\n" +
            "            \"adults\": 1\n" +
            "        }\n" +
            "    }\n" +
            "}";


}
