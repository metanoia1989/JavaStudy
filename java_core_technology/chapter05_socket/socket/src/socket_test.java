import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class socket_test {
    public static void main(String[] args) throws Exception {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13)) {
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);
            
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
