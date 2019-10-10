import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver extends Thread{

    public void run(){
        try{
            MulticastSocket ms = new MulticastSocket(12345);
            InetAddress group = InetAddress.getByName("224.0.0.1");
            ms.joinGroup(group);

            while(true) {
                byte rec[] = new byte[256];
                DatagramPacket pacote = new DatagramPacket(rec, rec.length);
                ms.receive(pacote);
                String data = new String(pacote.getData());
                System.out.println("Dados recebidos:" + data);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}