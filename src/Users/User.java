package Users;

public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String city;
    private int birthYear;
    private String role;

    public User(String login, String password, String firstName, String secondName, String city, int birthYear, String role) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = secondName;
        this.city = city;
        this.birthYear = birthYear;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
