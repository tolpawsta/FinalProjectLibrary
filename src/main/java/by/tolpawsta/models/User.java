package by.tolpawsta.models;

import java.time.LocalDate;

/**
 * 10.06.2019
 * by.tolpawsta.models
 *
 * @author Talochka Pavel
 */
public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private LocalDate birthday;

    public User() {
    }

    public User(String firstname, String lastname, String login, String password, LocalDate birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
    }

    public User(int id, String firstname, String lastname, LocalDate birthday) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFullName() {
        return firstname + " " + lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
