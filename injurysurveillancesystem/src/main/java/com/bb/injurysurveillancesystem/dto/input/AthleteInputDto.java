package com.bb.injurysurveillancesystem.dto.input;

import com.bb.injurysurveillancesystem.entity.Person;
import com.bb.injurysurveillancesystem.entity.enums.Gender;

public class AthleteInputDto extends Person {
    private int age;
    private Gender gender;
    private Long physioId;
    private BodyInfoInputDto bodyInfo;
    private SportInfoInputDto sportInfo;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getPhysioId() {
        return physioId;
    }

    public void setPhysioId(Long physioId) {
        this.physioId = physioId;
    }

    public BodyInfoInputDto getBodyInfo() {
        return bodyInfo;
    }

    public void setBodyInfo(BodyInfoInputDto bodyInfo) {
        this.bodyInfo = bodyInfo;
    }

    public SportInfoInputDto getSportInfo() {
        return sportInfo;
    }

    public void setSportInfo(SportInfoInputDto sportInfo) {
        this.sportInfo = sportInfo;
    }
}
