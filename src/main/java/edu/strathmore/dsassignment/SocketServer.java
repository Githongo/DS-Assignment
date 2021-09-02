package edu.strathmore.dsassignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {
    //static ServerSocket variable
    private static ServerSocket server;
    //socket server port on which it will listen
    private static int port = 9876;
    public static String messageInput = null;


    public static void main(String args[]) throws IOException, ClassNotFoundException{
        //create the socket server object
        server = new ServerSocket(port);

        //keep listens indefinitely until receives 'exit' call or program terminates
        while(true){
            System.out.println("Waiting for the client request");
            //creating socket and waiting for client connection
            Socket socket = server.accept();
            //read from socket to ObjectInputStream object
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            //convert ObjectInputStream object to String
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);

            if(message.equalsIgnoreCase("end")){
                //create ObjectOutputStream object
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                //write object to Socket if the end of input messages is reached
                oos.writeObject("Well recieved!");
                oos.close();
            }
            else{
                String splitted[] =message.split(":"); // split incoming streams into key value pairs

                /*
                * Display out sent data: continue from here */

                System.out.println("Key: "+splitted[0]+", Value: "+splitted[1]);
                messageInput = splitted[1];
                //printing whether the user has guessed the right message answer or giving hints to retry
                System.out.println(ServerProtocol.theOutput);

            }
            //close resources
            ois.close();
            socket.close();
            //terminate the server if client sends exit request
            if(message.equalsIgnoreCase("exit")) break;
        }
        System.out.println("Shutting down Socket server!!");
        //close the ServerSocket object
        server.close();
    }
}
