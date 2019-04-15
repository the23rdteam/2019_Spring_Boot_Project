package com.the23rdTeam.HomeWork.api;

import com.the23rdTeam.HomeWork.domain.LeaguePosition;
import com.the23rdTeam.HomeWork.domain.LeaguePositionPTO;
import com.the23rdTeam.HomeWork.repository.CurrentPositionDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class ShowLeaguePositionApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-1d45e1cf-1492-4df5-89b1-19be3954216d";

    private final String currentSummonerUrl = "https://kr.api.riotgames.com/lol/league/v4/positions/by-summoner/{EncryptedSummonerId}?api_key={apiKey}";

    HttpHeaders requestHeaders = new HttpHeaders();

    public HttpHeaders setRequestHeaders(HttpHeaders requestHeaders) {
        requestHeaders.set("Content-Type","application/json;charset=utf-8");
        return requestHeaders;
    }

    private final ParameterizedTypeReference<Set<LeaguePositionPTO>> responseType = new ParameterizedTypeReference<Set<LeaguePositionPTO>>(){};

    HttpEntity<?> httpEntity = new HttpEntity<>(setRequestHeaders(requestHeaders));

    public Set<LeaguePositionPTO> getPosition(String EncryptedSummonerId){

        ResponseEntity<Set<LeaguePositionPTO>> currentGetPosition = restTemplate.exchange(currentSummonerUrl, HttpMethod.GET,httpEntity, responseType, EncryptedSummonerId, apiKey);
        Set<LeaguePositionPTO> body = currentGetPosition.getBody();
        return body;
    }

}
