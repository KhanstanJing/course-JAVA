package Client;

import java.net.*;
import java.io.*;
 
public class Client {
    private String name;
    private int port;

    Client(String name, int port) {
        this.name = name;
        this.port = port;
    }

    public String work(String data) {
        String res = "Null";
        try {
            Socket c = new Socket(name,port);

            OutputStream outToServer = c.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF(data);

            InputStream inFromServer = c.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            res = in.readUTF();
            c.close();
        } catch (SocketException se) {;} catch(IOException e) {;}
        return res;
    }
}