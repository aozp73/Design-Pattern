package behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Command interface
interface Command {
    void execute();
    void undo();
}

// ConcreteCommand
class AssignJobCommand implements Command {
    private Job job;
    private Worker worker;

    public AssignJobCommand(Job job, Worker worker) {
        this.job = job;
        this.worker = worker;
    }

    @Override
    public void execute() {
        worker.assignJob(job);
    }

    @Override
    public void undo() {
        worker.removeJob(job);
    }
}

// Job class
class Job {
    private String name;

    public Job(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Worker class
class Worker {
    private String name;
    private List<Job> jobs = new ArrayList<>();

    public Worker(String name) {
        this.name = name;
    }

    public void assignJob(Job job) {
        jobs.add(job);
        System.out.println("Job " + job.getName() + " assigned to worker " + name);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
        System.out.println("Job " + job.getName() + " removed from worker " + name);
    }
}

// Invoker
class Invoker {
    private Stack<Command> commandStack = new Stack<>();

    public void queueCommand(Command command) {
        commandStack.push(command);
    }

    public void executeCommand() {
        if(!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.execute();
        }
    }

    public void undoCommand() {
        if(!commandStack.isEmpty()) {
            Command command = commandStack.pop();
            command.undo();
        }
    }
}


public class CommandPatternEx01 {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        Worker worker = new Worker("John");
        Job job1 = new Job("Clean");
        Job job2 = new Job("Repair");

        Command command1 = new AssignJobCommand(job1, worker);
        Command command2 = new AssignJobCommand(job2, worker);

        invoker.queueCommand(command1);
        invoker.queueCommand(command2);

        invoker.executeCommand(); // Assign job2 to worker John
        invoker.executeCommand(); // Assign job1 to worker John
        // 취소하고 싶다면 undo가능
        // invoker.undoCommand(); // Remove job1 from worker John
        // invoker.undoCommand(); // Remove job2 from worker John
    }
}

