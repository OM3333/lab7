import database.DatabaseConnection;
import pl.umcs.oop.lec7.auth.AccountManager;
import pl.umcs.oop.lec7.shop.Account;
import pl.umcs.oop.lec7.shop.Cart;
import pl.umcs.oop.lec7.shop.Product;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static Account login(AccountManager accountManager, String name, String password) {
        if(accountManager.login("alice", "secret"))
            return new Account("alice");
        else
            throw new RuntimeException("Wrong credentials");
    }

    public static void main(String[] args) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        AccountManager accountManager = new AccountManager(databaseConnection);
        try{
            var account = accountManager.getUser("test");
            System.out.println(account);
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}