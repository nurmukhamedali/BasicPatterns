package facade;

import java.util.Scanner;

class TextEditor{
    Scanner in = new Scanner(System.in);
    private String text, name;
    public void createProject(){
        // TODO creating project like open new file
        System.out.println("Enter name of the project: ");
        name = in.nextLine();
        System.out.println("project created");
        System.out.println("Enter code:");
        text = in.nextLine();
    }
    public void saveProject(){
        // TODO saving project
        System.out.println("project saving...");
    }
    public String getName(){
        return this.name;
    }
    public String getText(){
        return this.text;
    }
}
class Compiler{
    public void compile(TextEditor textEditor){
        System.out.println("Compiling " + textEditor.getName());
    }
}
class CLR{
    public void execute(TextEditor textEditor){
        System.out.println("Executing " + textEditor.getClass() + "/" + textEditor.getName());
        System.out.println(textEditor.getText());
    }
    public void finish(TextEditor textEditor){
        System.out.println("Finish " + textEditor.getClass() + "/" + textEditor.getName());
    }
}
class VisualStudioFacade{
    TextEditor textEditor;
    Compiler compiler;
    CLR clr;
    public VisualStudioFacade(){
        this.textEditor = new TextEditor();
        this.compiler = new Compiler();
        this.clr = new CLR();
    }
    public void startProgram(){
        textEditor.createProject();
        textEditor.saveProject();
        compiler.compile(textEditor);
        clr.execute(textEditor);
    }
    public void stopProgram(){
        clr.finish(textEditor);
    }
}
class UserInterface{
    public static void main(String[] args) {
        VisualStudioFacade facade = new VisualStudioFacade();
        facade.startProgram();
        facade.stopProgram();
    }
}