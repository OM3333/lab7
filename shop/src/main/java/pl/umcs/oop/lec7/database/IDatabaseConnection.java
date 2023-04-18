package pl.umcs.oop.lec7.database;

import java.sql.Connection;

public interface IDatabaseConnection {


    public static Connection getConnection() {
        return null;
    }

    public static void connect(){

    }

    public static void disconnect(){

    }


}
