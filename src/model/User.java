package model;

public class User {

    private int userId;
    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private String role;

    public User() {
    }

    public User(int userId, String userName, String password, String firstname, String lastname, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRoll(String role) {
        this.role = role;
    }


}
