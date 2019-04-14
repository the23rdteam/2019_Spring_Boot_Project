package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.api.EncryptedSummonerIdApiClient;
import com.the23rdTeam.HomeWork.api.ShowLeaguePositionApiClient;
import com.the23rdTeam.HomeWork.domain.LeaguePositionPTO;
import com.the23rdTeam.HomeWork.domain.SummonerDTO;
import com.the23rdTeam.HomeWork.repository.CurrentPositionDB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


@Service
@Slf4j
public class LolEncryptedSummonerIdService {
    @Autowired
    private EncryptedSummonerIdApiClient encryptedSummonerIdApiClient;

    @Autowired
    private ShowLeaguePositionApiClient showLeaguePositionApiClient;

    @Autowired
    private CurrentPositionDB currentPositionDB;

    private LinkedList<String> leaguePositionPTOSet = new LinkedList<String>();

    public SummonerDTO getEncryptedSummonerIdApiClient(){
        SummonerDTO EncryptedSummonersInfo = encryptedSummonerIdApiClient.getEncryptedSummonerId();
        return EncryptedSummonersInfo;
    }

    @Scheduled(initialDelay = 5000L, fixedDelay = 2000L)
    public void getLeaguePositionByEncryptedSummonerId(){
        if(leaguePositionPTOSet.isEmpty())
        {
            SummonerDTO leaguePositionPTOS = this.getEncryptedSummonerIdApiClient();
            leaguePositionPTOSet.add(leaguePositionPTOS.getId());
        }

        String summonerDTO1 = leaguePositionPTOSet.pop();
        leaguePositionPTOSet.add(summonerDTO1);

        CurrentPositionDB leaguePositionPTO = showLeaguePositionApiClient.getPosition(summonerDTO1);

        CurrentPositionDB insertedCurrentPO = currentPositionDB.insertCurrentPositionDB(leaguePositionPTO);
        log.info("currentPosition has inserted successfully. CurrentPosition : {}", insertedCurrentPO);

    }
    public CurrentPositionDB getCurrentPositionDB(String summonerId){
        return currentPositionDB.findPositionBySummonerId(summonerId);
    }
}
