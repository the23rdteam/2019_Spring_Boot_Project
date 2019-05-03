package com.the23rdTeam.HomeWork.controller;


import com.the23rdTeam.HomeWork.domain.LeaguePositionPTO;
import com.the23rdTeam.HomeWork.service.LolEncryptedSummonerIdService;
import com.the23rdTeam.HomeWork.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 Controller 클래스에 @RequestMapping 추가
 => controller 클래스에서 제공되는 API들의 기본 URI가
 http://localhost:8080/weather-crawler와 같이 매핑됨.
 */
@RestController
@RequestMapping("/lolEncryptedSummonerId")
public class LolEncryptedSummonerIdController {
    @Autowired
    private LolEncryptedSummonerIdService lolEncryptedSummonerIdService;

    @GetMapping("/userSummonerId/{summonerName}")
    public SummonerDTO getEncryptedSummonerId(@PathVariable String summonerName){
        return lolEncryptedSummonerIdService.getEncryptedSummonerIdApiClient(summonerName);
    }

    @GetMapping("/currentPosition/{summonerId}")
    public LeaguePositionPTO getCurrentPositionBySummonerId(@PathVariable String summonerId){
        return lolEncryptedSummonerIdService.getCurrentPositionDB(summonerId);
    }



}
