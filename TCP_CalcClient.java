import java.net.*; import java.io.*; import java.util.*; 
public class CalcClient{   public static void 
main(String[]a)throws Exception{  
Socket s=new Socket("localhost",5000);  
BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));  
PrintWriter out=new PrintWriter(s.getOutputStream(),true);     
Scanner sc=new Scanner(System.in);     while(true){  
System.out.print("> ");       
exp=sc.nextLine();       
String 
out.println(exp);       
if(exp.equalsIgnoreCase("bye"))break;  
System.out.println("= "+in.readLine());  
}  
s.close();  }} 
