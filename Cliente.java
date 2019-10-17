import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class Cliente{

    public static void main(String[] args) {
        try{
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            MulticastSocket ms = new MulticastSocket(12345);
            InetAddress group = InetAddress.getByName("224.0.0.1");
            SocketAddress mcastAddress = new InetSocketAddress(group, 12345);
            ms.joinGroup(group);

            MulticastReceiver receiver = new MulticastReceiver(ms);
            receiver.run();

            /*
            boolean continuar = true;
            while(continuar){
                if(receiver.hasNext()){
                    Mensagem m = receiver.getNext();
                    System.out.println(m.getRemetente() + ": " + m.getMensagem());
                }

            }*/

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
