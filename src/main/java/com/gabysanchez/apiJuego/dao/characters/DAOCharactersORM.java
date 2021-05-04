package com.gabysanchez.apiJuego.dao.characters;

import com.gabysanchez.apiJuego.dao.DAOOperations;
import com.gabysanchez.apiJuego.db.DBConnectionORM;
import com.gabysanchez.apiJuego.entities.Character;
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
        try {
            daoCharacterORM.create(character);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Character character) {
        try {
            daoCharacterORM.update(character);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Character character) {
        try {
            daoCharacterORM.delete(character);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            daoCharacterORM.delete(get());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Character> get() {
        List<Character>characters=null;
        try {
            characters=daoCharacterORM.queryForAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return characters;
    }

    @Override
    public List<Character> getPaged(int page) {
        List<Character>characters = null;
        try {
            List<Character> characterAll = daoCharacterORM.queryForAll();
            int maxSize = characterAll.size();
            int minIndex = page * 10;
            int maxIndex = (page+1)*10;
            if(minIndex < maxSize && maxIndex < maxSize){
                characters = characterAll.subList(minIndex,maxIndex);
            }
            else if (maxIndex > maxSize){
                characters = characterAll.subList(minIndex,maxSize);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return characters;
    }

    @Override
    public Character get(String s) {
        Character character = null;
        try {
            character = daoCharacterORM.queryForId(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return character;
    }
}
