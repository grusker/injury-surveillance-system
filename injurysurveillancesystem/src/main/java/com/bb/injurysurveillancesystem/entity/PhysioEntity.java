package com.bb.injurysurveillancesystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "physio")
public class PhysioEntity extends Person{
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = true)
    private TeamEntity team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }
}
