package com.gabysanchez.apiJuego.dao;

import com.gabysanchez.apiJuego.dao.characters.DAOCharactersORM;
import com.gabysanchez.apiJuego.dao.players.DAOPlayerORM;
import com.gabysanchez.apiJuego.dao.token.DAOUserToken;

import java.sql.SQLException;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOPlayerORM daoPlayerORM;
    private DAOCharactersORM daoCharactersORM;
    private DAOUserToken daoUserToken;

    private DAOFactory(){}

    public static DAOFactory getInstance() {
        if(daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public DAOPlayerORM getDAOPlayerORM() {
        if(daoPlayerORM == null){
            try {
                daoPlayerORM = new DAOPlayerORM();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return daoPlayerORM;
    }
    public DAOCharactersORM getDaoCharactersORM() {
        if(daoCharactersORM == null){
            try {
                daoCharactersORM = new DAOCharactersORM();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return daoCharactersORM;
    }


    public DAOUserToken getDAOUserToken() {
        if(daoUserToken == null){
            daoUserToken = new DAOUserToken();
        }
        return daoUserToken;
    }
}
