import java.net.*; import java.io.*; public class 
CalcServer{   public static void 
main(String[]a)throws Exception{     ServerSocket 
ss=new ServerSocket(5000);     while(true){       
Socket s=ss.accept();       
new Thread(()->{  
try(BufferedReader in=new BufferedReader(new 
InputStreamReader(s.getInputStream()));  
PrintWriter out=new PrintWriter(s.getOutputStream(),true)){           
String line;           
while((line=in.readLine())!=null){             
if(line.equalsIgnoreCase("bye"))break;             
out.println(eval(line));  
}  
}catch(Exception e){}  
}).start();  
}  
}  
static double eval(String exp){     
exp=exp.replaceAll("\\s+","");  
if(exp.contains("+")){String[]p=exp.split("\\+");return 
Double.parseDouble(p[0])+Double.parseDouble(p[1]);}  
if(exp.contains("-")){String[]p=exp.split("\\-");return 
Double.parseDouble(p[0])Double.parseDouble(p[1]);}  
if(exp.contains("*")){String[]p=exp.split("\\*");return 
Double.parseDouble(p[0])*Double.parseDouble(p[1]);}  
if(exp.contains("/")){String[]p=exp.split("\\/");return 
Double.parseDouble(p[0])/Double.parseDouble(p[1]);}  
return 0;  
}  
} 
