package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.api.EncryptedSummonerIdApiClient;
import com.the23rdTeam.HomeWork.api.ShowLeaguePositionApiClient;
import com.the23rdTeam.HomeWork.domain.LeaguePositionPTO;
import com.the23rdTeam.HomeWork.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Set;


@Service
public class LolEncryptedSummonerIdService {
    @Autowired
    private EncryptedSummonerIdApiClient encryptedSummonerIdApiClient;

    @Autowired
    private ShowLeaguePositionApiClient showLeaguePositionApiClient;

    private LinkedList<String> leaguePositionPTOSet = new LinkedList<String>();

    public SummonerDTO getEncryptedSummonerIdApiClient(){
        SummonerDTO EncryptedSummonersInfo = encryptedSummonerIdApiClient.getEncryptedSummonerId();
        return EncryptedSummonersInfo;
    }

    public void getLeaguePositionByEncryptedSummonerId(){
        if(leaguePositionPTOSet.isEmpty())
        {
            SummonerDTO leaguePositionPTOS = this.getEncryptedSummonerIdApiClient();
            leaguePositionPTOSet.add(leaguePositionPTOS.getId());
        }

        String summonerDTO1 = leaguePositionPTOSet.pop();
        leaguePositionPTOSet.add(summonerDTO1);

        Set<LeaguePositionPTO> leaguePositionPTO = showLeaguePositionApiClient.getPosition(summonerDTO1);

    }
}
