package com.gabysanchez.apiJuego.entities;

public class User {
    private int _id;
    private String email;
    private String password;
    private String alias;
    private Character character;

    public User(int _id, String email, String password, String alias) {
        this._id = _id;
        this.email = email;
        this.password = password;
        this.alias = alias;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
