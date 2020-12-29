import java.net.InetAddress;
import java.net.UnknownHostException;

public class inet_address_test {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                String host = args[0];
                InetAddress[] addresses = InetAddress.getAllByName(host);
                for (InetAddress a : addresses) {
                    System.out.println(a); 
                }
            } else {
                InetAddress localHostAddress = InetAddress.getLocalHost();
                System.out.println(localHostAddress);
            } 
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }    
}
