package Server;

import java.net.*;
import java.io.*;
 
public class Server implements Runnable {
   private Operator opr;
   private DB data_base;
   private Socket s;
   
   Server(Socket s) {
      this.s = s;
      this.data_base = new DB();
      this.opr = new Operator();
   }

   public void run() {
      System.out.println("远程主机连接，地址为："+this.s.getRemoteSocketAddress());
      try {
         DataInputStream in = new DataInputStream(this.s.getInputStream());
         String rec = in.readUTF();
         System.out.println("发送命令："+rec);
         DataOutputStream out = new DataOutputStream(this.s.getOutputStream());
         if(opr.get_flag(rec).equals("1")) {
            data_base.db_exe(opr.get_sql(rec));
            out.writeUTF("done");
         } else {
            out.writeUTF(data_base.db_query(opr.get_sql(rec), opr.get_col(rec), opr.get_f(rec)));
         }
      } catch (IOException e) {}
   }

   public static void main(String[] args) {
      
   }
   
}