package com.the23rdTeam.HomeWork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;

@Service
public class OpenLolSummonerPositionByNameApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-74183467-1c69-41aa-8217-fa40cb8cce6d" ;

    private final String encryptedSummonerId = "";

    private final String summonerPositionAPI = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{encryptedSummonerId}?api_key=RGAPI-74183467-1c69-41aa-8217-fa40cb8cce6d";

    private final ParameterizedTypeReference<String> responseType = new ParameterizedTypeReference<String>(){};

    public String getSummonerPosition(){
        String responseBody = restTemplate.exchange(summonerPositionAPI, HttpMethod.GET, null, responseType).getBody();
        return responseBody;
    }

}



