package com.the23rdTeam.HomeWork.api;

import com.the23rdTeam.HomeWork.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class EncryptedSummonerIdApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String userId = "BBBOTTT";

    private final String apiKey = "RGAPI-a649dfd3-8021-4e95-8e46-89cf5be1d0ff";

    private final String EncryptedSummonerIdUri = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{userId}?api_key={apiKey}";

    HttpHeaders requestHeaders = new HttpHeaders();

    public HttpHeaders setRequestHeaders(HttpHeaders requestHeaders) {
        requestHeaders.set("Content-Type","application/json;charset=utf-8");
        return requestHeaders;
    }

    private final ParameterizedTypeReference<SummonerDTO> responseType = new ParameterizedTypeReference<SummonerDTO>(){};

    HttpEntity<?> httpEntity = new HttpEntity<>(setRequestHeaders(requestHeaders));

    public SummonerDTO getEncryptedSummonerId(){
        ResponseEntity<SummonerDTO> responseBody = restTemplate.exchange(EncryptedSummonerIdUri, HttpMethod.GET,httpEntity,responseType, userId, apiKey);
        SummonerDTO body = responseBody.getBody();
        return body;
    }
}

