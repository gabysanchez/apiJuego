package com.gabysanchez.apiJuego.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.gabysanchez.apiJuego.dao.DAOFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@JacksonXmlRootElement(localName = "userTiket")
public class UserTiket {

    public static Integer nextId = 1;


    @JacksonXmlProperty(isAttribute = true)
    private int _id;
    @JacksonXmlProperty(isAttribute = true)
    private String alias;

    @JacksonXmlElementWrapper(localName = "characters")
    @JacksonXmlProperty(localName = "character")
    private List<Character> characters;

    public UserTiket() { }

    public UserTiket(int _id, String alias) {
        this._id = _id;
        this.alias = alias;

    }

    public void startTime(){
        new Timer().schedule( new java.util.TimerTask() {
            @Override public void run() {
                System.out.println("delete tiket: "+_id);
                DAOFactory.getInstance().getDaoUserTiket().delete(DAOFactory.getInstance().getDaoUserTiket().get(_id));
            }
        }, 15000 );
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

    public void add(Character character){
        if(this.characters == null){
            this.characters = new ArrayList<>();
        }
        characters.add(character);
    }
}
