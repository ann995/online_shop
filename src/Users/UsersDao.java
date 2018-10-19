package Users;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class UsersDao {
    private Connection connection;

    @PostConstruct
    public void init() {
        try {
            String url = "jdbc:mysql://localhost:3306/shop?autoReconnect=true&useSSL=false&serverTimezone=UTC";
            String username = "root";
            String password = "root";

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User userFromRow = resultSetToUser(resultSet);
                users.add(userFromRow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User resultSetToUser(ResultSet resultSet) throws SQLException {
        String login = resultSet.getString("login");
        String password = resultSet.getString("password");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String city = resultSet.getString("city");
        int birthYear = resultSet.getInt("birthYear");
        String role = resultSet.getString("role");

        return new User(login, password, firstName, lastName, city, birthYear, role);
    }

    public User getUserByLogin(String login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ?;");
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSetToUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?,?);");
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getCity());
            preparedStatement.setInt(6, user.getBirthYear());
            preparedStatement.setString(7, user.getRole());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET password = ?, firstName = ?, lastName = ?, city = ?, birthYear = ? WHERE login = ?;");

            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getCity());
            preparedStatement.setInt(5, user.getBirthYear());
            preparedStatement.setString(6, user.getLogin());

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String login) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE login = ?;");

            preparedStatement.setString(1, login);

            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public String getName() {
        return "UsersDao";
    }

    @PreDestroy
    public void clean() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
