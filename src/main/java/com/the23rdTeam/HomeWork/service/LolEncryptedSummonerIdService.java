package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.api.EncryptedSummonerIdApiClient;
import com.the23rdTeam.HomeWork.api.ShowLeaguePositionApiClient;
import com.the23rdTeam.HomeWork.domain.LeaguePositionPTO;
import com.the23rdTeam.HomeWork.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class LolEncryptedSummonerIdService {
    @Autowired
    private EncryptedSummonerIdApiClient encryptedSummonerIdApiClient;

    @Autowired
    private ShowLeaguePositionApiClient showLeaguePositionApiClient;

    private Set<LeaguePositionPTO> leaguePositionPTOSet = new Set<LeaguePositionPTO>();

    public SummonerDTO getEncryptedSummonerIdApiClient(){
        SummonerDTO EncryptedSummonersInfo = encryptedSummonerIdApiClient.getEncryptedSummonerId();
        return EncryptedSummonersInfo;
    }

    public void getLeaguePositionByEncryptedSummonerId(SummonerDTO summonerDTO){

    }
}
