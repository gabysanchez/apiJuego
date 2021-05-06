package com.gabysanchez.apiJuego.dao.players;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.encryptors.EncryptionCesar;
import com.gabysanchez.apiJuego.entities.Player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOPlayerORMTest {
    @BeforeEach
    @AfterEach
    void clearDatabase(){
        DAOFactory.getInstance().getDAOPlayerORM().clear();
    }

    private List<Player> buildPlayers(){
        Player test1 = new Player("test1", EncryptionCesar.getInstance().ecode("password"), "hombre","ES",99,null);
        Player test2 = new Player("test2",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",99,null);
        Player test3 = new Player("test3",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",99,null);
        Player test4 = new Player("test4",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",99,null);
        return new ArrayList<>(Arrays.asList(test1,test2,test3,test4));
    }

    @Test
    void add() {
        Player expected = new Player("test",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",99,null);
        DAOFactory.getInstance().getDAOPlayerORM().add(expected);
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(expected.getAlias());
        assertEquals(expected.getAlias(),player.getAlias());
    }

    @Test
    void update() {
        Player expected = new Player("test",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",99,null);
        DAOFactory.getInstance().getDAOPlayerORM().add(expected);
        expected.setEdad(0);
        DAOFactory.getInstance().getDAOPlayerORM().update(expected);
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(expected.getAlias());
        assertEquals(expected.getEdad(),player.getEdad());
    }

    @Test
    void delete() {
        Player expected = new Player("test",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",99,null);
        DAOFactory.getInstance().getDAOPlayerORM().add(expected);
        DAOFactory.getInstance().getDAOPlayerORM().delete(expected);
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(expected.getAlias());
        assertEquals(null,player);
    }

    @Test
    void get() {
        List<Player> expectid = buildPlayers();
        for (Player player:expectid){
            DAOFactory.getInstance().getDAOPlayerORM().add(player);
        }
        List<Player> players = DAOFactory.getInstance().getDAOPlayerORM().get();
        assertEquals(expectid.size(),players.size());
    }

    @Test
    void getPaged() {
        List<Player> expectid = buildPlayers();
        for (Player player:expectid){
            DAOFactory.getInstance().getDAOPlayerORM().add(player);
        }
        List<Player> players = DAOFactory.getInstance().getDAOPlayerORM().getPaged(0);
        assertEquals(expectid.size(),players.size());
    }
}