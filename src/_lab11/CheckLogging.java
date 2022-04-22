package _lab11;


import java.util.Objects;
import java.util.Scanner;

enum StageType{
    Authentication(1),
    Authorization(2),
    Validation(3);

    public final int level;
    private StageType(int level){
        this.level = level;
    }
}
abstract class Stage {
    Scanner in = PersonalScanner.getConsoleScanner();
    private User currentUser;
    private int level;
    private Stage nextStage;
    public void setNextStage(Stage stage){
        this.nextStage = stage;
    }

    public void trackStage(int level, boolean lastResult){
        boolean currentResult = lastResult;
        if((this.level <= level) && lastResult){
            currentResult = verify();
        }
        if(this.nextStage != null){
            this.nextStage.trackStage(level, currentResult);
        }
    }
    public void setCurrentUser(User user){
        Data.getInstance().setCurrentUser(user);
        this.currentUser = user;
    }

    public User getCurrentUser() {
        return Data.getInstance().getCurrentUser();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract boolean verify();
}
class AuthenticationStage extends Stage{
    public AuthenticationStage(int level) {
        setLevel(level);
    }

    @Override
    public boolean verify() {
        System.out.println("Enter username: ");
        String username = in.nextLine();
        System.out.println("Enter password: ");
        String password = in.nextLine();
        Data data = Data.getInstance();
        setCurrentUser(data.userInList(username, password));
        boolean isContinue = !Objects.isNull(getCurrentUser());

        return isContinue;
    }
}
class AuthorizationStage extends Stage{
    public AuthorizationStage(int level){
        setLevel(level);
    }

    @Override
    public boolean verify() {
        User user = getCurrentUser();

        if (user.getRole() == Role.ADMIN){
            System.out.println("Bonjour, " + user.getUsername());
            System.out.println("You're admin");
            return true;
        }
        else if (user.getRole() == Role.USER) {
            System.out.println("Hello, " + user.getUsername());
            System.out.println("You're user");
            return true;
        }
        else{
            System.out.println("You're unknown");
            return false;
        }
    }
}
class ValidationStage extends Stage{
    public ValidationStage(int level){
        setLevel(level);
    }

    @Override
    public boolean verify() {
        User user = getCurrentUser();
        if (user.getUsername() instanceof String && user.getPassword() instanceof String){
            System.out.println("Valid username");
            return true;
        }
        else {
            System.out.println("Validation Error");
            return false;
        }

    }
}

class VerificationSystem{
    private static Stage getChainOfStages(){
        Stage authenticationStage = new AuthenticationStage(StageType.Authentication.level);
        Stage authorizationStage = new AuthorizationStage(StageType.Authorization.level);
        Stage validationStage = new ValidationStage(StageType.Validation.level);

        authenticationStage.setNextStage(authorizationStage);
        authorizationStage.setNextStage(validationStage);
        return authenticationStage;
    }
    public static Data addUsers(Data db){

        User new_user = new User("Ali", "Ali");
        new_user.setRole(Role.ADMIN);
        User new_user1 = new User("Adolf", "Adolf");
        new_user1.setRole(Role.USER);
        User new_user2 = new User("Ron", "Ron");
        new_user1.setRole(Role.USER);
        db.setUser(new_user);
        db.setUser(new_user1);
        db.setUser(new_user2);

        return db;
    }
    public static void main(String[] args){
        Stage verificationStage = getChainOfStages();

        Data db = addUsers(Data.getInstance());
        verificationStage.trackStage(StageType.Authorization.level,  true);
        verificationStage.trackStage(StageType.Validation.level, true);
    }
}

