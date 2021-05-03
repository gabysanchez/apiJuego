package com.gabysanchez.apiJuego.dao.players;

import com.gabysanchez.apiJuego.dao.DAOOperations;
import com.gabysanchez.apiJuego.db.DBConnectionORM;
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


    }

    @Override
    public void update(Player player) {

    }

    @Override
    public void delete(Player player) {

    }

    @Override
    public void clear() {

    }

    @Override
    public List<Player> get() {
        return null;
    }

    @Override
    public List<Player> getPaged(int page) {
        return null;
    }

    @Override
    public Player get(String s) {
        return null;
    }
}
