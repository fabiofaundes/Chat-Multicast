import java.net.DatagramPacket;
import java.net.MulticastSocket;

public class RecebeMensagens extends Thread{

    private MulticastSocket ms;

    public RecebeMensagens(MulticastSocket ms) {
        this.ms = ms;
    }

    public void run(){
        while (!Thread.interrupted())
            try{
                byte[] buffer = new byte[8192];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData(), "8859_1");
                System.out.println(s);

            }catch (Exception e){
                System.err.println(e);
            }
    }
}
