package com.springapp.mvc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Maxim.Temborskiy on 19.11.2016.
 */

@Entity
@Table (name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_ADMIN")
    private boolean isAdmin;

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "EXP_DATE")
    private Date date;

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
