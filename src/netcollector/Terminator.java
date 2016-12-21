/*
 * Terminator: invia il messaggio di terminazione (quit) al server
 */
package netcollector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author sandr
 */
public class Terminator {

    Socket socket;
    BufferedReader in;
    PrintWriter out;


    void run() {
        try {
            socket = new Socket("localhost", NetCollector.PORT);
            System.out.println("Connected to localhost, port " + NetCollector.PORT);
            in = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true );
            out.println("QUIT");
            System.out.println("Comando di terminazione inviato al server!");
        } catch (Exception ex) {
            System.err.println("ERRORE: " + ex.getMessage());
        }
    }    
}
