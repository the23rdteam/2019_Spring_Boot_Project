package com.the23rdTeam.HomeWork.wrapper;

import lombok.Data;

@Data
public class LeaguePositionPTO {

    private String queueType;

    private String summonerName;

    private boolean hotStreak;

    private MiniSeriesDTO miniSeries;

    private int wins;

    private boolean veteran;

    private int losses;

    private String rank;

    private String leagueId;

    private boolean inactive;

    private boolean freshBlood;

    private String leagueName;

    private String position;

    private String tier;

    private String summonerId;

    private int leaguePoints;

}
