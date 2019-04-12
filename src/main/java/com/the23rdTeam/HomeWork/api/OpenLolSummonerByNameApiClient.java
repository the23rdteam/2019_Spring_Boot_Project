package com.the23rdTeam.HomeWork.api;


import com.the23rdTeam.HomeWork.domain.LolPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenLolSummonerByNameApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "RGAPI-74183467-1c69-41aa-8217-fa40cb8cce6d" ;

    private final String currentLOLApi = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{userId}?api_key={apiKey}";

    public LolPosition getLolPosition(String userId){
        LolPosition lolPosition = restTemplate.exchange(currentLOLApi, HttpMethod.GET,null,LolPosition.class,userId,apiKey).getBody();
        return lolPosition;
    }
}
