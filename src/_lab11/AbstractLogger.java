package _lab11;

public abstract class AbstractLogger {
    protected static int INFO = 1;
    protected static int DEBUG = 2;
    protected static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger){
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message) {
        if(this.level <= level){
            write(message);
        }
        if(nextLogger != null){
            nextLogger.logMessage(level, message);
        }
    }
    public abstract void write(String message);
}
class ConsoleLogger extends AbstractLogger{
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Standard Console::Logger: " + message + "...");
    }
}
class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("Error Console::Logger: " + message + "...");
    }
}
class FileLogger extends AbstractLogger{
    public FileLogger(int level){
        this.level = level;
    }

    @Override
    public void write(String message) {
        System.out.println("File::Logger: " + message + "...");
    }
}

class ChainPatternDemo{
    private static AbstractLogger getChainOfLogger(){
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
    public static void main(String[] args){
        AbstractLogger logger = getChainOfLogger();

        logger.logMessage(AbstractLogger.INFO, "This is an information");
        logger.logMessage(AbstractLogger.DEBUG, "This is a debug level information");
        logger.logMessage(AbstractLogger.ERROR, "This is an error information");
    }
}


