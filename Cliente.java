import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente extends Thread{

    public static void main(String[] args) {
        new MulticastReceiver().run();
    }
}
