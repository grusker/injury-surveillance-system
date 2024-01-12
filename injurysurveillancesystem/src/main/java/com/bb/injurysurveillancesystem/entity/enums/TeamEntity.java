package com.bb.injurysurveillancesystem.entity.enums;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class TeamEntity {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    private String name;
}
