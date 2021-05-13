package com.gabysanchez.apiJuego.dao.players;

import com.gabysanchez.apiJuego.dao.DAOFactory;
import com.gabysanchez.apiJuego.encryptors.EncryptionCesar;
import com.gabysanchez.apiJuego.entities.Data;
import com.gabysanchez.apiJuego.entities.Player;

import com.j256.ormlite.field.types.SqlDateType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DAOPlayerORMTest {
    @BeforeEach
    @AfterEach
    void clearDatabase(){
        DAOFactory.getInstance().getDAOPlayerORM().clear();
    }

    private List<Player> buildPlayers(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Player test1 = new Player("test1", EncryptionCesar.getInstance().ecode("password"), "hombre","ES",date,null);
        Player test2 = new Player("test2",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",date,null);
        Player test3 = new Player("test3",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",date,null);
        Player test4 = new Player("test4",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",date,null);
        return new ArrayList<>(Arrays.asList(test1,test2,test3,test4));
    }

    @Test
    void add() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Player expected = new Player("test",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",date,null);
        DAOFactory.getInstance().getDAOPlayerORM().add(expected);
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(expected.getAlias());
        assertEquals(expected.getAlias(),player.getAlias());
    }

    @Test
    void update() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Player expected = new Player("test",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",date,null);
        DAOFactory.getInstance().getDAOPlayerORM().add(expected);
        expected.setPais("FR");
        DAOFactory.getInstance().getDAOPlayerORM().update(expected);
        Player player = DAOFactory.getInstance().getDAOPlayerORM().get(expected.getAlias());
        assertEquals(expected.getPais(),player.getPais());
    }

    @Test
    void delete() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Player expected = new Player("test",EncryptionCesar.getInstance().ecode("password"),"hombre","ES",date,null);
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