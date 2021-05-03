package com.gabysanchez.apiJuego.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQL {

    private static DBConnectionSQL dbConnectionSQL = null;
    private Connection connection = null;

    public DBConnectionSQL() throws SQLException {
        String user = "apiJuego2D";
        String password = "apiJuego2D";
        String host = "80.34.34.150";
        String port = "33067";
        String database = "juego_2D";
        connection = DriverManager.getConnection("jdbc:mysql://"+ host +":"+port+"/"+database+"?"+"user="+user+"&password="+password,user,password);
    }

    public static Connection getInstance() throws SQLException{
        if(dbConnectionSQL == null){
            dbConnectionSQL = new DBConnectionSQL();
        }
        return dbConnectionSQL.connection;
    }


}
