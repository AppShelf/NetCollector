/*
 * NetCollector Client
 */

package netcollector;

/**
 *
 * @author SistemiQuintaBi1617
 */

import java.io.*;
import java.net.*;

public class Client {

    Socket socket;
    String message;
    BufferedReader in;
    PrintWriter out;
    
    void run() {
        try {
            //1. creating a socket to connect to the server
            socket = new Socket("localhost", NetCollector.PORT);
            System.out.println("Connected to localhost, port " + NetCollector.PORT);
            //2. get Input and Output streams
            in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true );
               
            // prepariamo nella stringa message l'indirizzo IP
            message = Inet4Address.getLocalHost().getHostAddress();
            out.println(message);
            System.out.println(message);
            // prepariamo nella stringa message l'indirizzo MAC
            byte[] mac = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            message = sb.toString();
            out.println(message);
            System.out.println(message);
            // prepariamo nella stringa message lo user name
            message = System.getProperty("user.name");
            out.println(message);
            System.out.println(message);
            //4: Closing connection
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            System.err.println("ERRORE: " + ex.getMessage());
        } catch (IOError ex) {
            System.err.println("ERRORE: " + ex.getMessage());
        }
    }

}
