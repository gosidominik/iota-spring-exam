package com.flow.springtest.controller;

import com.flow.springtest.entity.Team;
import com.flow.springtest.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team) {
        Team created = teamService.createTeam(team);
        if (created.getName().equals(null) || created.getName().equals("")) {
            throw new
        }
        return created;
    }

    @GetMapping("/findAll")
    public List<Team> findAll(){
        List<Team> teams = teamService.findAll();
        return teams;
    }

    @GetMapping("/findById/{id}")
    public Team findTeamById(@PathVariable("id")String id) {
        Team team = teamService.findTeamById(id);
        return team;
    }
}
