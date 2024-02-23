package kz.bitlab.shop.users.service;

import kz.bitlab.shop.DBManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService extends DBManager {

    public static Long login(String email, String password) {
        Long id = null;
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "select id from users where email = ? and password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getLong("id");
            }

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

}
