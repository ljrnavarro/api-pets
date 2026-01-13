package com.petshoppb.pet.client;

import com.petshoppb.pet.dto.DogApiResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DogApiClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String apiKey;

    public DogApiClient(
            RestTemplate restTemplate,
            @Value("${dogapi.url}") String baseUrl,
            @Value("${dogapi.api-key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
    }

    public DogApiResponseDTO buscarPorRaca(String raca) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String url = baseUrl + "/breeds/search?q=" + raca;

        ResponseEntity<DogApiResponseDTO[]> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        DogApiResponseDTO[].class
                );

        if (response.getBody() == null || response.getBody().length == 0) {
            return null;
        }

        return response.getBody()[0];
    }
}
