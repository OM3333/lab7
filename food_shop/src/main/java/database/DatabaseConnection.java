package database;

import pl.umcs.oop.lec7.database.IDatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection implements IDatabaseConnection {
    private Connection connection;

    public Connection getConnection(){
        return connection;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void disconnect(){
        try{
            connection.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }


}
