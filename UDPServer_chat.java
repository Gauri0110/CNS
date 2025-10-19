import java.net.*;   import java.io.*;   public class UDPServer {  
 public static void main(String args[])throws Exception {  
    DatagramSocket ds = new DatagramSocket(4000);  
    BufferedReader br = new BufferedReader(new  
InputStreamReader(System.in));  
    byte[] r = new byte[1024];    
    byte[] s;  
    String str = "", str2 = "";    
 while(!str.equals("stop")) {  
      DatagramPacket dp = new DatagramPacket(r, r.length);  
      ds.receive(dp);    
      str = new String(dp.getData(), 0, dp.getLength());    
      System.out.println("Client says: " + str);    
  
      str2 = br.readLine();    
     s = str2.getBytes();    
      DatagramPacket dp2 = new DatagramPacket(s, s.length, 
dp.getAddress(), dp.getPort());  
      ds.send(dp2);  
    }    
    ds.close();  
  }} 
