package com.gabysanchez.apiJuego.db;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DBConnectionORM {

    private static DBConnectionORM dbConnection = null;
    private ConnectionSource connection = null;

    public DBConnectionORM(String databaseName) throws SQLException {
        //datos personalizados para cada BD, usuario, etc.
        String user = "apiJuego2D";
        String password = "apiJuego2D";
        String host = "80.34.34.150";
        String port = "33067";
        String database = databaseName;
        connection = new JdbcConnectionSource("jdbc:mysql://"+ host +":"+port+"/"+database+"?"+"user="+user+"&password="+password,user,password);
    }

    public static ConnectionSource getInstance() throws SQLException{
        if(dbConnection == null){
            dbConnection = new DBConnectionORM("juego_2D");
        }
        return dbConnection.connection;
    }
    public static ConnectionSource getInstanceTest() throws SQLException{
        if(dbConnection == null){
            dbConnection = new DBConnectionORM("juego_2D_Test");
        }
        return dbConnection.connection;
    }


}