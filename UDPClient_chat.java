import java.net.*;   import java.io.*;   public class UDPClient {  
 public static void main(String args[])throws Exception {  
    DatagramSocket ds = new DatagramSocket();    
    BufferedReader br = new BufferedReader(new  
InputStreamReader(System.in));    
    byte[] s, r = new byte[1024];    
   String str = "", str2 = "";    
 while(!str.equals("stop")) {      
 str = br.readLine();         s = 
str.getBytes();    
      DatagramPacket dp = new DatagramPacket(s, s.length,  
InetAddress.getLocalHost(), 4000);    
      ds.send(dp);    
  
      DatagramPacket dp2 = new DatagramPacket(r, r.length);    
      ds.receive(dp2);    
      str2 = new String(dp2.getData(), 0, dp2.getLength());    
      System.out.println("Server says: " + str2);    
    }    
    ds.close();    
  } } 
