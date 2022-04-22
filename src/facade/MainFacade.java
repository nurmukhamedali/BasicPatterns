//package facade;
//
//class TextEditor{
//    public void deepIntelligence(){
//        System.out.println("Deep Intelligence");
//    }
//    public void autoSave(){
//        System.out.println("Auto Save");
//    }
//}
//class Compiler{
//    public void compile(){
//        System.out.println("Compile");
//    }
//}
//class JVM{
//    public void execute(){
//        System.out.println("Execute");
//    }
//}
//public class MainFacade{
//    TextEditor textEditor;
//    Compiler compiler;
//    JVM jvm;
//
//    public MainFacade(TextEditor textEditor, Compiler compiler, JVM jvm){
//        this.textEditor = textEditor;
//        this.compiler = compiler;
//        this.jvm = jvm;
//    }
//
//    public void run(){
//        textEditor.deepIntelligence();
//        textEditor.autoSave();
//        compiler.compile();
//        jvm.execute();
//    }
//}
//class Main{
//    public static void main(String[] args) {
//        MainFacade facade = new MainFacade(new TextEditor(), new Compiler(), new JVM());
//        facade.run();
//    }
//}