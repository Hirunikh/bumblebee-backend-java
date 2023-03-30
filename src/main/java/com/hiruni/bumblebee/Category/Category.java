package com.hiruni.bumblebee.Category;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity (name = "Category")
public class Category {

    @Id
    @SequenceGenerator(
            name = "Category_Sequence",
            sequenceName = "category_Sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Category_Sequence"
    )

    @Column(
            name = "CategoryID",
            updatable = false
    )
    private Integer categoryID;

    @Column(
            name = "CategoryName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String categoryName;

    public Category (
            Integer CategoryID,
            String CategoryName
    )
    {
        this.categoryID = CategoryID;
        this.categoryName = CategoryName;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryID=" + categoryID +
                ", CategoryName='" + categoryName + '\'' +
                '}';
    }
}




