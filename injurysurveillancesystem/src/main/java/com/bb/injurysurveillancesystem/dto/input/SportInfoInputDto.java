package com.bb.injurysurveillancesystem.dto.input;

import com.bb.injurysurveillancesystem.entity.enums.SportBranch;

public class SportInfoInputDto {
    private Long teamId;
    private SportBranch branch;
    private String position;
    private int sportAge;
    private float weeklyTrainingHours;

    public SportBranch getBranch() {
        return branch;
    }

    public void setBranch(SportBranch branch) {
        this.branch = branch;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSportAge() {
        return sportAge;
    }

    public void setSportAge(int sportAge) {
        this.sportAge = sportAge;
    }

    public float getWeeklyTrainingHours() {
        return weeklyTrainingHours;
    }

    public void setWeeklyTrainingHours(float weeklyTrainingHours) {
        this.weeklyTrainingHours = weeklyTrainingHours;
    }
}
