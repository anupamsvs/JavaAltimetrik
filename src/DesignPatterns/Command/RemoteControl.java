package DesignPatterns.Command;

public class RemoteControl {
    private Command command;

    public void pressButton() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
