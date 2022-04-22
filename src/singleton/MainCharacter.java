package singleton;
public class MainCharacter{
    private static MainCharacter character;
    private static String name;
    static {
        character = new MainCharacter();
        name = "Superman";
    }
    private  MainCharacter(){}
    public static MainCharacter getCharacter(){
        return character;
    }
    public static String getName(){
        return name;
    }
}
////////////////////////////////////////
