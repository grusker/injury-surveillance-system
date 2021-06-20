package com.bb.injurysurveillancesystem.entity;

import com.bb.injurysurveillancesystem.entity.enums.BodySide;
import com.bb.injurysurveillancesystem.entity.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "athlete")
public class AthleteEntity extends Person{
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    @Column(columnDefinition = "NUMBER(4,1)")
    private float height;
    @Column(columnDefinition = "NUMBER(4,1)")
    private float weight;
    @Column(columnDefinition = "NUMBER(10,3)")
    private float bmi;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private BodySide dominantSide;
    @ManyToOne
    @JoinColumn(name = "physio_id", nullable = true)
    private PhysioEntity physioterapist;


    public Long getId() {
        return id;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        setBmi();
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
        setBmi();
    }

    public float getBmi() {
        return this.bmi;
    }

    private void setBmi() {
        if(getWeight()>0 && getHeight()>0) {
            this.bmi = getWeight() / ((getHeight()/100) * (getHeight()/100));
        } else {
            this.bmi = 0;
        }
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public BodySide getDominantSide() {
        return dominantSide;
    }

    public void setDominantSide(BodySide dominantSide) {
        this.dominantSide = dominantSide;
    }

    public PhysioEntity getPhysioterapist() {
        return physioterapist;
    }

    public void setPhysioterapist(PhysioEntity physioterapist) {
        this.physioterapist = physioterapist;
    }
}
