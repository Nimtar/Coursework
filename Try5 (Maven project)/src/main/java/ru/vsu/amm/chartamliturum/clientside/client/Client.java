// Я думаю, в этом package должна производиться вся работа с сетью/сервером
package ru.vsu.amm.chartamliturum.clientside.client;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class Client {

    //Should return report file generated by server
    public void sendRequest () {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity =
            restTemplate.exchange(getUri(), HttpMethod.GET, entity,
                String.class);
    }


    private URI getUri () {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
