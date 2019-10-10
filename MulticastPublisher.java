import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastPublisher extends Thread{
    public void run(){
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            byte[] buffer = null;
            InetAddress addr = InetAddress.getByName("224.0.0.1");
            MulticastSocket ms = new MulticastSocket();
            ms.joinGroup(addr);

            while(true){
                String msg = teclado.readLine();
                if(msg.equals("sai"))
                    break;

                buffer = msg.getBytes();
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, addr, 12345);
                ms.send(pacote);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
