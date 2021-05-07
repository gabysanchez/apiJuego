package com.gabysanchez.apiJuego.dao.token;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import org.junit.jupiter.api.Test;

class DAOUserTokenTest {

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
        DAOFactory.getInstance().getDAOUserToken().delete(DAOFactory.getInstance().getDAOUserToken().get(2));
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
        System.out.println(DAOFactory.getInstance().getDAOUserToken().get());
    }

    @Test
    void testGet() {
    }

    @Test
    void save() {
    }
}