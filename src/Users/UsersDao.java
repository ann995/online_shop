package Users;

import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    private static List<User> usersList = new ArrayList<>();

    public static List<User> getAllUsers(){
        return usersList;
    }

    public static User getUserByLogin(String login){
        User user = usersList.stream().filter(c -> c.getLogin().equals(login)).findFirst().orElse(null);
        return user;
    }

    public static void addUser(User userToAdd){
        usersList.add(userToAdd);
    }

    static{
        usersList.add(new User("admin","admin","admmin","admin","Wroclaw",2018,"ADMIN"));
        usersList.add(new User("tkowal","kowal123","Tomasz","Kowalski","Wroclaw",1993,"USER"));
        usersList.add(new User("jnowak","nowak123","Jan","Nowak","Krakow",1987,"USER"));
    }


}
