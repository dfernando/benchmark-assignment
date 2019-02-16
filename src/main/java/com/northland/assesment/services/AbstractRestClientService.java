package com.northland.assesment.services;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


/**
 * Abstract class for any rest client.
 * Can be reused for different types of clients..
 */
public abstract class AbstractRestClientService {

    /**
     * Should return the fully qualified URL.
     * <code><protocol>://<URL>?PARAM1&PARAM1..</code>
     * <code>protocol = http or https</code>
     * @return Fully qualified URL as String
     */
    public abstract String getUrl();

    /**
     *
     * @return HttpMethod.GET, HttpMethod.POST, etc.
     */
    public abstract HttpMethod getRestMethod();

    /**
     * Authorizatrion key if exists.
     * @return
     */
    public abstract String getAuthorization();

    /**
     * Makes the web service call based on above params and returns the payload as String.
     * @return
     */
    public String makeWebServiceCall() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        if(getAuthorization() != null) {
            headers.add("Authorization", getAuthorization());
        }
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange( getUrl(), getRestMethod() , entity, String.class);
        if(result != null) {
            return result.getBody();
        }
        return null;
    }

}
