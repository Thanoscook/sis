package com.example.demo;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
public class TeamsController {
    private static final Logger LOG = LoggerFactory.getLogger(TeamsController.class);
    private Repository repository;

    public TeamsController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/all-teams")
    @ResponseBody
    public String allTeams() {
        return repository.getTeamList();
    }

    @GetMapping("/by-stadium-capacity")
    @ResponseBody
    public List<Team> sortedByStadiumCapacity() {
        return repository.getSortedTeamList();
    }

    @GetMapping("/team-details")
    @ResponseBody
    public String teamByName(@RequestParam(name = "name") String name) {
        return repository.getTeamDetails(name);
    }

    @PostMapping("/add-team")
    @ResponseBody
    public String yes(@RequestParam(name = "name") String name, @RequestParam(name = "city") String city,
                      @RequestParam(name = "owner") String owner, @RequestParam(name = "stadiumCapacity") int stadiumCapacity,
                      @RequestParam(name = "competition") String competition, @RequestParam(name = "numberOfPlayers") int numberOfPlayers,
                      @RequestParam(name = "founded") Date founded) {
        Team team = new Team(name, city, owner, stadiumCapacity, competition, numberOfPlayers, founded);

        if (repository.getTeam(name) != null) {
            return new Gson().toJson(new CustomResponse("ERROR", "Team with name: " + name + " already exists"));
        }

        repository.insertTeam(team);
        return "New team added: " + team.toString();
    }

}
