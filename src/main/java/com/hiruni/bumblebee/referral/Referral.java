package com.hiruni.bumblebee.referral;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Referral")
public class Referral {

    @Id
    @SequenceGenerator(
            name = "Referral_Sequence",
            sequenceName = "Referral_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Referral_Sequence"
    )

    @Column(
            name = "ReferralID",
            updatable = false
    )
    private Integer referralID;

    @Column(
            name = "ReferringCustomerID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private  Integer referringCustomerID;

    @Column(
            name = "ReferredCustomerID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private  Integer referredCustomerID;

    public Referral(Integer referralID,
                    Integer referringCustomerID,
                    Integer referredCustomerID) {
        this.referralID = referralID;
        this.referringCustomerID = referringCustomerID;
        this.referredCustomerID = referredCustomerID;
    }

    public Integer getReferralID() {
        return referralID;
    }

    public void setReferralID(Integer referralID) {
        this.referralID = referralID;
    }

    public Integer getReferringCustomerID() {
        return referringCustomerID;
    }

    public void setReferringCustomerID(Integer referringCustomerID) {
        this.referringCustomerID = referringCustomerID;
    }

    public Integer getReferredCustomerID() {
        return referredCustomerID;
    }

    public void setReferredCustomerID(Integer referredCustomerID) {
        this.referredCustomerID = referredCustomerID;
    }

    @Override
    public String toString() {
        return "Referral{" +
                "referralID=" + referralID +
                ", referringCustomerID=" + referringCustomerID +
                ", referredCustomerID=" + referredCustomerID +
                '}';
    }
}
