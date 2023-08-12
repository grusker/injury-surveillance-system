package com.bb.injurysurveillancesystem.dto.output;

import com.bb.injurysurveillancesystem.entity.Person;
import com.bb.injurysurveillancesystem.entity.enums.Gender;

public class AthleteOutputDto extends Person {
    private Long id;
    private float age;
    private Gender gender;
    private PhysioOutputDto physiotherapist;
    private BodyInfoOutputDto bodyInfo;
    private SportInfoOutputDto sportInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PhysioOutputDto getPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(PhysioOutputDto physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public BodyInfoOutputDto getBodyInfo() {
        return bodyInfo;
    }

    public void setBodyInfo(BodyInfoOutputDto bodyInfo) {
        this.bodyInfo = bodyInfo;
    }

    public SportInfoOutputDto getSportInfo() {
        return sportInfo;
    }

    public void setSportInfo(SportInfoOutputDto sportInfo) {
        this.sportInfo = sportInfo;
    }
}
