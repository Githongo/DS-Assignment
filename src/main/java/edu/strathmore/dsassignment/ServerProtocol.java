package edu.strathmore.dsassignment;

import java.util.Random;

public class ServerProtocol {

    private static final String messageInput = SocketServer.messageInput;
    public static String theOutput;
    public static boolean correctOrNotCorrect;

    private String[] clues = { "It's a University", "It's located in Nairobi", "It's precisely in Madaraka" };
    private String answer = "Strathmore";

    public String processInput() {
        if(messageInput==answer){
            theOutput="Congratulations, you have guessed the right message answer";
            correctOrNotCorrect = true;
        }
        else{
            Random r=new Random();
            int randomStringPosition=r.nextInt(clues.length);
            theOutput=clues[randomStringPosition];
            correctOrNotCorrect = false;
        }
        return theOutput;
    }
}
