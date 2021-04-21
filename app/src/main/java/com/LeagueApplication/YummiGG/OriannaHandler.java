package com.LeagueApplication.YummiGG;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.LeagueEntry;
import com.merakianalytics.orianna.types.core.staticdata.ProfileIcon;
import com.merakianalytics.orianna.types.core.staticdata.ReforgedRunes;
import com.merakianalytics.orianna.types.core.staticdata.SummonerSpells;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public class OriannaHandler extends Thread{

    private String summmonerNameInput;
    String summonerName;
    int summonerLevel;
    LeagueEntry summonerRankedSolo;
    ReforgedRunes runes;
    SummonerSpells summonerSpells;
    String  summonerIconUrl;
    public OriannaHandler(String summmonerNameInput){
        this.summmonerNameInput = summmonerNameInput;
    }

    @Override
    public void run() {
        Summoner summoner = Orianna.summonerNamed(summmonerNameInput).get();
        summonerName = summoner.getName();
        summonerLevel = summoner.getLevel();
        summonerRankedSolo = summoner.getLeaguePosition(Queue.RANKED_SOLO);
        runes = ReforgedRunes.get();
        summonerSpells = SummonerSpells.get();
        summonerIconUrl = summoner.getProfileIcon().getImage().getURL();

    }

}
