package com.flow.springtest.service;

import com.flow.springtest.entity.Team;
import com.flow.springtest.exception.NoSuchThingException;
import com.flow.springtest.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createTeam(Team team) {
        Team created = teamRepository.save(team);
        return created;
    }


    public Team findTeamById(String id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isEmpty()) {
            throw new NoSuchThingException("No team found");
        }
        return team.get();
    }

    public List<Team> findAll() {
        List<Team> teams = teamRepository.findAll();
        return teams;
    }
}
