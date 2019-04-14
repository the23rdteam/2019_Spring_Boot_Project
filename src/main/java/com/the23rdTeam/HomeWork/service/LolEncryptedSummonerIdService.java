package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.api.EncryptedSummonerIdApiClient;
import com.the23rdTeam.HomeWork.api.ShowLeaguePositionApiClient;
import com.the23rdTeam.HomeWork.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LolEncryptedSummonerIdService {
    @Autowired
    private EncryptedSummonerIdApiClient encryptedSummonerIdApiClient;

    @Autowired
    private ShowLeaguePositionApiClient showLeaguePositionApiClient;

    public SummonerDTO getEncryptedSummonerIdApiClient(){
        SummonerDTO EncryptedSummonersInfo = encryptedSummonerIdApiClient.getEncryptedSummonerId();
        return EncryptedSummonersInfo;
    }
}
