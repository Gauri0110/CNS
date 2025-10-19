import java.net.InetAddress;         // Interface for attribute sets import 
java.net.UnknownHostException;  // Provides directory operations (used for DNS) 
import javax.naming.NamingEnumeration;            // For iterating over naming elements 
import javax.naming.NamingException;              // Thrown for directory operation errors 
import javax.naming.directory.Attributes;                      // Represents IP address  
import javax.naming.directory.InitialDirContext;             // Thrown when IP address can't be  
determined  
  
public class DNS {     public static void 
main(String[] args) {  
        // Explain what program does and how to use it         
if (args.length != 1) {  
            System.err.println("Print out DNS Record for an Internet Address");  
            System.err.println("USAGE: java DNS domainName|domainAddress");  
            System.exit(-1); // A non-zero value indicates abnormal termination  
        }          
try {  
            InetAddress inetAddress;  
  
            // If first character is a digit, assume it's an IP address             
if (Character.isDigit(args[0].charAt(0))) {  
                // Convert address from string representation to byte array                 
String[] bytes = args[0].split("\\.");                 if (bytes.length != 4) {                     
throw new IllegalArgumentException("Invalid IP address format");                 }  
  
                byte[] b = new byte[4];                 for 
(int i = 0; i < 4; i++) {                     int part = 
Integer.parseInt(bytes[i]);                     if (part < 
0 || part > 255) {  
                        throw new IllegalArgumentException("IP address part out of range: " +  
bytes[i]);  
                    }                     
b[i] = (byte) part;  
                }  
  
                // Get Internet Address of this host address                 
inetAddress = InetAddress.getByAddress(b);  
            } else {  
                // Get Internet Address of this host name                 
inetAddress = InetAddress.getByName(args[0]);  
            }  
  
            // Show the Internet Address as name/address  
            System.out.println(inetAddress.getHostName() + "/" + 
inetAddress.getHostAddress());  
  
            // Get the default initial Directory Context  
            InitialDirContext iDirC = new InitialDirContext();  
  
            // Get the DNS records for inetAddress  
            Attributes attributes = iDirC.getAttributes("dns:/" + inetAddress.getHostName());  
  
            // Get an enumeration of the attributes and print them out  
            NamingEnumeration<?> attributeEnumeration = attributes.getAll();             
System.out.println("-- DNS INFORMATION --");             while 
(attributeEnumeration.hasMore()) {  
                System.out.println(attributeEnumeration.next());  
            }  
            attributeEnumeration.close();  
  
        } catch (UnknownHostException exception) {  
            System.err.println("ERROR: No Internet Address for '" + args[0] + "'");  
        } catch (NamingException exception) {  
            System.err.println("ERROR: No DNS record for '" + args[0] + "'");  
        } catch (IllegalArgumentException exception) {  
            System.err.println("ERROR: " + exception.getMessage());  
        }  
    }  
}  
 
