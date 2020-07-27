package com.example.demo;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

@Component
public class Repository {

    //TODO  List is not thread safe
    private static List<Team> teamList = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(Repository.class);

    private Repository() {
        //private constructor to not be able to initiate
    }

    public String getTeamList() {
        Gson gson = new Gson();
        LOG.info("Retrieved {} teams,", teamList.size());
        if (teamList.isEmpty()) {
            LOG.error("No teams found in database");
            return gson.toJson(new CustomResponse("ERROR", "No teams in the Database"));
        } else {
            return gson.toJson(teamList);
        }
    }


    public List<Team> getSortedTeamList() {
        LOG.info("Requesting list of teams sorted by Stadium capacity..");
        Collections.sort(teamList, Comparator.comparingInt(Team::getStadiumCapacity));
        return teamList;
    }


    public String getTeamDetails(String name) {
        Gson gson = new Gson();
        try {
            Team team = findTeam(name);
            LOG.info("Found team {}", team);
            return gson.toJson(team);
        } catch (NoSuchElementException e) {
            LOG.error("No team with name: {} found.", name);
            return gson.toJson(new CustomResponse("ERROR", "No team with name: " + name + " found."));
        }
    }

    public Team getTeam(String name) {
        try {
            return findTeam(name);
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void insertTeam(Team team) {
        teamList.add(team);
    }

    private Team findTeam(String name){
        return teamList.stream().filter(team5 -> team5.getName().equals(name)).findFirst().get();
    }

}
