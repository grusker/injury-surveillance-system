package com.bb.injurysurveillancesystem.dto.output;

import com.bb.injurysurveillancesystem.entity.Person;

public class PhysioOutputDto extends Person {
    private Long id;

    private TeamOutputDto team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamOutputDto getTeam() {
        return team;
    }

    public void setTeam(TeamOutputDto team) {
        this.team = team;
    }
}
