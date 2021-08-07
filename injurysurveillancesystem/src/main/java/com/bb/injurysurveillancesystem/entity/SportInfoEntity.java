package com.bb.injurysurveillancesystem.entity;

import com.bb.injurysurveillancesystem.entity.enums.SportBranch;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "sportInfo")
public class SportInfoEntity {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @Enumerated(EnumType.STRING)
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
