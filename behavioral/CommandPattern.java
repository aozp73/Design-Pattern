package behavioral;

// Command interface
interface Command2 {
    void execute();
}

// Concrete Commands
class StartCommand implements Command2 {
    private Engine engine;

    public StartCommand(Engine engine) {
        this.engine = engine;
    }

    public void execute() {
        engine.start();
    }
}

class StopCommand implements Command2 {
    private Engine engine;

    public StopCommand(Engine engine) {
        this.engine = engine;
    }

    public void execute() {
        engine.stop();
    }
}

// Receiver class
class Engine {
    public void start() {
        System.out.println("Engine started.");
    }

    public void stop() {
        System.out.println("Engine stopped.");
    }
}

// Invoker class
class Car {
    private Command2 startCommand;
    private Command2 stopCommand;

    public Car(Command2 startCommand, Command2 stopCommand) {
        this.startCommand = startCommand;
        this.stopCommand = stopCommand;
    }

    public void startEngine() {
        startCommand.execute();
    }

    public void stopEngine() {
        stopCommand.execute();
    }
}

// Client class
public class CommandPattern {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Command2 startCommand = new StartCommand(engine);
        Command2 stopCommand = new StopCommand(engine);

        Car car = new Car(startCommand, stopCommand);
        
        car.startEngine();
        car.stopEngine();
    }
}

