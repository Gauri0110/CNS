import java.net.*; import java.io.*; public class Server2 {     
public static void main(String args[]) throws IOException {         
byte[] buffer = new byte[3072];  
DatagramSocket dsoc = new DatagramSocket(1000);  
FileOutputStream fos = new FileOutputStream("testudp1.txt", true); // append mode         
while (true) {  
DatagramPacket dp = new DatagramPacket(buffer, buffer.length);             
dsoc.receive(dp);  
String received = new String(dp.getData(), 0, dp.getLength());  
System.out.println("Received: " + received);  
// Write to file             
fos.write(received.getBytes());             
} } } 
