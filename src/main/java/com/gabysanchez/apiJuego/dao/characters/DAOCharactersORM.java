package com.gabysanchez.apiJuego.dao.characters;

import com.gabysanchez.apiJuego.dao.DAOOperations;
import com.gabysanchez.apiJuego.db.DBConnectionORM;
import com.gabysanchez.apiJuego.entities.Player;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class DAOCharactersORM implements DAOOperations<Character,String> {

    Dao<Character, String> daoCharacterORM;

    public DAOCharactersORM() throws SQLException {
        this.daoCharacterORM = DaoManager.createDao(
                DBConnectionORM.getInstanceTest(),
                Character.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstanceTest(),
                daoCharacterORM);
    }

    @Override
    public void add(Character character) {


    }

    @Override
    public void update(Character character) {

    }

    @Override
    public void delete(Character character) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<Character> get() {
        return null;
    }

    @Override
    public List<Character> getPaged(int page) {
        return null;
    }

    @Override
    public Character get(String s) {
        return null;
    }
}
