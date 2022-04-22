package _lab11;

import java.util.ArrayList;

public class Data {
    private static Data instance;
    private User currentUser;
    private ArrayList<User> userList = new ArrayList<>();

    static {
        instance = new Data();
    }
    private Data(){}
    public static Data getInstance(){
        return instance;
    }

    public void setUser(User user) {
        userList.add(user);
    }

    public void setCurrentUser(User user){
        this.currentUser = user;
    }
    public User getCurrentUser(){
        return this.currentUser;
    }
    public User getUser(int index){
        return userList.get(index);
    }

    public User userInList(String username, String password){
        for(User user: userList){
            String name = user.getUsername();
            String pwd = user.getPassword();
            if(name.equals(username) &&
                    pwd.equals(password)
            ){
                return user;
            }
        }
        System.out.println("Hey, " + username + "You're not registered in system.");
        return null;
    }

    public ArrayList<User> getUserList(User user) {
        if(userList.contains(user)){
            if(user.getRole() == Role.ADMIN){
                return userList;
            }
        }
        System.err.println("You don't have permissions");
        return null;
    }
}
