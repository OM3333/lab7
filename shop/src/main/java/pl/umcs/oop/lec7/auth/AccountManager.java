package pl.umcs.oop.lec7.auth;

import pl.umcs.oop.lec7.database.IDatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManager {
    Map<String, Account> accounts = new HashMap<>();
    IDatabaseConnection databaseConnection;

    public AccountManager(IDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }


    public Account getUser(String name) throws SQLException {
        PreparedStatement preparedStatement = databaseConnection.getConnection().prepareStatement("SELECT ID FROM USERS WHERE NAME = ?;");
        preparedStatement.setString(1,name);
        preparedStatement.execute();
        preparedStatement.getResultSet();
        return resultSetToList(preparedStatement.getResultSet()).get(0);
    }

    public List<Account> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Account> result = new ArrayList<>();
        while(resultSet.next()){
            String name = resultSet.getString("NAME");
            String password = resultSet.getString("PASSWORD");
            Account account = new Account(name, password);
            result.add(account);
        }
        return result;

    }

    public boolean register(String name, String password) {
        if(accounts.containsKey(name))
            return false;
        else {
            accounts.put(name, new Account(name, password));
            return true;
        }
    }

    public boolean login(String name, String password) {
        if(!accounts.containsKey(name))
            return false;
        else
            return accounts.get(name).authenticate(name, password);
    }
}
