package com.hiruni.bumblebee.AccessLevel;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "AccessLevel")
public class AccessLevel {

    @Id
    @SequenceGenerator(
            name = "AccessLevel_Sequence",
            sequenceName = "accessLevel_Sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "AccessLevel_Sequence"
    )

    @Column(
            name = "AccessLevelID",
            updatable = false
    )
    private Integer accessLevelID;

    @Column(
            name = "AccessLevelName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String accessLevelName;

    public AccessLevel (
            Integer AccessLevelID,
            String AccessLevelName
    )
    {
        this.accessLevelID = AccessLevelID;
        this.accessLevelName = AccessLevelName;
    }

    public Integer getAccessLevelID() {
        return accessLevelID;
    }

    public void setAccessLevelID(Integer accessLevelID) {
        this.accessLevelID = accessLevelID;
    }

    public String getAccessLevelName() {
        return accessLevelName;
    }

    public void setAccessLevelName(String accessLevelName) {
        this.accessLevelName = accessLevelName;
    }

    @Override
    public String toString() {
        return "AccessLevel{" +
                "AccessLevelID=" + accessLevelID +
                ", AccessLevelName='" + accessLevelName + '\'' +
                '}';
    }
}
