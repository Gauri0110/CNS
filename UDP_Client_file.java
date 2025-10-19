import java.net.*; import java.io.*; public class Client2 {     
public static void main(String args[]) throws Exception {         
File file = new File("testudp1.txt");         
new byte[(int) file.length()];         
byte[] fileData = 
FileInputStream fis = 
new FileInputStream(file);         
fis.close();  
fis.read(fileData);         
DatagramSocket dsoc = new DatagramSocket();  
DatagramPacket packet = new DatagramPacket(fileData, fileData.length, 
InetAddress.getLocalHost(), 1000);         
dsoc.send(packet);         
System.out.println("File sent successfully.");  
dsoc.close();  
} } 
