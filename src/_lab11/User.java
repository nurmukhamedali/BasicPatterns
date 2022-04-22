package _lab11;

import java.util.UUID;

enum Role{
    ADMIN,
    USER,
    MODERATOR
}
public class User {
    private final String uniqueID = UUID.randomUUID().toString();
    private Role role;
    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.USER;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return this.role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniqueID() {
        return uniqueID;
    }

}
