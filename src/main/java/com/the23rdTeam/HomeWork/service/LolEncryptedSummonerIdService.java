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

import javax.annotation.PostConstruct;
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

    public SummonerDTO getEncryptedSummonerIdApiClient(String summonerName){
        SummonerDTO EncryptedSummonersInfo = encryptedSummonerIdApiClient.getEncryptedSummonerId(summonerName);
        return EncryptedSummonersInfo;
    }

    @PostConstruct
    public void getLeaguePositionByEncryptedSummonerId(){
        if(leaguePositionPTOSet.isEmpty())
        {

            String[] summonerNames = {"hide on bush", "Bed of roses", "BBBOTTT", "나는왜게임을하지"};

            for(int i=0; i<summonerNames.length;i++) {
                SummonerDTO leaguePositionPTOS = this.getEncryptedSummonerIdApiClient(summonerNames[i]);
                leaguePositionPTOSet.add(leaguePositionPTOS.getId());
            }
            for(int i=0; i<leaguePositionPTOSet.size();i++) {

                String summonerDTO1 = leaguePositionPTOSet.pop();
                leaguePositionPTOSet.add(summonerDTO1);
                Set<LeaguePositionPTO> test = showLeaguePositionApiClient.getPosition(summonerDTO1);
                LeaguePositionPTO leaguePositionPTO = null;
                for (LeaguePositionPTO a : test) {
                    leaguePositionPTO = a;
                }
                LeaguePositionPTO insertedCurrentPO = currentPositionDB.insertCurrentPositionDB(leaguePositionPTO);
                log.info("currentPosition has inserted successfully. CurrentPosition : {}", insertedCurrentPO);
            }

        }
    }
    public LeaguePositionPTO getCurrentPositionDB(String summonerId){
        return currentPositionDB.findPositionBySummonerId(summonerId);
    }
}
