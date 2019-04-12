package com.the23rdTeam.HomeWork.service;

import com.the23rdTeam.HomeWork.domain.Lol;

import java.util.ArrayList;
import java.util.List;

public class LolService {
    private List<Lol> Lolidlist = new ArrayList<>();

    public void insertLol(Lol lol)
    {
        Lolidlist.add(lol);
    }

    public List<Lol> getAllDogs(){
        return Lolidlist;
    }

    public Lol getLolsByName(String name){
        for(int i=0;i<Lolidlist.size();i++)
        {
            Lol target = Lolidlist.get(i);
            if(target.getSummonerName().equals(name))
            {
                return target;
            }
        }
        return null;
    }

}
