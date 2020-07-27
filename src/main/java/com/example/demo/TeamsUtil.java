package com.example.demo;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class TeamsUtil {

    private static List<Team> teamList = new ArrayList<>();
    private static final Logger LOG = LoggerFactory.getLogger(TeamsUtil.class);

    private TeamsUtil() {
        //private constructor to not be able to initiate
    }

    public static List<Team> getTeamList() {
        return teamList;
    }


    public static List<Team> getSortedTeamList() {
        LOG.info("Requesting list of teams sorted by Stadium capacity..");
        Collections.sort(teamList, Comparator.comparingInt(Team::getStadiumCapacity));
        return teamList;
    }


    public static String getTeamDetails(String name) {
        Gson gson = new Gson();
        try {
            Team team = teamList.stream().filter(team5 -> team5.getName().equals(name)).findFirst().get();
            LOG.info("Found team {}", team);
            return gson.toJson(team);
        } catch (NoSuchElementException e) {
            LOG.error("No team with name: {} found.", name);
            return gson.toJson(new CustomResponse("ERROR", "No team with name: " + name + " found."));
        }
    }

    public static Team getTeam(String name) {
        try {
            return teamList.stream().filter(team5 -> team5.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}
