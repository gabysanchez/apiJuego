package com.gabysanchez.apiJuego.dao.players;

import com.gabysanchez.apiJuego.dao.DAOOperations;
import com.gabysanchez.apiJuego.db.DBConnectionORM;
import com.gabysanchez.apiJuego.encryptors.EncryptionCesar;
import com.gabysanchez.apiJuego.entities.Character;
import com.gabysanchez.apiJuego.entities.Player;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

import java.sql.SQLException;
import java.util.List;

public class DAOPlayerORM implements DAOOperations<Player,String> {

    Dao<Player, String> daoPlayerORM;

    public DAOPlayerORM() throws SQLException {
        this.daoPlayerORM = DaoManager.createDao(
                DBConnectionORM.getInstanceTest(),
                Player.class
        );
        DaoManager.registerDao(
                DBConnectionORM.getInstanceTest(),
                daoPlayerORM);
    }

    @Override
    public void add(Player player) {
        player.setPassword(EncryptionCesar.getInstance().ecode(player.getPassword()));
        try {
            daoPlayerORM.create(player);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(Player player) {
        player.setPassword(EncryptionCesar.getInstance().ecode(player.getPassword()));
        try {
            daoPlayerORM.update(player);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void delete(Player player) {
        player.setPassword(EncryptionCesar.getInstance().ecode(player.getPassword()));
        try {
            daoPlayerORM.delete(player);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void clear() {
        try {
            daoPlayerORM.delete(get());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Player> get() {
        List<Player> players = null;
        try {
            players = daoPlayerORM.queryForAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Player player:players){
            //player.setPassword(EncryptionCesar.getInstance().decode(player.getPassword()));
            player.setPassword(null);
        }
        return players;
    }

    @Override
    public List<Player> getPaged(int page) {
        List<Player>players = null;
        try {
            List<Player> playersAll = daoPlayerORM.queryForAll();
            int maxSize = playersAll.size();
            int minIndex = page * 10;
            int maxIndex = (page+1)*10;
            if(minIndex < maxSize && maxIndex < maxSize){
                players = playersAll.subList(minIndex,maxIndex);
            }
            else if (maxIndex > maxSize){
                players = playersAll.subList(minIndex,maxSize);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Player player:players){
            player.setPassword(EncryptionCesar.getInstance().decode(player.getPassword()));
        }
        return players;
    }

    @Override
    public Player get(String s) {
        Player player = null;
        try {
            player = daoPlayerORM.queryForId(s);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (player!=null){
            player.setPassword(EncryptionCesar.getInstance().decode(player.getPassword()));
        }
        return player;
    }
}
