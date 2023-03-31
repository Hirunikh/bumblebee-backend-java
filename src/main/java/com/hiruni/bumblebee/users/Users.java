package com.hiruni.bumblebee.users;

import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor

@Entity(name = "Users")

@Table (
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "users_Email_unique", columnNames = "Email")
        }
)
public class Users {
    @Id
    @SequenceGenerator(
            name = "Users_Sequence",
            sequenceName = "Users_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "Users_Sequence"
    )

    @Column(
            name = "UserID",
            updatable = false
    )
    private Integer userID;

    @Column(
            name = "UserName",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String userName;

    @Column(
            name = "Email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "Password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "Role",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String role;

    @Column(
            name = "AccessLevelID",
            nullable = false,
            columnDefinition = "Integer"
    )
    private Integer accessLevelID;

    public Users (Integer userID,
                        String userName,
                        String email,
                        String password,
                        String role,
                        Integer accessLevelID) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.accessLevelID = accessLevelID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAccessLevelID() {
        return accessLevelID;
    }

    public void setAccessLevelID(Integer accessLevelID) {
        this.accessLevelID = accessLevelID;
    }

    @Override
    public String toString() {
        return "UsersService{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", accessLevelID=" + accessLevelID +
                '}';
    }
}
