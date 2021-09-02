package edu.strathmore.dsassignment;

import java.util.Objects;
import java.util.Random;

public class ServerProtocol {

    public static String theOutput;
    public static boolean correctOrNotCorrect;

    private static String[] clues = { "Message Clue: It's a University", "Message clue: It's located in Nairobi", "Message clue: It's precisely in Madaraka" };
    private static String answer = "Strathmore";

    public static  String processInput() {

        if(Objects.equals(SocketServer.messageInput, answer)){
            theOutput="Congratulations!, that's the secret message :)";
            correctOrNotCorrect = true;
        }
        else{
            Random r=new Random();
            int randomStringPosition=r.nextInt(clues.length);
            theOutput=clues[randomStringPosition];
            correctOrNotCorrect = false;
        }
        return  theOutput;

    }
}
