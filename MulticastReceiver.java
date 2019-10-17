import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class MulticastReceiver extends Thread{
    MulticastSocket ms;
    Queue<Mensagem> fila;

    public MulticastReceiver(MulticastSocket ms){
        this.ms = ms;
        fila = new LinkedList<Mensagem>();
    }

    public void run(){
        try{
            while(true) {
                byte buffer[] = new byte[5000];
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
                ms.receive(pacote);

                /*
                int byteCount = pacote.getLength();
                ByteArrayInputStream byteStream = new ByteArrayInputStream(buffer);
                ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
                Object o = is.readObject();
                is.close();

                if(!(o instanceof Mensagem))
                    continue;

                Mensagem m = (Mensagem)o;
                fila.add(m);*/

                String s = new String(pacote.getData());
                System.out.println(s);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        /*catch (ClassNotFoundException e){
            e.printStackTrace();
        }*/
    }

    public boolean hasNext(){
        return !fila.isEmpty();
    }

    public Mensagem getNext() throws NoSuchElementException {
        return fila.element();
    }
}