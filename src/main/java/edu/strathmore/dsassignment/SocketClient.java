package edu.strathmore.dsassignment;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

public class SocketClient {
    /*
    * public socketClient(Hashmap) returns String socketServer response
    * */
    public static void socketClient(HashMap detailsMap) throws IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;

        //prints map
        detailsMap.forEach((k, v) -> System.out.println(k + " : " + v));



        for(int i=0; i< detailsMap.size();i++){
            //establish socket connection to server
            socket = new Socket(host.getHostName(), 9876);
            //write to socket using ObjectOutputStream
            oos = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Sending request to Socket Server");

            Object key = detailsMap.keySet().toArray()[i];
            Object value = detailsMap.get(key);


            oos.writeObject(key+":"+value);

        }

        socket = new Socket(host.getHostName(), 9876);
        //write to socket using ObjectOutputStream
        oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("end");

        //read the server response message
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
            String message;
            message = (String) ois.readObject();
            System.out.println("Message: " + message);
            //close resources
            ois.close();
        }
        oos.close();
        Thread.sleep(100);

    }

}
