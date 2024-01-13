package com.bb.injurysurveillancesystem.controller;

import com.bb.injurysurveillancesystem.dto.input.TeamInputDto;
import com.bb.injurysurveillancesystem.dto.output.TeamOutputDto;
import com.bb.injurysurveillancesystem.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamOutputDto createTeam(@RequestBody TeamInputDto team) {
        return teamService.createTeam(team);
    }

    @GetMapping
    public List<TeamOutputDto> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    public TeamOutputDto getTeam(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    public TeamOutputDto updateTeam(@PathVariable Long id, @RequestBody TeamInputDto updatedTeam) {
        return teamService.updateTeam(id, updatedTeam);
    }
}
