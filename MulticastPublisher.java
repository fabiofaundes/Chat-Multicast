import java.io.*;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastPublisher extends Thread{
    MulticastSocket ms;
    InetAddress group;
    String nomeUsuario;
    BufferedReader teclado;

    public MulticastPublisher(MulticastSocket ms, InetAddress group, String nomeUsuario, BufferedReader teclado) {
        this.ms = ms;
        this.group = group;
        this.nomeUsuario = nomeUsuario;
        this.teclado = teclado;
    }

    public void run(){
        try {
            byte[] buffer = null;

            while(true){
                System.out.println("Escreva a mensagem: ");
                String msg = teclado.readLine();

                /*
                Mensagem m = new Mensagem(msg, nomeUsuario);
                ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
                ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
                os.flush();
                os.writeObject(m);
                os.flush();

                buffer = byteStream.toByteArray();
                os.close();
                */

                buffer = msg.getBytes();
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, group, 12345);
                ms.send(pacote);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
