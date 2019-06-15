package by.tolpawsta.models;

import java.time.LocalDate;

/**
 * 14.06.2019
 * by.tolpawsta.models
 *
 * @author Talochka Pavel
 */
public class UserInfo {
    int id;
    String firstname;
    String lastname;
    LocalDate birthdate;

    public UserInfo(int id, String firstname, String lastname, LocalDate birthdate) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
