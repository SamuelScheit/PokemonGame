package com.pokemon.game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection connect() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:GameDatabase.db");
            System.out.println("Connected");

        } catch (Exception e) {
            System.out.println(e + "");
        }
        return c;
    }
}
