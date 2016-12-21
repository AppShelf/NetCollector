/*
 * NetCollector Server
 */
package netcollector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author SistemiQuintaBi1617
 */
public class Server {

    ServerSocket serverSocket;
    Socket socket;
    BufferedReader in;
    PrintWriter out;
    String message;

    void run() {
        
        try {
            // apre il file in cui collezionare le informazioni ricevute
            PrintWriter log = new PrintWriter("data/NetCollector.txt");
            log.println("Nuova sessione.");
            
            // crea il socket server e si pone in ascolto
            serverSocket = new ServerSocket(NetCollector.PORT, 1024);
            
            while (true) {
                // mi pongo in ascolto di connessioni entranti
                System.out.println("Waiting for connection");
                socket = serverSocket.accept();
                System.out.println("Connection received from " + socket.getInetAddress().getHostName());
                // get Input and Output streams
                in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
                out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true );

                // servo la specifica richiesta
                String s = in.readLine();
                if (s.equalsIgnoreCase("QUIT")) break;
                log.println(s);
                System.out.println("client>" + s);
                s = in.readLine();
                log.println(s);
                System.out.println("client>" + s);
                s = in.readLine();
                log.println(s);
                System.out.println("client>" + s);
                socket.close();
                log.flush();
            }
            
            serverSocket.close();
            log.close();
            
        } catch (IOException ex) {
            System.out.println("ERRORE: " + ex.getMessage());
        }
        
    }

}
