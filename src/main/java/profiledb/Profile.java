package profiledb;

public class Profile {
    private int id;
    private String name;
    private String surname;
    private String password;
    private String username;

    // Get methods

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Set methods

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }
}