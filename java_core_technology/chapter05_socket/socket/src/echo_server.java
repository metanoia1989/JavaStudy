import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class echo_server {
    public static void main(String[] args) {
        // establish server socket 
        try (ServerSocket s = new ServerSocket(8189)) {
            // wait for client connection 
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                
                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(outStream, true); 
                    out.print("Hello! Enter BYE to exit.");
                    
                    // echo client input
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    } 
}
