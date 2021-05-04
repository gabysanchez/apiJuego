package com.gabysanchez.apiJuego.dao.characters;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.entities.Character;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOCharactersORMTest {

    @BeforeEach
    @AfterEach
    void clearDatabase(){
        DAOFactory.getInstance().getDaoCharactersORM().clear();
    }
    private List<Character> buildCharacters(){
        Character test1 = new Character("test1","#FFFFFF",99);
        Character test2 = new Character("test2","#FFFFFF",99);
        Character test3 = new Character("test3","#FFFFFF",99);
        Character test4 = new Character("test4","#FFFFFF",99);
        return new ArrayList<>(Arrays.asList(test1,test2,test3,test4));
    }

    @Test
    void add() {
        Character expected = new Character("test","#FFFFFF",99);
        DAOFactory.getInstance().getDaoCharactersORM().add(expected);
        Character character = DAOFactory.getInstance().getDaoCharactersORM().get(expected.getNombre());
        assertEquals(expected.getNombre(),character.getNombre());
    }

    @Test
    void update() {
        Character expected = new Character("test","#FFFFFF",99);
        DAOFactory.getInstance().getDaoCharactersORM().add(expected);
        expected.setSalud(0);
        DAOFactory.getInstance().getDaoCharactersORM().update(expected);
        Character character = DAOFactory.getInstance().getDaoCharactersORM().get(expected.getNombre());
        assertEquals(expected.getSalud(),character.getSalud());
    }

    @Test
    void delete() {
        Character expected = new Character("test","#FFFFFF",99);
        DAOFactory.getInstance().getDaoCharactersORM().add(expected);
        DAOFactory.getInstance().getDaoCharactersORM().delete(expected);
        Character character = DAOFactory.getInstance().getDaoCharactersORM().get(expected.getNombre());
        assertEquals(null,character);
    }


    @Test
    void get() {
        List<Character> expected = buildCharacters();
        for (Character character : expected){
            DAOFactory.getInstance().getDaoCharactersORM().add(character);
        }
        List<Character> characters = DAOFactory.getInstance().getDaoCharactersORM().get();
        assertEquals(expected.size(),characters.size());
    }

    @Test
    void getPaged() {
        List<Character> expected = buildCharacters();
        for (Character character : expected){
            DAOFactory.getInstance().getDaoCharactersORM().add(character);
        }
        List<Character> characters = DAOFactory.getInstance().getDaoCharactersORM().getPaged(0);
        assertEquals(expected.size(),characters.size());
    }

}