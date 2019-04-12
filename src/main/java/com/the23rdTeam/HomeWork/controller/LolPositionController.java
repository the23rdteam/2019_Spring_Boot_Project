package com.the23rdTeam.HomeWork.controller;

import com.the23rdTeam.HomeWork.domain.Lol;
import com.the23rdTeam.HomeWork.service.LolPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather-crawler")
public class LolPositionController {

    @Autowired
    private LolPositionService lolPositionService;

    @GetMapping("/lols1")
    public List<String> getLolPositionService(){
        return lolPositionService.getOpenLolSummonerPositionByNameApiClient();
    }

}
