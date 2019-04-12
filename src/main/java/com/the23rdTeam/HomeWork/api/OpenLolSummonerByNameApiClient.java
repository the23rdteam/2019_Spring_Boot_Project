package com.the23rdTeam.HomeWork.api;


import org.springframework.stereotype.Service;

@Service
public class OpenLolSummonerByNameApiClient {

    private String id ="";

    private final String apiKey = "RGAPI-74183467-1c69-41aa-8217-fa40cb8cce6d" ;

    private final String currentLOLApi = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{id}?api_key={apiKey}";

    private void setId(String id)
    {
        this.id = id;
    }
}
