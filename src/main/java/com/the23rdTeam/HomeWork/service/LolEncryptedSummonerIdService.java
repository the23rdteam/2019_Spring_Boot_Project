package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.api.EncryptedSummonerIdApiClient;
import com.the23rdTeam.HomeWork.wrapper.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class LolEncryptedSummonerIdService {
    @Autowired
    private EncryptedSummonerIdApiClient encryptedSummonerIdApiClient;

    public SummonerDTO getEncryptedSummonerIdApiClient(){
        SummonerDTO EncryptedSummonersInfo = encryptedSummonerIdApiClient.getEncryptedSummonerId();
        return EncryptedSummonersInfo;
    }
}
