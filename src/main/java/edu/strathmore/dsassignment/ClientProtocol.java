package edu.strathmore.dsassignment;

import edu.strathmore.dsassignment.SocketServer;
import java.io.*;

public class ClientProtocol {
    public static boolean correctness = ServerProtocol.correctOrNotCorrect;
    public static void processInput() {
        if(!correctness){
            ClientApplication.main(null);
        }

    }
}
