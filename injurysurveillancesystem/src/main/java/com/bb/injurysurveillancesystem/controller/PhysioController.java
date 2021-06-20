package com.bb.injurysurveillancesystem.controller;

import com.bb.injurysurveillancesystem.dto.input.PhysioInputDto;
import com.bb.injurysurveillancesystem.dto.output.PhysioOutputDto;
import com.bb.injurysurveillancesystem.service.PhysioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/physios")
public class PhysioController {
    @Autowired
    private PhysioService physioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PhysioOutputDto createPhysio(@RequestBody PhysioInputDto inputDto) {
        return physioService.createPhysio(inputDto);
    }

    @GetMapping
    public List<PhysioOutputDto> getPhysios() {
        return physioService.getPhysios();
    }

    @GetMapping("/{id}")
    public PhysioOutputDto getPhysio(@PathVariable Long id) {
        return physioService.getPhysioById(id);
    }
}
