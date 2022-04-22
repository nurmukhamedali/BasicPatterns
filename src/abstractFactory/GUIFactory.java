package abstractFactory;
interface Button{
    void paint();
}
interface Checkbox{
    void paint();
}
class MacButton implements Button{
    @Override
    public void paint() {
        System.out.printf("Created: %s", getClass().getSimpleName());
    }
}
class WindowsButton implements Button{
    @Override
    public void paint() {
        System.out.printf("Created: %s", getClass().getSimpleName());
    }
}

class MacCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.printf("Created: %s", getClass().getSimpleName());
    }
}
class WindowsCheckbox implements Checkbox{
    @Override
    public void paint() {
        System.out.printf("Created: %s", getClass().getSimpleName());
    }
}

interface GUIFactory{
    Button createButton();
    Checkbox createCheckBox();
}
class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new MacCheckbox();
    }
}

class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new WindowsCheckbox();
    }
}
class Application{
    private Button button;
    private Checkbox checkbox;
    public Application(GUIFactory factory){
        this.checkbox = factory.createCheckBox();
        this.button = factory.createButton();
    }
    public void paint(){
        button.paint();
        checkbox.paint();
    }
}
class Demo{
    private static Application configureApplication(){
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")){
            factory = new MacFactory();
        } else factory = new WindowsFactory();
        return new Application(factory);
    }

    public static void main(String[] args) {
        Application application = configureApplication();
        application.paint();
    }
}
