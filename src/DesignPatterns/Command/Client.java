package DesignPatterns.Command;

import java.util.logging.Logger;

/**
 * Client -> Invoker -> Command -> Receiver
 * Command Design Pattern : turns a request as an object
 * allowing you to parameterize clients with different requests,
 * queue or log operations, and support undo/redo.
 */
public class Client {

    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        RemoteControl remoteControl = new RemoteControl();
        Command commandON = new LightOnCommand(livingRoomLight);
        Command commandOFF = new LightOffCommand(livingRoomLight);

        remoteControl.setCommand(commandON);
        remoteControl.pressButton();

        remoteControl.setCommand(commandOFF);
        remoteControl.pressButton();
    }

}
