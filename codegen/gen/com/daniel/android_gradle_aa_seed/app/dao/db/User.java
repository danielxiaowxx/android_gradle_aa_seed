package com.daniel.android_gradle_aa_seed.app.dao.db;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table USER.
 */
public class User {

    private Long id;
    /** Not-null value. */
    private String username;
    private String password;
    private java.util.Date createDate;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String username, String password, java.util.Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getUsername() {
        return username;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

}
