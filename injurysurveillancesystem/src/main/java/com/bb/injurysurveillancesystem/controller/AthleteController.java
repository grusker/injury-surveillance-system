package com.bb.injurysurveillancesystem.controller;

import com.bb.injurysurveillancesystem.dto.input.AthleteInputDto;
import com.bb.injurysurveillancesystem.dto.output.AthleteOutputDto;
import com.bb.injurysurveillancesystem.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/athletes")
public class AthleteController {
    @Autowired
    private AthleteService athleteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AthleteOutputDto createAthlete(@RequestBody AthleteInputDto inputDto) {
        return athleteService.createAthlete(inputDto);
    }

    @GetMapping
    public List<AthleteOutputDto> getAthletes() {
        return athleteService.getAthletes();
    }

    @GetMapping("/{id}")
    public AthleteOutputDto getAthlete(@PathVariable Long id) {
        return athleteService.getAthleteById(id);
    }

    @PutMapping("/{id}")
    public AthleteOutputDto updateAthlete(@PathVariable Long id, @RequestBody AthleteInputDto inputDto) {
        return athleteService.updateAthlete(id, inputDto);
    }
}
