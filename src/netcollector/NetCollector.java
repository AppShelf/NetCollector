/*
 * NetCollector: tool client/server per raccogliere informazioni
 * di configurazione dei pc in rete.
 */

package netcollector;

import java.util.Scanner;

/**
 *
 * @author SistemiQuintaBi
 */
public class NetCollector {
    
    public static final int PORT = 1025;
    
    public static void main(String args[]) {

        Scanner lettore = new Scanner(System.in);
        System.out.println("Scegliere versione del programma da eseguire:");
        System.out.println("[S]erver");
        System.out.println("[C]lient");
        System.out.println("[T]ermina il server");
        String answer = lettore.nextLine();
        if ( answer.length()>0 && answer.toLowerCase().startsWith("s")) {
            Server server = new Server();
            server.run();
        } else if ( answer.length()>0 && answer.toLowerCase().startsWith("t")) {
            Terminator t = new Terminator();
            t.run();
        } else {
            Client client = new Client();
            client.run();
        }
        
    }

}
