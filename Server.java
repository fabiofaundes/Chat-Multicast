import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Server {

    public static void main(String[] args) {
        try{
            MulticastSocket ms = new MulticastSocket();
            InetAddress group = InetAddress.getByName("224.0.0.1");
            ms.joinGroup(group);

            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("[SERVIDOR]: Digite seu nome");
            String nomeUsuario = teclado.readLine();

            MulticastPublisher publisher = new MulticastPublisher(ms, group, nomeUsuario, teclado);
            publisher.run();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
