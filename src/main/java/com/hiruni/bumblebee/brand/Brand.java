package com.hiruni.bumblebee.brand;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Entity (name = "Brand")

public class Brand {

    @Id
    @SequenceGenerator(
            name = "Brand_Sequence",
            sequenceName = "brand_Sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Brand_Sequence"
    )

    @Column(
            name = "BrandID",
            updatable = false
    )
    private Integer brandID;

    @Column(
            name = "BrandName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String brandName;

    public Brand (
            Integer BrandID,
            String BrandName
    )
    {
        this.brandID = BrandID;
        this.brandName = BrandName;
    }

    public Integer getBrandID() {
        return brandID;
    }

    public void setBrandID(Integer brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String categoryName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "BrandID=" + brandID +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
