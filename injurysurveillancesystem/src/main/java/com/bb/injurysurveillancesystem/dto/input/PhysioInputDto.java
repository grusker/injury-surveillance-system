package com.bb.injurysurveillancesystem.dto.input;

import com.bb.injurysurveillancesystem.entity.Person;

public class PhysioInputDto extends Person {

    private Long teamId;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
