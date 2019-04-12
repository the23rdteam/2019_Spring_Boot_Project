package com.the23rdTeam.HomeWork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class EncryptedSummonerIdApiClient {

    @Autowired
    private RestTemplate restTemplate;

    public List<String> getEncryptedSummonerId(){
        return null;
    }
}

