package com.gabysanchez.apiJuego.dao.tikets;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.entities.Character;
import com.gabysanchez.apiJuego.entities.UserTiket;
import org.junit.jupiter.api.Test;

class DAOUserTiketTest {

    @Test
    void add() {
        /*
        Character character = new Character("test1","#FFFFFF",99);
        UserTiket userTiket = new UserTiket(1,"hola");
        userTiket.add(character);
        DAOFactory.getInstance().getDaoUserTiket().add(userTiket);

         */
    }

    @Test
    void delete() {
        DAOFactory.getInstance().getDaoUserTiket().delete(DAOFactory.getInstance().getDaoUserTiket().get(2));
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
        System.out.println(DAOFactory.getInstance().getDaoUserTiket().get());
    }

    @Test
    void testGet() {
    }

    @Test
    void save() {
    }
}