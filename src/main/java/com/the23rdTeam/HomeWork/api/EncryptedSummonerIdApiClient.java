package com.the23rdTeam.HomeWork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class EncryptedSummonerIdApiClient {

    @Autowired
    private RestTemplate restTemplate;

    private final String userId = "hide on bush";

    private final String apiKey = "RGAPI-74183467-1c69-41aa-8217-fa40cb8cce6d";

    private final String EncryptedSummonerIdUri = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/{userId}?api_key={apiKey}";

    public List<String> getEncryptedSummonerId(){
        return null;
    }
}

