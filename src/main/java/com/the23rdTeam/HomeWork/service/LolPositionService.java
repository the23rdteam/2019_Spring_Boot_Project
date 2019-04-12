package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.api.OpenLolSummonerPositionByNameApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LolPositionService {

        @Autowired
        private OpenLolSummonerPositionByNameApiClient openLolSummonerPositionByNameApiClient;

        public List<String> getOpenLolSummonerPositionByNameApiClient(){
            List<String> getopenLolSummonerPositionByNameApiClient = openLolSummonerPositionByNameApiClient.getSummonerPosition();
            return getopenLolSummonerPositionByNameApiClient;
        }
}
