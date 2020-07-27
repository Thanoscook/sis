package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import static com.example.demo.TeamsUtil.*;

@Controller
public class TeamsController {
    private static final Logger LOG = LoggerFactory.getLogger(TeamsController.class);
    @GetMapping("/all-teams")
    @ResponseBody
    public List<Team> allTeams() {
        LOG.info("Retrieved {} teams,", getTeamList().size());
        return getTeamList();
    }

    @GetMapping("/by-stadium-capacity")
    @ResponseBody
    public List<Team> sortedByStadiumCapacity() {
        return getSortedTeamList();
    }

    @GetMapping("/team-details")
    @ResponseBody
    public String teamByName(@RequestParam(name = "name") String name) {
        return getTeamDetails(name);
    }

    @PostMapping("/add-team")
    @ResponseBody
    public String yes(@RequestParam(name = "name") String name, @RequestParam(name = "city") String city,
                      @RequestParam(name = "owner") String owner, @RequestParam(name = "stadiumCapacity") int stadiumCapacity,
                      @RequestParam(name = "competition") String competition, @RequestParam(name = "numberOfPlayers") int numberOfPlayers,
                      @RequestParam(name = "founded") Date founded) {
        Team team = new Team(name, city, owner, stadiumCapacity, competition, numberOfPlayers, founded);

        if (getTeam(name) != null) {
            return "Team with name: " + name + " already exists.";
        }

        getTeamList().add(team);

        return "New team added: " + team.toString();
    }

}
