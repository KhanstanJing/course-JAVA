package Server;

import java.net.*;
import java.io.*;

public class Main_server {
    public static void main(String[] args) {
        ServerSocket socket = null;
        Socket s = null;
        try {
            socket = new ServerSocket(6606);
        } catch (IOException e) {e.printStackTrace();}
        System.out.println("Wait....");
        while(true) {
            try {
                s = socket.accept();
                new Thread(new Server(s)).start();
            } catch (IOException e) {e.printStackTrace();}
        }
    }
}
