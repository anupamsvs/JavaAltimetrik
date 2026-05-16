package DesignPatterns.Command;

import java.util.HashSet;
import java.util.Set;

/**
 * Client -> Invoker -> Command -> Receiver
 * Command Design Pattern : turns a request as an object
 * allowing you to parameterize clients with different requests,
 * queue or log operations, and support undo/redo.
 */
public class Client {

    public static void main(String[] args) {

        String s1 = new String("hello");
        String s2 = "hello";

        Set<String> hs = new HashSet<>();
        hs.add(s1);
        hs.add(s2);
        System.out.println(hs.size());

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
