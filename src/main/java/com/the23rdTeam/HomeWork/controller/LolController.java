package com.the23rdTeam.HomeWork.controller;

import com.the23rdTeam.HomeWork.domain.Lol;
import com.the23rdTeam.HomeWork.service.LolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LolController {

    @Autowired
    private LolService lolService;

    @GetMapping("/Lols")
    private List<Lol> getAllLol(){
        return lolService.getAllLol();
    }


}
